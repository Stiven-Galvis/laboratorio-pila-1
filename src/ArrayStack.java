import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {

    private int size;
    private Object[] array;
    private int top;

    public ArrayStack() {
        this.array = new Object[10];
        this.top = -1;
        this.size = 0;
    }

    public void push(Object element) {
        if (top == array.length - 1) {
            resize();
        }
        array[++top] = element;
        size++;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object element = array[top];
        array[top--] = null;
        size--;
        return element;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }
}