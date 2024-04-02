package DiamondProb;

public interface ChildB extends ParentInterface {

    @Override
    default void foo() {
        System.out.println("ChildB's foo");
    }
}
