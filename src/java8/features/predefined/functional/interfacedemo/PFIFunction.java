package java8.features.predefined.functional.interfacedemo;

import java.util.function.Function;

public class PFIFunction {
    public static void main(String[] args){
        Function<Integer, Integer> f = i -> i*i;
        System.out.println(f.apply(4));
        System.out.println(f.apply(5));

        Function<String, Integer> f1 = str -> str.length();
        System.out.println(f1.apply("Vikas"));

        Function<String, String> f2 = str -> str.toUpperCase();
        System.out.println(f1.apply("Vikas"));
    }
}

class Student{
    String name;
    int marks;
    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
}

class TestDemo{
    public static void main(String[] args){
        //Student --> findGrade ---->ReturnGrade
        Function<Student, String> f = s->{
            int marks = s.marks;
            String grade = "";
            if(marks > 85) grade = "A";
            else if(marks >= 60) grade = "B";
            else if(marks >= 50) grade = "C";
            else if(marks >= 35) grade = "D";
            else grade = "E";
            return  grade;
        };

        Student[] s = {
                new Student("Vikas", 85),
                new Student("Anita", 75),
                new Student("Ranjan", 65),
                new Student("Shyam", 55),
                new Student("Albert", 21),
                new Student("Alexis", 100)
        };

        for(Student s1 : s){
            System.out.println("Student name : " + s1.name);
            System.out.println("Student name : " + s1.marks);
            System.out.println("Student name : " + f.apply(s1));

        }

        //function chaining
        //f1.andThen(f2).apply(i) -- first f1 then f2
        //f1.compose(f2).apply(i) -- first f2 and then f1
        Function<Integer, Integer> f1 = i-> 2*i;
        Function<Integer, Integer> f2 = i-> i*i*i;
        System.out.println(f1.andThen(f2).apply(2));
        System.out.println(f1.compose(f2).apply(2));
    }
}
