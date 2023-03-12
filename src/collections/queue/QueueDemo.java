package collections.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = o2.toString();
        return s2.compareTo(s1);
    }
}
public class QueueDemo {
    public static void main(String[] args){

        /*
            1. boolean offer(Object o)              -- to add an object into the queue
            2. Object peek()                        -- to return head element of the queue. if queue is empty then this
                                                        method returns null
            3. Object element()                     -- to return head element of the queue. if queue is empty then this
                                                        method returns raises RE: NoSuchElementException
            4. Object poll()                        -- to remove and return head element of the queue
            5. Object remove()


         */
        PriorityQueue q = new PriorityQueue();
//        System.out.println(q.peek()); //null
//        System.out.println(q.element()); //RunTimeException
        for(int i = 0; i < 10; i++){
            q.offer(i);
        }

        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);

        PriorityQueue cq = new PriorityQueue(15, new MyComparator());
        cq.offer("A");
        cq.offer("Z");
        cq.offer("L");
        cq.offer("B");
        System.out.println(cq);
    }
}
