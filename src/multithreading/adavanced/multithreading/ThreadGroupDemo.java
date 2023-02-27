package multithreading.adavanced.multithreading;
/*
ThreadGroup is a java class present in java.lang, and it is a direct child class of Object

Constructors of ThreadGroup are :-

1. ThreadGroup g = new ThreadGroup(String GroupName)

    e.g., ThreadGroup g = new ThreadGroup("First Group")
            g will be child group of thread executing this group
2. ThreadGroup g = new ThreadGroup(ThreadGroup parentGroup, String groupName)
    e.g., ThreadGroup g1 = new ThreadGroup(g, "Second-Group")

Important Methods of ThreadGroup class:
    1. String getName()                 -- return name of thread group
    2. int getMaxPriority()             -- return max priority of thread group
    3. void setMaxPriority(int p)       -- to set maximum priority of thread group (default max Priority is 10)
    4. ThreadGroup getParent()          -- return parent group of current thread
    5. void list()                      -- information about thread group to console
    6. int activeCount()                -- return number of active threads present in thread group
    7. int activeGroupCount()           -- return number of active groups present in current thread group
    8. int enumerate(Thread[] t)        -- to copy all active threads of thread group into provided thread array, subthreadGroups threads also will be considered
    9. int enumerate(ThreadGroup[] g)   -- to copy all active sub thread groups into threadGroup array
    10. boolean isDaemon()
    11. void setDaemon(boolean b)
    12. void interrupt()                -- to interrupt all waiting threads
    13. void destroy()                  -- to destroy thread and its sub thread groups
 */

class MyThread extends Thread{
    MyThread(ThreadGroup g, String name){
        super(g, name);
    }

    public void run(){
        System.out.println("Child Thread");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
    }
}

class ThreadGroupDemo2{
    public static void main(String[] args) throws InterruptedException{
        ThreadGroup pg = new ThreadGroup("ParentGroup");
        ThreadGroup cg = new ThreadGroup(pg, "ChildGroup");
        MyThread t1 = new MyThread(pg, "ChildThread1");
        MyThread t2 = new MyThread(pg, "ChildThread2");
        t1.start();
        t2.start();

        //Program to fetch the active threads from System
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread[] t = new Thread[system.activeCount()];
        system.enumerate(t);
        for(Thread x : t){
            System.out.println(x.getName() +"...." + x.isDaemon());
        }

        System.out.println(pg.activeCount()); //2
        System.out.println(pg.activeGroupCount()); //1
        pg.list();
        Thread.sleep(10000);
        System.out.println(pg.activeCount()); //0
        System.out.println(pg.activeGroupCount()); //1
        pg.list();
    }
}
public class ThreadGroupDemo {
    public static void main(String[] args){
        //Every thread in java is part of a thread group
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        //System is parent of every ThreadGroup. Every ThreadGroup in java is a child group of System Group
        //Hence system group is root of all threadGroup in java
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        ThreadGroup g = new ThreadGroup("First Group");
        System.out.println(g.getParent().getName());
        ThreadGroup g1 = new ThreadGroup(g, "Second Group");
        System.out.println(g1.getParent().getName());


        Thread t1 = new Thread(g1, "First Thread");
        Thread t2 = new Thread(g1, "Second Thread");
        g1.setMaxPriority(3); //maxPriority will be affecting only new threads, previous threads will still be having previous priority
        Thread t3 = new Thread(g1, "Third Thread");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        //Threads in threadGroup that have already higher priority won't be affected but for newly added thread, this max
        //priority is applicable

    }
}
