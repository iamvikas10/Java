package java8.features.lambda.functional;

import java.util.ArrayList;
import java.util.Collections;

class Employee{
    String name;
    int eno;
    Employee(String name, int eno){
        this.name = name;
        this.eno = eno;
    }

    public String toString(){
        return this.name + ": " + this.eno;
    }
}
public class InnerClassLambda {
    public static void main(String[] args){
        ArrayList<Employee> l = new ArrayList<Employee>();
        l.add( new Employee("Vikas", 200));
        l.add( new Employee("Arjun", 101));
        l.add( new Employee("Sachin", 302));
        l.add( new Employee("Ramesh", 103));
        l.add( new Employee("Shyam", 404));
        System.out.println(l);
        Collections.sort(l, (e1, e2) -> (e1.eno < e2.eno)? -1:(e1.eno > e2.eno) ? 1:0);
        System.out.println(l);
        Collections.sort(l, (e1, e2) -> (e1.name.compareTo(e2.name)));
        System.out.println(l);
    }
}

class AnonymousInnerClass{
    /*
    1. Anonymous Inner class can extend a normal class
    2. Anonymous Inner class can extend an abstract class
    3. Anonymous Inner class can implement an interface which contains any number of abstract methods

    Lambda Expression can implement an interface which contains a single abstract method (FI)
     */
    public static void main(String[] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i ++){
                    System.out.println("Child Thread");
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
        }
    }
}

class LambdaReplaceAnnonymousInnerClass{
    public static void main(String[] args){
        Runnable r =()->{
                for(int i = 0; i < 10; i ++){
                    System.out.println("Child Thread");
                }
        };

        Thread t = new Thread(r);
        t.start();
        for(int i = 0; i < 10; i ++){
            System.out.println("Main Thread");
        }
    }
}
