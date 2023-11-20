package evaluator;

/**
 * A {@link IllegalPostFixExpressionException} is thrown at runtime
 * when an invalid PostFixExpression is encountered.
 * @author jcollard, jddevaug
 */
public class IllegalPostFixExpressionException extends RuntimeException {

    // TONOTDO: please do not edit this class

    private static final long serialVersionUID = 1L;

    public IllegalPostFixExpressionException() {
        super();
    }

    public IllegalPostFixExpressionException(String message) {
        super(message);
    }
}