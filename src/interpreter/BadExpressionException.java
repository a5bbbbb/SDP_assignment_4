package interpreter;

public class BadExpressionException extends Exception {
    public BadExpressionException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
