package com.example.classloadingdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import impl.Service;

@Configuration
public class Config {
    
    // @Bean(initMethod = "start")
    // ServiceThread getService() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{ 

    //     System.out.println("parent classLoader:" + Thread.currentThread().getContextClassLoader().toString());
    //     URL[] urls = {new URL("http://127.0.0.1:8080/apps/myservice-1.0-SNAPSHOT.jar")};
    //     URLClassLoader cl = 
    //         new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
            
    //     //Class clazz = cl.loadClass("impl.MyService");
    //     Class clazz = Class.forName("impl.MyService", true, cl);
    //     Service service = (Service)clazz.newInstance();        

    //     ServiceThread st = new ServiceThread(service);
    //     return st;
    // }

}
