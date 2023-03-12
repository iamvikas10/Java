package collections.map;

import java.util.Comparator;
import java.util.TreeMap;

class CustomComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1);
    }
}

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap m = new TreeMap();
        m.put(100, "ZZZ");
        m.put(103, "YYY");
        m.put(101, "XXX");
        m.put(104, 106);
//        m.put("FFF", "XXX"); //ClassCastException
//        m.put(null, "XXX"); //NullPointerException
        System.out.println(m);

        TreeMap m1 = new TreeMap(new CustomComparator());
        m1.put("XXX", 10);
        m1.put("AAA", 20);
        m1.put("ZZZ", 30);
        m1.put("LLL", 40);
        System.out.println(m1);
    }
}