import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println("original list is " +l);
        l.addFirst(10);
        l.addLast(20);
        System.out.println("After  adding first and last " + l);
        System.out.println("First element in LL is " + l.getFirst());
        System.out.println("last element in LL is " + l.getLast());
        l.removeFirst();
        System.out.println("After Removing First "+ l);
        l.removeLast();
        System.out.println("After removing last "+ l);
    }
}