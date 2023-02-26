package com.synchronize.examples;

class Disp {
    public void wish(String name) {
        ;;;;;;;;//1 lakh lines of code
        synchronized (Display.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Good Morning : " + name);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(name);
                }
            }
        }
        ;;;;;;//1 lAkh lines of code
    }
}

class MyThread3 extends Thread{
    Disp d;
    String name;
    MyThread3(Disp d, String name){
        this.d = d;
        this.name = name;
    }
    public void run(){
        d.wish(name);
    }
}
public class SynchronizerBlock {
    public static void main(String[] args){
        Disp d1 = new Disp();
        Disp d2 = new Disp(); //for regular use class level lock
        MyThread3 t1 = new MyThread3(d1, "Sanyam");
        MyThread3 t2 = new MyThread3(d2, "Sunita");
        t1.start();
        t2.start();
    }
}
