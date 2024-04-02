package DiamondProb;

public class InterfaceImp implements ChildA, ChildB {
    // giving exception here, must have to implement foo() here
    @Override
    public void foo() {
        System.out.println("must implement & override foo here");
    }
}
