package multithreading.adavanced.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThread2 extends Thread{
    static ReentrantLock l = new ReentrantLock(); //only 1 lock will be created
    MyThread2(String name){
        super(name);
    }

//    public void run(){
//        if(l.tryLock()){
//            System.out.println(Thread.currentThread().getName() +" got lock and executing safe operations");
//            try{
//                Thread.sleep(2000);
//            }catch (InterruptedException e){
//
//            }
//            l.unlock();
//        }else{
//            System.out.println(Thread.currentThread().getName() +" unable to get lock and hence performing alternative operations");
//        }
//    }

    public void run(){
        do {
            try {
                if (l.tryLock(5000, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " got lock and executing safe operations");
                    Thread.sleep(30000);
                    System.out.println(Thread.currentThread().getName() + " releases lock");

                    l.unlock();
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " unable to get lock and hence performing alternative operations");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(true);
    }
}
public class ReentrantLockAdvancedDemo {
    public static void main(String[] args){
        MyThread2 t1 = new MyThread2("FirstThread");
        MyThread2 t2 = new MyThread2("SecondThread");
        t1.start();
        t2.start();
    }
}
