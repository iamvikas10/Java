package multithreading.adavanced.multithreading;


/*
void lock()
boolean tryLock()
boolean tryLock(long l, TimeUnit t)
void lockInterruptibly()
void unlock()

int getHoldCount()                      -- return number of locks held by current thread
boolean isHeldByCurrentThread()         -- return true if lock is held by current thread
int getQueueLength()                    -- returns no of threads waiting for the lock
Collection getQueuedThreads()           -- return Collection of threads which are waiting to get the lock
boolean hasQueuedThreads()              -- return True if any thread waiting to get the lock
boolean isLocked()                      -- return True if Lock is acquired by same thread
boolean isFair()                        -- return True if Fairness policy is set to True value
Thread getOwner                         -- return the owner which acquires the lock
 */


import java.util.concurrent.locks.ReentrantLock;

class Display{

    ReentrantLock l = new ReentrantLock(); //Using Reentrant lock instead of traditional Synchronized method
    public void wish(String name){
        l.lock();
        for(int i = 0; i < 10; i ++){
            System.out.println("Good Morning :");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            System.out.println(name);
        }
        l.unlock();
    }
}

class MyThread1 extends Thread{
    Display d;
    String name;
    MyThread1(Display d, String name){
        this.d = d;
        this.name = name;
    }
    public void run(){
        d.wish(name);
    }
}
class ReentrantLockDemo2{
    public static void main(String[] args){
        Display d = new Display();
        MyThread1 t1 = new MyThread1(d, "Vikas");
        MyThread1 t2 = new MyThread1(d, "Vikram");
        t1.start();
        t2.start();
    }
}
public class ReentrantLockDemo {
    public static void main(String[] args){
        ReentrantLock l = new ReentrantLock();
        l.lock();
        l.lock();
        System.out.println(l.isLocked());                       // true
        System.out.println(l.isHeldByCurrentThread());          // True
        System.out.println(l.getQueueLength());                 // 0
        l.unlock();
        System.out.println(l.getHoldCount());                   // 1
        System.out.println(l.isLocked());                       // True
        l.unlock();
        System.out.println(l.isLocked());                       // False
        System.out.println(l.isFair());                         // False
    }
}
