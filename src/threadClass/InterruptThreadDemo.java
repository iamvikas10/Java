package threadClass;

class ThreadInterrupt extends Thread{
    //A thread can interrupt a sleeping or waiting thread by using Interrupt method of Thread class
    //public void interrupt() -- thread class method
    public void run(){
        try{
            for(int i = 0; i < 10; i ++){
                System.out.println("I am lazy thread");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("I am Getting Interrupted");
        }
    }
}

class ThreadInterruptCase extends Thread{
    public void run(){
        for(int i =0; i < 10000; i++){
            System.out.println("I am a lazy thread" + i);
        }
        System.out.println("I am entering sleeping state");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("I am getting interrrupted");
        }

    }
}
public class InterruptThreadDemo {
    public static void main(String[] args){
        ThreadInterrupt t = new ThreadInterrupt();
        t.start();
        t.interrupt(); //main thread interrupts child thread

        ThreadInterruptCase t1 = new ThreadInterruptCase();
        t1.start();
        t1.interrupt();

        /* Whenever we are calling interrupt method and target is not in sleeping/waiting state, then
        * there is no impact of interrupt call immediately. Interrupt call be waited until target thread
        * enter into sleeping or waiting state
        *
        * If target enter into sleeping or waiting state, then immediately interrupt call will interrupt
        * the target thread
        *
        * If target never entered into sleeping or waiting state in its lifetime, then there is no impact of interrupt call,
        * this is the only case where interrupt all will be wasted
        * */
        System.out.println("End of Main Thread");

    }
}
