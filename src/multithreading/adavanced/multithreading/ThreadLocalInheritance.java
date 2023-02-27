package multithreading.adavanced.multithreading;


/*
ThreadLocal VS Inheritance

1. Parent Thread threadLocal variable by default not available to child thread
2. If we want to make parent thread ThreadLocal variable value available to child thread then we should go
    for InheritableThreadLocal class
3. By default, child thread value is exactly same as parent thread value
4. But we can provide customized for child thread by Overriding childValue() method


Constructor:
    InheritableThreadLocal tl = new InheritableThreadLocal()

InheritableThreadLocal is a child class of ThreadLocal and hence all methods of ThreadLocal are by default available to
InheritableThreadLocal

In addition to those, it contains one more method

public Object childValue(Object parentValue)

 */
class ParentThread extends Thread{
    static InheritableThreadLocal tl = new InheritableThreadLocal(){
        public Object childValue(Object p){
            return "CC";
        }
    };
    //Instead of ThreadLocal go for InheritableThreadLocal
    public void run(){
        tl.set("pp");
        System.out.println("Parent Value : " + tl.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}
class ChildThread extends Thread{
    public void run(){
        System.out.println("child value : " + ParentThread.tl.get());
    }
}
public class ThreadLocalInheritance {

    public static void main(String[] args){
        ParentThread pt = new ParentThread();
        pt.start();
    }
}
