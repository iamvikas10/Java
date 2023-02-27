package multithreading.daemon.threads;
/*
We can check daemon nature of thread by using isDaemon() method of Thread class
        public boolean isDaemon()

We can change Daemon nature of a thread by using setDaemon method
        public void setDaemon(Boolean b)

    but changing daemon nature is possible before starting of a thread only. After starting a thread, if we are trying to
    change the daemon nature we will get runtime Exception (IllegalThreadStateException)

By Default: main thread is always Non-daemon
            remaining threads, daemon nature will be inherited from parent to child i.e., if parent is daemon, then child
            is also daemon and if parent is non daemon, then automatically child thread is also non daemon

It is impossible to change the nature of main Thread (As JVM starts it at beginning)

Once last non daemon thread terminates, all daemon threads are killed/terminated irrespective of their stage/position
 */
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Child Thread running");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }
    }
}
public class DaemonThreads {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().isDaemon());
        //Thread.currentThread().setDaemon(true); //IllegalThreadStateException
        MyThread t = new MyThread();
        System.out.println(t.isDaemon());
        t.setDaemon(true);
        System.out.println(t.isDaemon());
        t.start();
        System.out.println("End of Main Thread");
    }
}
