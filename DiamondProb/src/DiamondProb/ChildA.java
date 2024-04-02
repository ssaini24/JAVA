package DiamondProb;

public interface ChildA extends ParentInterface {
    @Override
    default void foo() {
        System.out.println("ChildA's foo!");
    }
}
