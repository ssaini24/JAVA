import FinalOverriden.Child;
import FunctionalInterfacePkg.LambdaExpression;

import java.util.Collection;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

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

//        try {
//            TestingException.test();
//        } catch (MyCustomException e) {
//            throw new RuntimeException(e);
//        }

        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.canFlyLambdaImpl();
    }

    private static void update(Integer a){
        a = a+1;
    }
}