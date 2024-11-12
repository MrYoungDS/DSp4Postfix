package language.arith;

import language.Operand;
import language.Operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubOperatorTest {
    Operator<Integer> operator1;
    Operand<Integer> op0;
    Operand<Integer> op1;

    /**
     * Runs before each test.
     */
    @BeforeEach
    public void setup() {
        operator1 = new SubOperator();
        op0 = new Operand<>(5);
        op1 = new Operand<>(7);
    }

    @Test
    public void testPerformOperation() {
        operator1.setOperand(0, op0);
        operator1.setOperand(1, op1);

        Operand<Integer> result = operator1.performOperation();
        int value = result.getValue();
        assertEquals(-2,  value, "Operator applied to 5 and 7 should produce -2.");
    }

    @Test
    public void testPerformOperationNegative() {
        operator1.setOperand(0, new Operand<>(5));
        operator1.setOperand(1, new Operand<>(-7));

        Operand<Integer> result = operator1.performOperation();
        int value = result.getValue();
        assertEquals(12, value, "Operator applied to 5 and -7 should produce 12.");
    }

    @Test
    public void testPerformOperationZeroPosition0() {
        operator1.setOperand(0, new Operand<>(0));
        operator1.setOperand(1, new Operand<>(7));

        Operand<Integer> result = operator1.performOperation();
        int value = result.getValue();
        assertEquals(-7, value, "Operator applied to 0 and 7 should produce -7.");
    }

    @Test
    public void testPerformOperationZeroPosition1() {
        operator1.setOperand(0, new Operand<>(5));
        operator1.setOperand(1, new Operand<>(0));

        Operand<Integer> result = operator1.performOperation();
        int value = result.getValue();
        assertEquals(5, value, "Operator applied to 5 and 0 should produce 5.");
    }

    @Test
    public void testGetNumberOfArguments() {
        assertEquals(operator1.getNumberOfArguments(), 2,
                "Binary operator should have 2 arguments.");
    }

    @Test
    public void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> operator1.setOperand(2, op0),
                "Binary operator should not except input to position 2");
        assertThrows(IllegalArgumentException.class,
                () -> operator1.setOperand(-1, op0),
                "Binary operator should not except input to position -1");
    }

    @Test
    public void testNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> operator1.setOperand(0, null),
                "Operator should not allow null arguments");
    }

    @Test
    public void testIllegalStateException() {
        operator1.setOperand(0, op0);
        assertThrows(IllegalStateException.class,
                () -> operator1.setOperand(0, op0),
                "Operator should not allow position 0 to be set more than once");
    }

    @Test
    public void testIllegalStateExceptionPerform() {
        assertThrows(IllegalStateException.class,
                () -> operator1.performOperation(),
                "Operator should not compute when all arguments have not been set.");
    }
}
