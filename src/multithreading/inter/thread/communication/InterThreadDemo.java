package multithreading.inter.thread.communication;
class ThreadA extends Thread{
    /*method signatures for wait, notify and notifyall
    Every wait method throws IE which is a checked exception which is supposed to be handled compulsory

    public final void wait() throws InterruptedException
    public final native void wait() throws InterruptedException
    public final void wait(long ms, int ns) throws InterruptedException

    public final native void notify()
    public final native void notifyAll()
    */
    int total = 0;
    public void run(){
        synchronized (this) {
            for (int i = 0; i <= 100; i++) {
                total = total + i;
            }
            ;
            ;
            ;
            ;
            ;
            ;//1 crore lines of code
            System.out.println("Child thread trying to give notification");
            this.notify(); // will throw IllegalMonitorStateException if not under synchronized aread
        }
    }
}
public class InterThreadDemo {

    public static void main(String[] args) throws InterruptedException{
        ThreadA a = new ThreadA();
        a.start();
        //Thread.sleep(10000); //should not be used
        //a.join(); //should not be used. reference to 1 crore lines of code
        synchronized (a) {
            System.out.println("Main Thread trying to call wait() method");
            a.wait();
            System.out.println("Main Thread got notification");
            System.out.println(a.total);
        }
        /* output can be 0, 5050 or 0<x<5050 depending on the which thread
        * */

    }
}
