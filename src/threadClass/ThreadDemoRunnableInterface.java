package threadClass;

//defining a thread with Runnable interface
class MyRunnable implements Runnable{

    //executed by child thread
    @Override
    public void run() {
        for(int i = 0; i < 10; i ++){
            System.out.println("Child Thread");
        }
    }
}
public class ThreadDemoRunnableInterface {
    public static void main(String[] args){
        MyRunnable r = new MyRunnable();
        //myrunnable don't have start method, so we have to create a thread
        Thread t1 = new Thread(r); //target runnable
        //if we don't pass any argument, it will thread class run method which has empty implementation
        //so we pass target runnable to execute the myRunnable run method
        t1.start();
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
        }
    }
}
