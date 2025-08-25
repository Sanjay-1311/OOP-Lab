public class StackArray<T> implements MyStack<T> {
    private Object[] array;
    private int top;
    private int capacity;
    private static final int MAX_CAPACITY = 10;

    public StackArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }
        if (initialCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Initial capacity cannot exceed maximum capacity of " + MAX_CAPACITY);
        }
        this.capacity = initialCapacity;
        this.array = new Object[this.capacity];
        this.top = -1;
    }

    @Override
    public void push(T item) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("Cannot push to stack. Maximum capacity of " + MAX_CAPACITY + " reached.");
        }
        if (top == capacity - 1) {
            resize();
        }
        array[++top] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Cannot pop from empty stack.");
        }
        T item = (T) array[top];
        array[top--] = null;
        return item;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top + 1 >= MAX_CAPACITY;
    }

    private void resize() {
        int newCapacity = Math.min(capacity * 2, MAX_CAPACITY);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity = newCapacity;
        System.out.println("Stack resized to capacity: " + capacity);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack elements (top to bottom): [ ]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Stack elements (top to bottom): [ ");
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
