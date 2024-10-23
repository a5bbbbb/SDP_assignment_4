package interpreter;

public class NumberExpression implements ExpressionInterface{
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(ContextInterface interpreterContext) {
        return number;
    }
}
