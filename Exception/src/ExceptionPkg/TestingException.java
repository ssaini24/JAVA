package ExceptionPkg;

public class TestingException {
    public static  void test() throws MyCustomException {
        throw new MyCustomException("a exception");
    }
}
