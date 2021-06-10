public class LinkedList<T> {

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    void addToFirst(T value) {
        Node<T> newItem = new Node<T>(value);

        if(isEmpty()) {
            head = newItem;
            newItem.next = null;
        }
        else {
            newItem.next = head.next;
            head = newItem;
        }
    }

    void add(int position, T value) {
        Node<T> newItem = new Node<T>(value);

        if(position <= 0 || position > size()) {
            System.out.println("wrong index");
        }
        else {
            Node<T> prev = head;
            for (int i = 1; i < position-1; i++) {
                prev = prev.next;
            }
            Node<T> current = prev.next;
            prev.next = newItem;
            newItem.next = current.next;
        }
    }

    void addToLast(T value) {
        Node<T> newItem = new Node<T>(value);

        if (isEmpty()) {
            head = newItem;
            newItem.next = null;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
            newItem.next = null;
        }

    }

    void deletetoFirst() {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node<T> current = head;
            head = current.next;
        }
    }

    void deleteToLast() {
        if(isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node<T> current = head;
            Node<T> prev = head;
            while (current.next != null) {
                if(current.next.next == null) {
                    prev = current;
                }
                current = current.next;
            }
            prev.next = null;
        }
    }

    void delete(int n) {
        if (isEmpty()) {
            System.out.println("list is empty");

        }
        else {
            if (n == 1) {
                deletetoFirst();
            }
            else if (n == size()) {
                deleteToLast();
            }
            else if(n > 1 && n < size()) {
                Node<T> prev = head;
                for (int i = 1; i < n-1; i++) {
                    prev = prev.next;
                }
                Node<T> current = prev.next;
                prev.next = current.next;
            }
            else {
                System.out.println("wrong index");
            }
        }
    }

    int find(T text) {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node<T> current = head;
            int s = 0;
            while (current.next != null) {
                s++;
                if(current.value.equals(text)) {
                    return s;
                }
                current = current.next;
            }
        }
        return 0;
    }

    void display() {
        if(isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node<T> position = head;
            while (position != null) {
                System.out.print(position.value + " ");
                position = position.next;
            }
        }
    }

    int size() {
        int s = 0;
        if(isEmpty()) {
            return 0;
        }
        else {
            Node<T> position = head;
            while (position != null) {
                s++;
                position = position.next;
            }
            return s;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

}