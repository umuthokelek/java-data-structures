public class DoublyLinkedList {
    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }
    
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }


    void addToStart(int value) {
        Node newItem = new Node(value);
        if (head == null) {
            head = newItem;
            newItem.next = null;
            newItem.previous = null;
        }
        else {
            newItem.next = head;
            head.previous = newItem;
            head = newItem;
        }
    }

    void add(int n, int value) {
        Node newItem = new Node(value);
        if (n == 1) {
            deleteToFirst();
        }
        else if(n == size()) {
            deleteToLast();
        }
        else if (n <= 0 || n > size()) {
            System.out.println("empty index");
        } 
        else {
            Node current = head;
            for (int i = 1; i < n - 1; i++) {
                current = current.next;
            }
            newItem.next = current.next;
            current.next.previous = newItem;
            current.next = newItem;
            newItem.previous = current;
        }        
    }

    void addToLast(int value) {
        Node newItem = new Node(value);
        if (isEmpty()) {
            head = newItem;
            newItem.next = null;
            newItem.previous = null;
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
            newItem.previous = current;
            newItem.next = null;
        }
    }

    void deleteToFirst() {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            //Node current = head;
            head = head.next;
        }
    }

    void delete(int n) {
        if (n <= 0 || n > size()) {
            System.out.println("wrong index");
        }
        else {
            Node current = head;
            for (int i = 1; i < n-1; i++) {
                current = current.next;
            }
            System.out.println(current.next.value + " deleted");
            current.next.next.previous = current;
            current.next = current.next.next;
        }
    }


    void deleteToLast() {
        if(isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;

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

