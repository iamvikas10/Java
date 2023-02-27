package java8.features.lambda.functional;

@FunctionalInterface
public interface FunInterface {
    public void m1();
    default void m2(){

    }
    static void m3(){

    }
}
@FunctionalInterface
interface B extends FunInterface{
    //it is also perfectly valid, automatically parent method is available here
    //public void m2(); -->cannot define another function
    public void m1(); //this is valid
}

interface C extends B{
    public void m2(); //this is valid
}

