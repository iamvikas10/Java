package multithreading.adavanced.multithreading;

/*
Functions in ThreadLocal
1. Object get()                 -- returns the value of ThreadLocal variable associated with current thread
2. Object initialValue()        -- returns initial value of ThreadLocal variable associated with current thread,
                                   default is null, To change the default value we have to override this method
3. void set(Object newValue)    -- to set the new value of ThreadLocal variable associated with current thread
4. void remove()                -- to remove the value of ThreadLocal variable associated with current thread
                                   After removal, if we are trying to access it will be reinitialized once again by invoking its initialValue again
 */

public class ThreadLocalDemo {
    public static void main(String[] args){
        ThreadLocal t1 = new ThreadLocal(){
            public Object initialValue(){
                return "abc";
            }
        };
        System.out.println(t1.get());           //abc
        t1.set("Vikas");
        System.out.println(t1.get());           //vikas
        t1.remove();
        System.out.println(t1.get());           // abc
    }
}

class CustomerThread extends Thread{
    static Integer custId = 0;
    private static ThreadLocal tl = new ThreadLocal(){
        protected Integer initialValue(){
            return ++custId;
        }
    };

    CustomerThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() +" executing with customer id : " + tl.get());
    }
}

class ThreadLocalDemo2{
    public static void main(String[] args){
        CustomerThread c1 = new CustomerThread("Customer-Thread-1");
        CustomerThread c2 = new CustomerThread("Customer-Thread-2");
        CustomerThread c3 = new CustomerThread("Customer-Thread-3");
        CustomerThread c4 = new CustomerThread("Customer-Thread-4");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
