package com.thread.examples;

class ThreadNoRun extends Thread{
    //if we are not over riding run method, then thread class run method will be executed which has empty
    //implementation and we will not get any output, so if we are not overriding the run method, then
    //we should not go for multi threading

}

class DemoThread extends Thread{
    //not recommened to override start method otherwise don't go for multithreading
    public void start(){
        super.start();
        System.out.println("start method");
    }//overriding start method will stop ThreadClass start method just like a normal method call and new
    //thread will not be created
    public void run(){
        System.out.println("Child Thread");
    }
}
class MyThread extends Thread{
    public void run(){
        //job of thread inside run method we are supposed to implement the job of thread
        for(int i = 0; i < 10; i ++){
            System.out.println("Child Thread");
        }
    }

    //can run method be overloaded
    public void run(int i){
        System.out.println(i);
    } //it can be overloaded, but t.start() will trigger only run() method, to execute this method, we have to call it like normal methods
}

public class ThreadDemoWithThreadClass{
    public static void main(String[] args){
        MyThread t = new MyThread(); // thread instantiation
        //main thread starts the child thread
        t.start(); //starting of a thread it will call Thread class start method which will eventually execute
        //our run method
        //uncomment below line for running program with 1 thread
        //t.run();// new thread will not be created and run method will be executed like normal method call with main thread
        //2 threads are there. 1 main thread, 1 child thread
        //the below code is executed by main thread
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
        }

        DemoThread demoThread = new DemoThread();
        demoThread.start();

    }
}