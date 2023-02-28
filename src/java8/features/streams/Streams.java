package java8.features.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    /*
    If we want to represent a group of objects as a single entity then we should go for collection
    If we want to process objects from the collection, then we should go for stream

    Stream s = c.stream();  //java.util.stream pkg
    --------------------------------------
    stream()
    filter(Predicate)   -- return the stream
            i/p : 10 elements
            o/p : 0 to 10 or <= 10
    map(Function)
            i/p : 10 elements
            o/p : 10
    collect():
            to collect the results

    count() : how many elements are there in stream
        marks.stream().filter(m -> m < 35).count()
    sorted():to sort the list
    --------------------------------------
    descending method sorting:
            (i1, i2) -> i1 < i2 ? 1 : i1 > i2 ? -1 : 0
    Comparator --> compare(Obj 1, Obj2)
            # returns (-) ve iff obj1 has to come before obj2
            # returns (+) ve iff obj1 has to come after obj2
            #return 0 if obj1 and obj2 are equal

    Default sorting uses Comparable
    Comparable interface
            compareTo()
    filter based on marks: Select only passed students
    marks.stream().filter(m->m>=35)

    5 grace marks
    failedStudents.stream().map(i -> i+5)
     */
    public static void main(String[] args){
        ArrayList<Integer> marks = new ArrayList<Integer>();
        marks.add(70);
        marks.add(45);
        marks.add(10);
        marks.add(65);
        marks.add(20);
        marks.add(25);
        System.out.println(marks);
        List<Integer> newList =  marks.stream().filter(i->i%2 == 0).collect(Collectors.toList());
        System.out.println(newList);
        //add grace marks for every student
        List<Integer> updatedMarks = marks.stream().map(i->i+5).collect(Collectors.toList());
        System.out.println(updatedMarks);
        long noOfFailedStudents = marks.stream().filter(m -> m < 35).count();
        System.out.println(noOfFailedStudents);
        List<Integer> sortedList = marks.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        List<Integer> sortedListDesc = marks.stream().sorted((i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0)
                .collect(Collectors.toList());
        System.out.println(sortedListDesc);

        List<Integer> sortedListDescN = marks.stream().sorted((i1, i2)->- i2.compareTo(i1)).collect(Collectors.toList());
        System.out.println(sortedListDescN);

        ArrayList<String> l = new ArrayList<String>();
        l.add("Sunny");
        l.add("Kajol");
        l.add("Katrina");
        l.add("Alia");
        l.add("Madhuri");
        System.out.println(l);
        List<String> sl = l.stream().sorted().collect(Collectors.toList());
        System.out.println(sl);
        /*
        (s1,s2)  --> s1.compareTo(s2)      ===> Natural Sorting Order
        (s1, s2) --> s2.compareTo(s1)      ===> reverse of Natural Sorting Order
        (s1, s2) --> s1.compareTo(s2)      ===> reverse of Natural Sorting Order
         */
        List<String> sl1 = l.stream().sorted((s1,s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        System.out.println(sl1);
        //based on string length
        Comparator<String> c = (s1, s2) ->{
            int l1 = s1.length();
            int l2 = s2.length();
            if(l1 < l2) return -1;
            else if(l1 > l2) return 1;
            else return s1.compareTo(s2);
        };
        List<String> sl2 = l.stream().sorted(c).collect(Collectors.toList());
        System.out.println(sl2);

        /*
        for min and max we have to compulsory to do sorting,
        min and max are not based on values but based on position
        min(Comparator)
            [1,2,3,4,5] -- Min = 1  Max = 5
            [5,4,3,2,1] -- min = 5 max = 1

        max(Comparator)
         */
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(0);
        l1.add(15);
        l1.add(5);
        l1.add(20);
        System.out.println(l);
        Integer min = l1.stream().min((i1, i2) -> -i1.compareTo(i2)).get();
        System.out.println(min);
        Integer max = l1.stream().max((i1, i2) -> -i1.compareTo(i2)).get();
        System.out.println(max);
        Consumer<Integer> f = i->{
            System.out.println("The square of " + i + "is " + i*i);
        };
        l1.stream().forEach(f);

        /*
        To convert stream of objects into array

        toArray()
         */
        Integer[] i = l1.stream().toArray(Integer[]::new);
        for(Integer i1 : i){
            System.out.println(i1);
        }
        Stream.of(i).forEach(System.out :: println);

        Stream<Integer> s = Stream.of(9, 99, 999, 9999, 99999);
        s.forEach(System.out:: println);
    }
}
/*
stream()
filter()
map()
collect()
count()
sorted()
sorted(Comparator)
min(Comparator)
max(Comparator)
forEach()
toArray()
Stream.of():
    * where ever group of elements, arrays are there we can go for streams
 */