package generics;

public class GenericBoundedClass<T extends Number> {
    private T val;

    public void setValue(T value){
        val = value;
    }

    public T getValue(){
        return val;
    }
}
