package java8.features.predefined.functional.interfacedemo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
interface Consumer<T>{
    public void accept(T t)
}

Take Some Input and perform some conditional check and return boolean value --> Predicate
Take some input and perform some operation and return the result which need not be of boolean type --> Function
Accept some input and perform required operation and not required to return anything --> Consumer
 */
public class PFIConsumer {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("vikas");
    }

}

class Stud{
    String name;
    int marks;
    Stud(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
}

class TestDemo1 {
    public static void main(String[] args) {
        //Student --> findGrade ---->ReturnGrade
        Function<Stud, String> f = s -> {
            int marks = s.marks;
            String grade = "";
            if (marks > 85) grade = "A";
            else if (marks >= 60) grade = "B";
            else if (marks >= 50) grade = "C";
            else if (marks >= 35) grade = "D";
            else grade = "E";
            return grade;
        };

        Stud[] s = {
                new Stud("Vikas", 85),
                new Stud("Anita", 75),
                new Stud("Ranjan", 65),
                new Stud("Shyam", 55),
                new Stud("Albert", 21),
                new Stud("Alexis", 100)
        };
        Predicate<Stud> p = s1->s1.marks >= 60;
        Consumer<Stud> consumer = s2 ->{
            System.out.println("Student name : " + s2.name);
            System.out.println("Student name : " + s2.marks);
            System.out.println("Student name : " + f.apply(s2));
        };
        for (Stud s1 : s) {
            if(p.test(s1)) {
                consumer.accept(s1);
            }
        }

        //function chaining
        //f1.andThen(f2).apply(i) -- first f1 then f2
        //f1.compose(f2).apply(i) -- first f2 and then f1
        Function<Integer, Integer> f1 = i -> 2 * i;
        Function<Integer, Integer> f2 = i -> i * i * i;
        System.out.println(f1.andThen(f2).apply(2));
        System.out.println(f1.compose(f2).apply(2));
    }
}
