package com.thread.examples;

class SlideRotator extends Thread{
    //public static native void sleep(long ms) throws InterruptedException
    //public static void sleep(long ms, int ns) throws InterruptedException

    //Every sleep method throws InterruptedException, so we must handle it by try catch or with throws
}
public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException{
        for(int i = 0; i <= 10; i ++){
            System.out.println("Slide " + i);
            Thread.sleep(5000);
        }
    }
}
