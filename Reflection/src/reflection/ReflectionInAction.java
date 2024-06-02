package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionInAction {

    public static void reflectionInAction(){
        Class reflectionMethods = ConcreteClass.class;

        for (Method method : reflectionMethods.getMethods()){
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getModifiers());
        }
    }

    public static void setPrivateField(){
        ConcreteClass concreteObj = new ConcreteClass();
        Class classObj = concreteObj.getClass();

        Field field;
        try {
            field = classObj.getDeclaredField("foo");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        field.setAccessible(true);
        try {
            field.set(concreteObj, "settedPrivate");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(concreteObj.getFoo());
    }
}
