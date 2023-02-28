package java8.features.predefined.functional.interfacedemo;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
Predefined Functional Interfaces
-------------------
Predicate
Function
Consumer
Supplier

Two Argument Predefined Functional Interfaces
------------------------------
BiPredicate
BiFunction
BiConsumer

Primitive Functional Interfaces
----------------------------------
IntPredicate
IntFunction
IntConsumer
 */
public class PFIPredicate {

    public static void main(String[] args){
        Predicate<Integer> p1 = I -> I%2 == 0;
        System.out.println(p1.test(10));
        System.out.println(p1.test(15));

        //Write a predicate to check whether length of String is > 5 or not
        Predicate<String> p2 = str -> str.length() > 5;
        System.out.println(p2.test("vikas"));

        String[] s = {"Vikas", "Ranjana", "ALbert", "RameshG", "KiranJha"};
        Predicate<String> p3 = str->str.length()>5;
        for(String s1 : s){
            if(p3.test(s1)){
                System.out.println(s1);
            }
        }

    }
}

class Employee{
    String name;
    double salary;
    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
}

class Test{
    public static void main(String[] args){
        ArrayList<Employee> l = new ArrayList<Employee>();
        l.add( new Employee("Vikas", 1000));
        l.add( new Employee("Arjun", 2000));
        l.add( new Employee("Sachin", 3000));
        l.add( new Employee("Ramesh", 4000));
        l.add( new Employee("Shyam", 5000));
        Predicate<Employee> p = e->e.salary > 3000;
        for(Employee e1 : l){
            if(p.test(e1)){
                System.out.println(e1);
            }
        }
        // p1.and(p2).test(34)
        //p1.or(p2).test(35)
        //p1.negate()
        int[] x = {0, 5, 10, 15, 20, 25, 30, 35};
        Predicate<Integer> p1 = i -> i%2 ==0;
        Predicate<Integer> p2 = i -> i > 10;
        System.out.println("Numbers which are even and >10 are :");
        for(int x1 : x){
            if(p1.and(p2).test(x1))
                System.out.println(x1);
        }

        System.out.println("Numbers which are even or >10 are :");
        for(int x1 : x){
            if(p1.or(p2).test(x1))
                System.out.println(x1);
        }

        System.out.println("Numbers which are even or >10 are :");
        for(int x1 : x){
            if(p1.or(p2).test(x1))
                System.out.println(x1);
        }

        System.out.println("Numbers which are even :");
        for(int x1 : x){
            if(p1.test(x1))
                System.out.println(x1);
        }

        System.out.println("Numbers which are odd :");
        for(int x1 : x){
            if(p1.negate().test(x1))
                System.out.println(x1);
        }
    }
}