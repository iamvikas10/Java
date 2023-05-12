package multithreading.adavanced.multithreading;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd"); //Called Once for each thread
        }

        @Override
        public SimpleDateFormat get(){
            return super.get();     //1st call = initialValue() Subsequent calls will return same initialized value
        }
    };
}
public class ThreadLocalUseCase {
    public String birthDate(int userId){
        Date birthDate = Date.valueOf("2021-11-01");
        final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();  // Each thread will get its own copy
        return df.format(birthDate);
    }

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String birthdate = new ThreadLocalUseCase().birthDate(100);
            System.out.println(birthdate);
        }).start();

        new Thread(()->{
            String birthDate = new ThreadLocalUseCase().birthDate(100);
            System.out.println(birthDate);
        }).start();

        for(int i = 0; i < 10; i ++){
            int id = 1;
            new Thread(()->{
                String birthDate = new ThreadLocalUseCase().birthDate(100);
                System.out.println(birthDate);
            }).start();
        }

        for(int i = 0; i < 1000; i ++){
            int id = 1;
            threadPool.submit(()->{
                String birthDate = new ThreadLocalUseCase().birthDate(100);
                System.out.println(birthDate);
            });
        }
        Thread.sleep(1000);

    }
}
