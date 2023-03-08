import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        java.util.HashMap m = new java.util.HashMap();
        m.put("vikas", 700);
        m.put("pramender", 800);
        m.put("Shanky", 200);
        m.put("Aditya", 500);
        System.out.println(m);
        System.out.println(m.put("vikas", 800)); // will update the old value with new value and return old value
        Set s = m.keySet();
        System.out.println(s);
        Collection c = m.values();
        System.out.println(c);
        Set s1 = m.entrySet();
        System.out.println(s1);
        Iterator itr = s1.iterator();
        while(itr.hasNext()){
            Map.Entry m1 = (Map.Entry)itr.next();
            System.out.println(m1.getKey() + "....." + m1.getValue());

            if(m1.getKey().equals("vikas")){
                m1.setValue(10000);
            }
        }
        LinkedHashMap m1 = new LinkedHashMap();
        m1.put("vikas", 700);
        m1.put("pramender", 800);
        m1.put("Shanky", 200);
        m1.put("Aditya", 500);
        System.out.println(m1);
    }
}