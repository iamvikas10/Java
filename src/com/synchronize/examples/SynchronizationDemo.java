package com.synchronize.examples;

class Display{
    public synchronized void wish(String name){
        for(int i = 0; i < 10; i ++){
            System.out.println("Good Morning : " +name);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(name);
            }
        }
    }

    public static synchronized void wishCase2(String name){
        //regular output
        //if a thread is executing static synchronized method, then the thread needs class level lock,
        //that's why we will have regular output
        for(int i = 0; i < 10; i ++){
            System.out.println("Good Morning : " +name);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(name);
            }
        }
    }

    public synchronized void display(){
        for(int i =1; i <= 10; i++){
            System.out.println(i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public synchronized void displayc(){
        for(int i = 65; i <= 75; i++){
            System.out.println((char) i);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){

            }
        }
    }
}

class MyThread extends Thread{
    Display d;
    String name;
    MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    public void run(){
        d.wishCase2(name);
    }
}

class MyThread1 extends Thread{
    Display d;
    MyThread1(Display d){
        this.d = d;
    }
    public void run(){
        d.display();
    }
}

class MyThread2 extends Thread{
    Display d;
    MyThread2 (Display d){
        this.d = d;
    }

    public void run(){
        d.displayc();
    }
}
public class SynchronizationDemo {
    public static void main(String[] args){
//        Display d = new Display();
//        MyThread t1 = new MyThread(d, "Vikas");
//        MyThread t2 = new MyThread(d, "Ram");
//        MyThread t3 = new MyThread(d, "Ranjana");
//        MyThread t4 = new MyThread(d, "Shyam");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

//        Display d1 = new Display();
//        Display d2 = new Display();
//        MyThread t1 = new MyThread(d1, "Vikas");
//        MyThread t2 = new MyThread(d2, "Ram");
//        t1.start();
//        t2.start();

        //if multiple threads are operating on same java object, then synchronization is required
        //if multiple threads are operating on multiple java object, then synchronization is not required
        Display d = new Display();
        MyThread1 t1 = new MyThread1(d);
        MyThread2 t2 = new MyThread2(d);
        t1.start();
        t2.start();
    }
}
