import java.util.Comparator;
import java.util.TreeSet;

import java.util.*;

class MyComparator implements Comparator{

    //    @Override
//    public int compare(Object o1, Object o2) {
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;
//        if(i1 < i2) return 1;
//        else if(i1 > i2) return -1;
//        else return 0;
//    }
    //Possible way of compare Function
    @Override
    public int compare(Object obj1, Object obj2){
        Integer i1 = (Integer) obj1;
        Integer i2 = (Integer) obj2;
        //return i1.compareTo(i2);  //DNSO --> ascending order [0,5,10,15,20]
        //return -i1.compareTo(i2); //descending order [20, 15, 10, 5, 0]
        //return i2.compareTo(i1); //descending order [20, 15, 10, 5, 0]
        //return -i2.compareTo(i1); //ascending order [0,5,10,15,20]
        //return 1; // insertion order [10, 0, 15, 5, 20, 20]
        //return -1; // reverse of insertion order [20, 20, 5, 15, 0, 10]
        return 0; // only first element will be inserted, rest all elements are duplicates [10]
    }
}

class StringComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1; // if original object is String
        String s2 = o2.toString(); // if original object is StringBuffer
        //return -s1.compareTo(s2); //[Sheetal, Romi, Raman, Raja, Gagandeep]
        return s2.compareTo(s1); //[Sheetal, Romi, Raman, Raja, Gagandeep]
    }
}

class StringBufferComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s1.compareTo(s2);
    }
}

class HeterogeneousComparator implements Comparator{
    @Override
    public int compare(Object obj1, Object obj2){
        String s1 = obj1.toString();
        String s2 = obj2.toString();
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 < l2) return -1;
        else if(l1 > l2) return 1;
        else return s1.compareTo(s2);
    }
}

class Employee implements Comparable{

    String name;
    int eid;
    public Employee(String name, int eid){
        this.name = name;
        this.eid = eid;
    }

    public String toString(){
        return name + " --" + eid;
    }

    @Override
    public int compareTo(Object o) {
        int eid1 = this.eid;
        Employee e = (Employee) o;
        int eid2 = e.eid;
        if(eid1 < eid2) return -1;
        else if (eid1 > eid2) return 1;
        else return 0;
    }
}

class EmployeeComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        int l1 = e1.name.length();
        int l2 = e2.name.length();
        if(l1 < l2) return -1;
        else if(l1 > l2) return 1;
        else return 0;
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new MyComparator());
        t.add(10);
        t.add(0);
        t.add(15);
        t.add(5);
        t.add(20);
        t.add(20);
        System.out.println(t);

        // String objects in tree set where all elements should be inserted according to reverse of alphabetic order
        TreeSet t1 = new TreeSet(new StringComparator());
        t1.add("Raja");
        t1.add("Sheetal");
        t1.add("Raman");
        t1.add("Gagandeep");
        t1.add("Romi");
        System.out.println(t1); // DNSO -- alphabetical sorting

        //adding StringBuffer objects in
        TreeSet t2 = new TreeSet(new StringBufferComparator());
        t2.add(new StringBuffer("A"));
        t2.add(new StringBuffer("Z"));
        t2.add(new StringBuffer("K"));
        t2.add(new StringBuffer("L"));
        System.out.println(t2);

        //program to add String and string buffer objects where sorting order is increasing length
        //if two objects have same length then consider their alphabetical order
        TreeSet t4 = new TreeSet(new HeterogeneousComparator());
        t4.add("A");
        t4.add(new StringBuffer("ABC"));
        t4.add(new StringBuffer("AA"));
        t4.add("XX");
        t4.add("ABCD");
        t4.add("A");
        System.out.println(t4);

        //Employee
        Employee e1 = new Employee("vikas", 100);
        Employee e2 = new Employee("shamsher", 30);
        Employee e3 = new Employee("ritu", 10);
        Employee e4 = new Employee("suraj", 300);
        Employee e5 = new Employee("chuiii", 150);

        TreeSet t5 = new TreeSet();
        t5.add(e1);
        t5.add(e2);
        t5.add(e3);
        t5.add(e4);
        t5.add(e5);
        System.out.println(t5);

        TreeSet t6 = new TreeSet(new EmployeeComparator());
        t6.add(e1);
        t6.add(e2);
        t6.add(e3);
        t6.add(e4);
        t6.add(e5);
        System.out.println(t6);

    }
}