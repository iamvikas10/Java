package java8.features.lambda.functional;

/*
The main objective of Lambda Expressions:
    * to bring the benefits of functional programming into java

e.g., 1
    public void m1(){
        System.out.println("Hello");
    }

    //converting above method to lambda expression
    () -> {System.out.println("Hello, Lambda Expression");}

e.g., 2
    public void m2(int a, int b){
        System.out.println(a+b);
    }
    // if compiler can guess the types automatically, we can remove the types
    (a,b) -> System.out.println(a+b);

e.g., 3
    public int squareIt(int n){
        return n*n;
    }

    (int n) -> {return n*n;}            //within curly braces return is required
    (int n) -> n*n;                     //without curly braces, we cannot use return keyword, compiler will consider returned value automatically
    n -> n*n;                           //if there is only one parameter, then we don't need to put ()

 e.g., 4
    public int m3(String s){
        return s.length();
    }

    s->s.length();

How to call Lambda Expressions ?

FI ==> FunctionalInterface
*/

class LambdaDemo implements FunInterface{
    public void m1(){
        System.out.println("hello");
    }

}
public class LambdaExpressions {
    public static void main(String[] args){
        FunInterface demo = new LambdaDemo();
        FunInterface i = () -> System.out.println("hello, Lambda Expression");
        demo.m1();
        i.m1();

        SumInterface s = (a,b) -> System.out.println(a+b);
        s.add(10, 20);
        //write the points whatever there on the screen in your notes pages with pen
        SquareInterface squareInterface = n -> n * n;
        squareInterface.squareIt(5);
    }
}
