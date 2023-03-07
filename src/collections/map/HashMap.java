import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    }
}