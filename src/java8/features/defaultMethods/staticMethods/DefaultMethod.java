package java8.features.defaultMethods.staticMethods;
/*
Until 1.7V

Every method present inside interface is always : Public and abstract

void m1();
public void m1();
abstract void m1();
public abstract void m1();

1.8V
    default methods + static methods
1.9V
    private methods
Variables
    public static final // every variable irrespective of version


Default Method/ Virtual Extension Method / Defender Method
----------------------------------------------------------
default method cannot be defined in classes
default method cannot be used to override Object method

Without affecting implementation classes if we want to add new methods to the interface
 (Extending interface functionality) ==> default Methods

To define general utility methods inside interface with static

 */
public class DefaultMethod {
}
