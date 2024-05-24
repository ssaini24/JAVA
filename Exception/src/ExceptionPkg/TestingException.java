package ExceptionPkg;

public class TestingException {
    public static  void customException() throws MyCustomException {
        throw new MyCustomException("an custom exception occurred");
    }

    public static  void runTimeException() {
        throw new RuntimeException("an runtime exception");
    }
}
