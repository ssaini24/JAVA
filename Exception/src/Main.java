import ExceptionPkg.MyCustomException;
import ExceptionPkg.TestingException;
import FinalOverriden.Child;
import FunctionalInterfacePkg.LambdaExpression;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // on creating child object, internally parent object is created first, leads in
        // invoking parent class constructor.
        Child child = new Child(23);

        System.out.println(child.toString());


        // A lambda expression for functional interface
        Predicate<Integer> isEven = (Integer val) -> {
            if (val%2 == 0)
                return true;

            return false;
        };

        // A anonymous implementation for functional interface
        Predicate<Integer> isEvenAnon = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };

        Integer a = 10;
        update(a);
        System.out.println(a);

        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));

        System.out.println(Integer.compare(1,2));

//       // uncomment below to check exception behaviour
//        try {
//            // checked & custom exception must needs to be handled with try catch or to be thrown
//            TestingException.customException();
//        } catch (MyCustomException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("finally will get executed if we return from function in try/catch but will never execute if an exception occurred");
//        }
//
//        // unchecked exception could be handled or be thrown
//        TestingException.runTimeException();

        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.canFlyLambdaImpl();

        Queue<Integer> queue =  new LinkedList<>();
        queue.add(2);
    }

    private static void update(Integer a){
        a = a+1;
    }
}