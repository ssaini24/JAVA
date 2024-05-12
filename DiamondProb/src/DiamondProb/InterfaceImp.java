package DiamondProb;

public class InterfaceImp implements ChildA, ChildB {
    // giving exception here, must have to implement foo() here (solution to diamond prob)
    public void foo() {
        System.out.println("must implement & override foo here");
    }
}
