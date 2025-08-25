public interface MyStack<T> {
    void push(T item) throws StackOverflowException;
    T pop() throws StackUnderflowException;
    void display();
    boolean isEmpty();
    boolean isFull();
}