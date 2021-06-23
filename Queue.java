import java.util.NoSuchElementException;

public class Queue<T> {

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

    public Queue() {
        head = null;
    }

    public boolean enqueue(T item) {
        Node newItem = new Node(item);
        if (isEmpty()) {
            head = newItem;
            //head.next = null;
        }
        else {
            Node position = head;
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
            Node position = head;
            while (position.next.next != null) {
                position = position.next;
            }
            Node tail = position.next;
            position.next = null;
            return tail.data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            Node position = head;
            while (position.next != null) {
                position = position.next;
            }
            return position.data;
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