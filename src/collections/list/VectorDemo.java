import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args){
        Vector v = new Vector();
        System.out.println(v.capacity());
        for(int i = 0; i < 10; i ++){
            v.addElement(i);
        }
        System.out.println(v.capacity());
        v.addElement(10);
        System.out.println(v.capacity());

        Vector v1 = new Vector(25);
        System.out.println(v1.capacity());
        for(int i = 0; i < 25; i ++){
            v1.addElement(i);
        }
        System.out.println(v1.capacity());
        v1.addElement(10);
        System.out.println(v1.capacity());

        Vector v2 = new Vector(25, 5);
        System.out.println(v2.capacity());
        for(int i = 0; i < 25; i ++){
            v2.addElement(i);
        }
        System.out.println(v2.capacity());
        v2.addElement(10);
        System.out.println(v2.capacity());

        Enumeration enumElement = v2.elements();

        while(enumElement.hasMoreElements()){
            System.out.println(enumElement.nextElement());
        }

        Iterator itr = v2.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }
        System.out.println(s);

        ListIterator ltr = s.listIterator();
        while(ltr.hasNext()){

        }
    }
}