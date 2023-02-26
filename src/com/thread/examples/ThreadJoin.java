package com.thread.examples;

class VenueFixing implements Runnable{
    static Thread venueThread;

    @Override
    public void run() {
        venueThread = Thread.currentThread();
        Thread.currentThread().setName("Venue Fixing Thread");
        for(int i = 0; i < 10; i ++){
            System.out.println("Venue is getting fixed");
        }
    }
}

class WeddingCardsPrint implements Runnable{
    static Thread printThread;
    @Override
    public void run() {
        try {
            printThread = Thread.currentThread();
            VenueFixing.venueThread.join();
            Thread.currentThread().setName("Wedding Cards Print Thread");
            for (int i = 0; i < 10; i++) {
                System.out.println("Wedding card are getting printed");
            }
        }catch(InterruptedException e){

        }
    }
}

class WeddingCardsDistribution implements Runnable{
    static Thread cardThread;
    @Override
    public void run() {
        cardThread = Thread.currentThread();
        try {
            WeddingCardsPrint.printThread.join();
            Thread.currentThread().setName("Wedding Cards Distribute Thread");
            for (int i = 0; i < 10; i++) {
                System.out.println("Wedding cards are getting distributed");
            }
        }catch(InterruptedException e){

        }
    }
}
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException{
        VenueFixing r1 = new VenueFixing();
        Thread t1 = new Thread(r1);

        WeddingCardsPrint r2 = new WeddingCardsPrint();
        Thread t2 = new Thread(r2);

        WeddingCardsDistribution r3 = new WeddingCardsDistribution();
        Thread t3 = new Thread(r3);

        t1.start();
        //t1.join(10000); //main thread is waiting for child thread to finish
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
            //Thread.sleep(2000);
        }
        t2.start();
        t3.start();
    }
}
