import java.util.EmptyStackException;

public class Stack<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(T newItem) {
            data = newItem;
        }
    }

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public boolean push(T item) {
        Node<T> newItem = new Node<T>(item);
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
            Node<T> popItem = head;
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
        Node<T> position = head;
        while(position != null) {
            System.out.print(position.data + " ");
            position = position.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}