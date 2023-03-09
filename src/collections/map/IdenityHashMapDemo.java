package collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdenityHashMapDemo {
    
    public static void main(String[] args) {
        HashMap m = new HashMap();
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(20);
        m.put(i1, "vikas");
        m.put(i2, "Sanyam");
        System.out.println(m); //HashMap uses .equals() method to find the duplicate keys

        IdentityHashMap m1 = new IdentityHashMap();
        m1.put(i1, "vikas");
        m1.put(i2, "Sanyam");
        System.out.println(m1); //IdentityHashMap uses == operator to find the duplicate keys

    }
}