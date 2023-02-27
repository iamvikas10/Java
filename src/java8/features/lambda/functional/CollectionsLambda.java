package java8.features.lambda.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComparator implements Comparator<Integer>{
    public int compare(Integer I1, Integer I2){
        return (I1 < I2) ? -1:(I1 > I2) ? 1 : 0;
    }
}
public class CollectionsLambda {
    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(20);
        l.add(10);
        l.add(25);
        l.add(5);
        l.add(30);
        l.add(0);
        l.add(15);
        System.out.println(l);
        Comparator<Integer> res = (I1, I2) ->(I1 < I2) ? -1:(I1 > I2) ? 1 : 0;
        Collections.sort(l, res);
        System.out.println(l);
    }
}
