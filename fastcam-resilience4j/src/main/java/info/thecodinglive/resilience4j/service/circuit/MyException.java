package info.thecodinglive.resilience4j.service.circuit;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
