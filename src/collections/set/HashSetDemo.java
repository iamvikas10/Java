import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetDemo {
    public static void main(String[] args){
        HashSet h = new HashSet();
        h.add(1);
        h.add(2);
        h.add(null);
        h.add('a');
        System.out.println(h);

        LinkedHashSet h1 = new LinkedHashSet();
        h1.add(1);
        h1.add(2);
        h1.add(null);
        h1.add('a');
        System.out.println(h1);
    }
}