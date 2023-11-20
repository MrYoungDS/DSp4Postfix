package language.arith;

import language.Operand;
import language.Operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NegateOperatorTest
{
    Operator<Integer> operator;
    Operand<Integer> op0;
    Operand<Integer> op1;

    /**
     * Runs before each test.
     */
    @BeforeEach
    public void setup()
    {
        operator = new NegateOperator();
        op0 = new Operand<Integer>(5);
        op1 = new Operand<Integer>(7);
    }

    @Test
    public void testPerformOperation()
    {
        operator.setOperand(0, op0);

        Operand<Integer> result = operator.performOperation();
        int value = result.getValue();
        assertEquals(-5, value, "Operator applied to 5 should produce -5.");
    }

    @Test
    public void testPerformOperationNegative()
    {
        operator.setOperand(0, new Operand<Integer>(-7));

        Operand<Integer> result = operator.performOperation();
        int value = result.getValue();
        assertEquals(7, value, "Operator applied to -7 should produce 7.");
    }

    @Test
    public void testGetNumberOfArguments()
    {
        assertEquals(operator.getNumberOfArguments(), 1, "Unary operator should have 1 argument.");
    }

    @Test
    public void testIllegalStateException()
    {
        operator.setOperand(0, new Operand<Integer>(5));
        assertThrows(IllegalStateException.class,
                () -> operator.setOperand(0, new Operand<Integer>(12)),
                "Operator should not allow the same operand position to be set more than once");
    }

    @Test
    public void testIllegalStateExceptionPerform()
    {
        assertThrows(IllegalStateException.class,
                () -> operator.performOperation(),
                "Operator should not compute when all arguments have not been set.");
    }

    @Test
    public void testIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class,
                () -> operator.setOperand(2, op0),
                "Unary operator should not except input to position 2");
    }

    @Test
    public void testNullArgumentException()
    {
        assertThrows(NullPointerException.class,
                () -> operator.setOperand(0, null),
                "Operator should not allow null arguments");
    }
}
