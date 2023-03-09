package collections.map;

import java.util.HashMap;

class Temp{
    public String toString() {
        return "Temp";
    }

//    public void finalize(){
//        System.out.println("Finalized method called");
//    }
}

public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        HashMap m = new HashMap();
        Temp t = new Temp();
        m.put(t, "vikas");
        t = null;
        System.out.println(m);
        System.gc();
        Thread.sleep(5000);
        System.out.println(m);

        java.util.WeakHashMap m1 = new java.util.WeakHashMap();
        m1.put(t, "vikas");
        t = null;
        System.out.println(m1);
        System.gc();
        Thread.sleep(5000);
        System.out.println(m1);

    }
}