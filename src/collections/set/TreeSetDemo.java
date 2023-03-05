import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args){
        TreeSet t = new TreeSet();
        t.add("a");
        t.add("b");
        t.add("z");
        t.add("Z");
        t.add("A");
        //t.add(1); //ClassCastException
        //t.add(null); //Null Pointer Exception
        //for non empty tree set if we are trying to insert null, we will get NPE
        //If we are adding null as first element, it will be added, but as soon as we enter next element then we will
        //NPE
        //* from 1.7 version even adding null as first element is not allowed
        System.out.println(t);
        /*
            TreeSet t1 = new TreeSet();
            t1.add(new StringBuffer("a"));
            t1.add(new StringBuffer("b"));
            t1.add(new StringBuffer("c"));
            t1.add(new StringBuffer("d"));
            t1.add(new StringBuffer("e"));

            System.out.println(t1);

            //if we are depending on DNSO, objects need to be homogenous and comparable
        */
    }
}