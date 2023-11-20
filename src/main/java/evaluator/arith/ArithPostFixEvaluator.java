package evaluator.arith;

import evaluator.Evaluator;
import evaluator.IllegalPostFixExpressionException;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.StackInterface;
import stack.LinkedStack;
import stack.StackUnderflowException;

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator
 * over simple arithmetic expressions.
 */
public class ArithPostFixEvaluator implements Evaluator<Integer> {

    private final StackInterface<Operand<Integer>> stack;

    /**
     * Constructs an {@link ArithPostFixEvaluator}.
     */
    public ArithPostFixEvaluator() {
        stack = null; //TODO Initialize to your LinkedStack
    }

    /**
     * Evaluates a postfix expression.
     * @return the result
     */
    @Override
    public Integer evaluate(String expr) {
        // TODO Use all the things built so far to create
        //   the algorithm for post fix evaluation
        ArithPostFixParser parser = new ArithPostFixParser(expr);
        while (parser.hasNext()) {
            switch (parser.nextType()) {
                case OPERAND:
                    //TODO What do we do when we see an operand?
                    break;
                case OPERATOR:
                    //TODO What do we do when we see an operator?
                    break;
                default:
                    //TODO If we get here, something went very wrong
            }
        }

        //TODO What do we return?
        return null;
    }
}
