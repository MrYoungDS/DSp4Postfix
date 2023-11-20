package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedStackTest {
    private StackInterface<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new LinkedStack<Integer>();
    }

    @Test
    public void testStack() {
        assertTrue(stack.isEmpty(), "Stack should be empty after being constructed.");
        assertEquals(0, stack.size(), "Stack should contain zero elements after being constructed.");

        stack.push(5);
        assertFalse(stack.isEmpty(), "Stack should not be empty.");
        assertEquals(Integer.valueOf(5), stack.top(), "The top element should be 5");
        assertEquals(1, stack.size(), "The stack should contain one element.");

        stack.push(4);
        assertEquals(Integer.valueOf(4), stack.top(), "The top element should be 4");
        assertEquals(2, stack.size(), "The stack should contain two elements.");

        Integer t = stack.pop();
        assertEquals(Integer.valueOf(4), t, "The popped element should be 4");
        assertEquals(Integer.valueOf(5), stack.top(), "The top element should be 5");
        assertEquals(1, stack.size(), "The stack should contain one element.");
        assertFalse(stack.isEmpty(), "The stack should not be empty.");

        t = stack.pop();
        assertEquals(Integer.valueOf(5), t, "The popped element should be 5");
        assertTrue(stack.isEmpty(), "The stack should be empty.");
    }

    @Test
    public void testStackUnderflowPop() {
        assertThrows(StackUnderflowException.class,
                () -> stack.pop(),
                "Pop on an empty stack should throw underflow.");
    }

    @Test
    public void testStackUnderflowTop() {
        assertThrows(StackUnderflowException.class,
                () -> stack.top(),
                "Examining the top of an empty stack should throw underflow.");
    }
}
