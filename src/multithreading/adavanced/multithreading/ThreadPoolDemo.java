package multithreading.adavanced.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class PrintJob implements Runnable{
    String name;
    PrintJob(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + "...Job started by Thread : " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        System.out.println(name +"... Job Completed by thread : " + Thread.currentThread().getName());
    }
}
public class ThreadPoolDemo  {
    public static void main(String[] args){
        PrintJob[] jobs = {
                new PrintJob("Vikas"),
                new PrintJob("Shamsher"),
                new PrintJob("Shiva"),
                new PrintJob("Swati"),
                new PrintJob("Sooraj"),
                new PrintJob("Anil")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        //3 threads are responsible for 6 jobs so that a single thread can be used for multiple jobs
        for(PrintJob job: jobs){
            service.submit(job);
        }
        service.shutdown();
    }
}
