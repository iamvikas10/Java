package collections.list;

import java.util.Arrays;
import java.util.Comparator;

class StringComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        String s1 = (String) o1;
        String s2 = (String) o2;
        return s2.compareTo(s1);
    }
}
public class ArraysClassDemo {
    public static void main(String[] args){
        int[] a = {10, 5, 20, 11, 6};
        System.out.println("Primitive Array before sorting");
        for(int a1 : a){
            System.out.print(a1 +",");
        }
        Arrays.sort(a);
        System.out.println();
        System.out.println("Primitive Array after sorting");
        for(int a1 : a){
            System.out.print(a1 +",");
        }
        System.out.println();

        String[] s ={"A", "Z", "B"};
        Arrays.sort(s, new StringComparator());
        for(String s1: s){
            System.out.print(s1+",");
        }
    }
}
