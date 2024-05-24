package FinalOverriden;

public class Child extends Parent {

    int age;
    public Child(int age){
        System.out.println("in child");
    }

    @Override
    public String toString(){
        return "hello!";
    }
}
