package FunctionalInterfacePkg;

public class LambdaExpression {

    public LambdaExpression(){
    }
    public void canFlyLambdaImpl() {
        FunctionInterface functionInterfaceImpl = ()->
                System.out.println("implementing canFly through lambda expression");
        functionInterfaceImpl.canFly();
    }
}
