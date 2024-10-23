package interpreter;

public interface InterpreterInterface {
    int interpret(String rawExpression) throws BadExpressionException;
}
