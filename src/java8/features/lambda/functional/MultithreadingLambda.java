package java8.features.lambda.functional;

class MyRunnable implements Runnable{
    public void run(){
        for(int i =0; i < 10; i ++){
            System.out.println("Child Thread");
        }
    }
}
public class MultithreadingLambda {
    public static void main(String[] args){
        MyRunnable r = new MyRunnable();

        Runnable r1 = ()->{
            for(int i = 0; i < 10; i ++){
                System.out.println("Child Thread");
            }
        };
        Thread t = new Thread(r1);
        t.start();
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
        }
    }
}
