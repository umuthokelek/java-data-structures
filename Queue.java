import java.util.NoSuchElementException;

public class Queue<T> {

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

    public Queue() {
        head = null;
    }

    public boolean enqueue(T item) {
        Node<T> newItem = new Node<T>(item);
        if (isEmpty()) {
            head = newItem;
        }
        else {
            Node<T> position = head;
            while (position.next != null) {
                position = position.next;
            }
            position.next = newItem;
        }
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            Node<T> position = head;
            while (position.next.next != null) {
                position = position.next;
            }
            Node<T> tail = position.next;
            position.next = null;
            return tail.data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            Node<T> position = head;
            while (position.next != null) {
                position = position.next;
            }
            return position.data;
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
