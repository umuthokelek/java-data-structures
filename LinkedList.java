public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    void addToFirst(int value) {
        Node newItem = new Node(value);

        if(isEmpty()) {
            head = newItem;
            newItem.next = null;
        }
        else {
            newItem.next = head.next;
            head = newItem;
        }
    }

    void add(int position, int value) {
        Node newItem = new Node(value);

        if(position <= 0 || position > size()) {
            System.out.println("wrong index");
        }
        else {
            Node prev = head;
            for (int i = 1; i < position-1; i++) {
                prev = prev.next;
            }
            Node current = prev.next;
            prev.next = newItem;
            newItem.next = current.next;
        }
    }

    void addToLast(int value) {
        Node newItem = new Node(value);

        if (isEmpty()) {
            head = newItem;
            newItem.next = null;
        }
        else {
            Node current = head;
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
            Node current = head;
            head = current.next;
        }
    }

    void deleteToLast() {
        if(isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node current = head;
            Node prev = head;
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
                Node prev = head;
                for (int i = 1; i < n-1; i++) {
                    prev = prev.next;
                }
                Node current = prev.next;
                prev.next = current.next;
            }
            else {
                System.out.println("wrong index");
            }
        }
    }

    void find(int text) {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node current = head;
            int s = 0;
            while (current.next != null) {
                s++;
                if(current.value == text) {
                    System.out.println("found: " + s + "th element");
                    break;
                }
                current = current.next;
            }
        }
    }

    void display() {
        if(isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node position = head;
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
            Node position = head;
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