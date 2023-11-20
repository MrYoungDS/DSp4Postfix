package evaluator.arith;

import evaluator.IllegalPostFixExpressionException;
import evaluator.Evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithPostFixEvaluatorTest {

    private Evaluator<Integer> evaluator;

    @BeforeEach
    public void setup() {
        evaluator = new ArithPostFixEvaluator();
    }

    @Test
    public void testEvaluateSimple() {
        Integer result = evaluator.evaluate("1");
        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testEvaluatePlus() {
        Integer result = evaluator.evaluate("1 2 +");
        assertEquals(Integer.valueOf(3), result);

        result = evaluator.evaluate("1 2 3 + +");
        assertEquals(Integer.valueOf(6), result);

        result = evaluator.evaluate("10000 1000 100 10 1 + + + +");
        assertEquals(Integer.valueOf(11111), result);
    }

    @Test
    public void testEvaluateSub() {
        Integer result = evaluator.evaluate("1 2 -");
        assertEquals(Integer.valueOf(-1), result);

        result = evaluator.evaluate("1 2 3 - -");
        assertEquals(Integer.valueOf(2), result);

        result = evaluator.evaluate("1000 100 10 1 - - -");
        assertEquals(Integer.valueOf(909), result);
    }

    @Test
    public void testEvaluateMult() {
        Integer result = evaluator.evaluate("1 2 *");
        assertEquals(Integer.valueOf(2), result);

        result = evaluator.evaluate("1 2 3 * *");
        assertEquals(Integer.valueOf(6), result);

        result = evaluator.evaluate("1 2 3 4 * * *");
        assertEquals(Integer.valueOf(24), result);
    }

    @Test
    public void testEvaluateNegate() {
        Integer result = evaluator.evaluate("1 !");
        assertEquals(Integer.valueOf(-1), result);

        result = evaluator.evaluate("2 !");
        assertEquals(Integer.valueOf(-2), result);

        result = evaluator.evaluate("-15 !");
        assertEquals(Integer.valueOf(15), result);
    }

    @Test
    public void testInvalidExpression() {
        assertThrows(IllegalPostFixExpressionException.class,
                () -> evaluator.evaluate("1 2"));
    }
}
