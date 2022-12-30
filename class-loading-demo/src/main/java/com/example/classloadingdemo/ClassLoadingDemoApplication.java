package com.example.classloadingdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import impl.Service;

@SpringBootApplication
public class ClassLoadingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassLoadingDemoApplication.class, args);
	}

	@Bean(initMethod = "start")
    ServiceThread getService() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{ 

        System.out.println("parent classLoader:" + Thread.currentThread().getContextClassLoader().toString());
        

		URL[] urls = {
			new URL("http://127.0.0.1:8080/apps/myservice-1.0-SNAPSHOT.jar"),
			new URL("http://127.0.0.1:8080/apps/commons-math3-3.6.1.jar")
		};

        URLClassLoader cl = 
            new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
            
        //Class clazz = cl.loadClass("impl.MyService");
        Class clazz = Class.forName("impl.MyService", false, cl);
        Service service = (Service)clazz.newInstance();        

        ServiceThread st = new ServiceThread(service);
        return st;
    }

}
