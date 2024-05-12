package generics;

public class GenericClass<T,K> {
    private T val;
    private K val2;

    public void setValue(T value){
        val = value;
    }

    public T getValue(){
        return val;
    }
}
