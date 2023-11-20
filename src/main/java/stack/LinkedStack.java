package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    Node<T> first;
    int size;

    /**
     * {@inheritDoc}.
     */
    @Override
    public T pop() throws StackUnderflowException {
        // TODO: Implement the pop method, which will be
        //   similar to the removeFirst method for a LinkedList
        //   (which was not included in our MyLinkedList project,
        //   but is a special case of our remove method).
        //   If the list is empty you should throw an exception.
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T top() throws StackUnderflowException {
        // TODO: Implement the top method, which will be
        //   similar to the getFirst method for a LinkedList
        //   (which was not included in our MyLinkedList project,
        //   but is a special case of our get method).
        //   If the list is empty you should throw an exception.
        return null;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void push(T elem) {
        // TODO: Implement the push method, which will be
        //   similar to the addFirst method for a LinkedList.
    }
}
