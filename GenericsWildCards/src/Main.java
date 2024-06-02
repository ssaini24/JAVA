import generics.GenericBoundedClass;
import generics.GenericClass;

public class Main {
    public static void main(String[] args) {
        GenericClass<Integer, String> genericClass = new GenericClass<>();
        genericClass.setValue(23);
        System.out.println(genericClass.getValue());

        // generic method
        genericClass.genericMethod(23.02f, "23");

        // raw type object
        GenericClass rawType = new GenericClass();
        rawType.setValue("");

        // bounded generic class trying passing string
        // error
        //  GenericBoundedClass<String> boundedClass = new GenericBoundedClass<String>();
        // fine
        GenericBoundedClass<Integer> boundedClass1 = new GenericBoundedClass<Integer>();


    }
}