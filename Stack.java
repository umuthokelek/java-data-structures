import java.util.EmptyStackException;

public class Stack<T> {

    private class Node {
        private T data;
        private Node next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(T newItem) {
            data = newItem;
        }
    }

    private Node head;

    public Stack() {
        head = null;
    }

    public boolean push(T item) {
        Node newItem = new Node(item);
        if (isEmpty()) {
            head = newItem;
        }
        else {
            newItem.next = head;
            head = newItem;
        }
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            Node popItem = head;
            head = head.next;
            return popItem.data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return head.data;
        }
    }

    public void print() {
        Node position = head;
        while(position != null) {
            System.out.print(position.data + " ");
            position = position.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}