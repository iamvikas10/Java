package multithreading.deadlock.starvation;

class A{

    //play with synchronized keyword
    public synchronized  void d1(B b){
        System.out.println("Thread 1 execution of d1 method");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        System.out.println("Thread 1 trying to call B's last method");
        b.last();
    }

    public synchronized void last(){
        System.out.println("Inside A, last() method");
    }
}

class B{
    public synchronized  void d2(A a){
        System.out.println("Thread 2 execution of d2 method");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        System.out.println("Thread 2 trying to call A's last method");
        a.last();
    }

    public synchronized void last(){
        System.out.println("Inside B, last() method");
    }
}

class MyThread extends Thread{
    A a = new A();
    B b = new B();
    public void m1(){
        this.start();
        a.d1(b); //main thread is executing this
    }

    public void run(){
        b.d2(a); //child thread is executing this
    }
}

public class DeadlockDemo {

    public static void main(String[] args){
        MyThread t = new MyThread();
        t.m1();
    }
}
