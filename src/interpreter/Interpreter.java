package interpreter;

public class Interpreter implements InterpreterInterface{
    private ContextInterface context;

    public Interpreter(ContextInterface context) {
        this.context = context;
    }

    @Override
    public int interpret(String rawExpression) throws BadExpressionException {

        ExpressionInterface expressionTree = buildExpressionTree(rawExpression);

        return expressionTree.interpret(context);
    }

    private ExpressionInterface buildExpressionTree(String rawExpression) throws BadExpressionException {
        Integer curNum = null;

        for(int i = 0; i < rawExpression.length(); i++){

            char c = rawExpression.charAt(i);

            if(c == ' ')continue;

            if(Character.isDigit(c))
                curNum = curNum == null? c - '0' : curNum + c - '0';

            else{

                if(curNum == null)
                    throw new BadExpressionException("Can't interpret operation without two operands. Index = " + (rawExpression.length() - 1));

                if(c == '-')
                    return new SubtractionExpression(
                            new NumberExpression(curNum),
                            buildExpressionTree(rawExpression.substring(i+1))
                    );

                else
                    return new AdditionExpression(
                            new NumberExpression(curNum),
                            buildExpressionTree(rawExpression.substring(i+1))
                    );

            }
        }

        if(curNum == null)
            throw new BadExpressionException("Can't interpret operation without two operands. Index = " + (rawExpression.length() - 1));

        return new NumberExpression(curNum);
    }
}
