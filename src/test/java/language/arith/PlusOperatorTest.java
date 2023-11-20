package language.arith;

import language.Operand;
import language.Operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlusOperatorTest {
    private Operator<Integer> operator;
    private Operand<Integer> op0;
    private Operand<Integer> op1;

    /**
     * Runs before each test.
     */
    @BeforeEach
    public void setup() {
        operator = new PlusOperator();
        op0 = new Operand<Integer>(5);
        op1 = new Operand<Integer>(7);
    }

    @Test
    public void testPerformOperation() {
        operator.setOperand(0, op0);
        operator.setOperand(1, op1);

        Operand<Integer> result = operator.performOperation();
        int value = result.getValue();
        assertEquals(5 + 7,  value, "Operator applied to 5 and 7 should produce 12.");
    }

    @Test
    public void testGetNumberOfArguments() {
        assertEquals(operator.getNumberOfArguments(), 2, "Binary operator should have 2 arguments.");
    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> operator.setOperand(2, op0),
                "Binary operator should not except input to position 2");
    }

    @Test
    public void testNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> operator.setOperand(0, null),
                "Operator should not allow null arguments");
    }

    @Test
    public void testIllegalStateException() {
        operator.setOperand(0, op0);
        assertThrows(IllegalStateException.class,
                () -> operator.setOperand(0, op0),
                "Operator should not allow position 0 to be set more than once");
    }

    @Test
    public void testIllegalStateExceptionPerform() {
        assertThrows(IllegalStateException.class,
                () -> operator.performOperation(),
                "Operator should not compute when all arguments have not been set.");
    }
}
