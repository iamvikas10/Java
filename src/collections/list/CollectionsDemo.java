package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class IntComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        if(i1 < i2) return 1;
        else if(i1 > i2) return -1;
        else return 0;
    }
}
public class CollectionsDemo {
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(1);
        l.add(23);
        l.add(11);
        Collections.sort(l);
        System.out.println(l);
        System.out.println(Collections.binarySearch(l, 10));
        System.out.println(Collections.binarySearch(l, 0));
        Collections.reverse(l);
        System.out.println("Reverse -" + l);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(1);
        l1.add(23);
        l1.add(11);
        Collections.sort(l1, new IntComparator());
        System.out.println(l1);
        System.out.println(Collections.binarySearch(l1, 10, new IntComparator()));
        System.out.println(Collections.binarySearch(l1, 0, new IntComparator()));
    }
}
