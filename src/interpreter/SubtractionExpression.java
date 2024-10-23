package interpreter;

public class SubtractionExpression implements ExpressionInterface{
    private final ExpressionInterface left;
    private final ExpressionInterface right;

    public SubtractionExpression(ExpressionInterface left, ExpressionInterface right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(ContextInterface interpreterContext) {
        return left.interpret(interpreterContext) - right.interpret(interpreterContext);
    }
}

