import java.io.Serializable;
import java.util.*;

public class ArrayListDemo{
    public static void main(String[] args){
        ArrayList l = new ArrayList();
        l.add(1);
        l.add("Vikas");
        l.add(1, "Mango"); //inserts at a particular postion
        l.add(null);
        l.addAll(Collections.singleton(new int[]{1, 2, 3, 4})); // to add a collection
        l.add(2);
        l.add(3);
        l.add(2);
        l.remove("Vikas");
        System.out.println(l.indexOf(2));
        System.out.println(l.lastIndexOf(2));
        System.out.println(l);

        //Example 2: Removing Duplicates from ArrayList
        ArrayList<Integer> arrayInteger = new ArrayList<>();
        arrayInteger.add(1);
        arrayInteger.add(2);
        arrayInteger.add(3);
        arrayInteger.add(4);
        arrayInteger.add(2);
        
        System.out.println(arrayInteger);
        HashSet<Integer> s = new HashSet<>(arrayInteger);
        System.out.println(s);

        //Example 3:
        ArrayList l1 = new ArrayList();
        LinkedList l2 = new LinkedList();
        System.out.println(l1 instanceof Serializable);
        System.out.println(l1 instanceof Cloneable);
        System.out.println(l2 instanceof Serializable);
        System.out.println(l2 instanceof Cloneable);
        System.out.println(l1 instanceof RandomAccess);
        System.out.println(l2 instanceof RandomAccess);

        //ArrayList is non synchronized while vector are synchornized. To get synchornized arrayList, we can use the
        //synchornizedList method of Collections.

        ArrayList l3 = new ArrayList();
        List synchronizedList = Collections.synchronizedList(l3);
        //public static List synchronizedList(List l) -- signature of synchronized list
        //public static Set synchronizedSet(Set s)
    }
}