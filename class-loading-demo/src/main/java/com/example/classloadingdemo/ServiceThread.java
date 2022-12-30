package com.example.classloadingdemo;

import impl.Service;

public class ServiceThread implements Runnable {

    Service service;

    Thread thread;
    
    boolean running = false;
    
    public ServiceThread(Service service) {
        this.service = service;
    }

    public synchronized void start(){
        if(thread != null){
            stop();
            thread = null;
        }
        thread = new Thread(this, "ServiceThread");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        thread.interrupt();        
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        running = true;
        while(Thread.currentThread() == thread){
            
            try {
                System.out.println("thread context class loader:"+ Thread.currentThread().getContextClassLoader());
                // thread context class loader:org.springframework.boot.devtools.restart.classloader.RestartClassLoader@239e0f9a

                System.out.println("service class loader:"+ service.getClass().getClassLoader());
                // service class loader:java.net.URLClassLoader@4601610c

                service.service();
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
	
}