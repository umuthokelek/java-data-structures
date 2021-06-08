public class CircularLinkedList {
    private class Node {
        private int value;
        private Node next;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    void addToFirst(int value) {
        Node newItem = new Node(value);
        if (isEmpty()) {
            head = newItem;
            newItem.next = head;
        }
        else {
            Node prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            newItem.next = prev.next;
            prev.next = newItem;
            head = newItem;
        }
    }

    void addToLast(int value) {
        Node newItem = new Node(value);
        if (isEmpty()) {
            head = newItem;
            newItem.next = head;
        }
        else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            newItem.next = head;
            current.next = newItem;
        }
    }

    void add(int n, int value) {
        Node newItem = new Node(value);
        if (isEmpty()) {
            System.out.println("list is empty");            
        }
        else {
            if (n == 1) {
                addToFirst(value);
            }
            else if (n == size()) {
                addToLast(value);
            }
            else if(n > 1 && n < size()) {
                Node prev = head;
                for (int i = 1; i < n-1; i++) {
                    prev = prev.next;
                }
                newItem.next = prev.next;
                prev.next = newItem;
            }
            else {
                System.out.println("wrong index");
            }
        }
    }

    void deletetoFirst() {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            Node current = prev.next;
            prev.next = current.next;
            head = current.next;
        }
    }

    void deleteToLast() {
        if (isEmpty()) {
            System.out.println("list is empty");
        }
        else {
            Node prev = head;
            while (prev.next.next != head) {
                prev = prev.next;
            }
            Node current = prev.next;
            prev.next = current.next;
        }
    }

    void delete(int n) {
        if(isEmpty()) {
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

    void display() {
        Node current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
    }

    int size() {
        int s = 0;
        Node current = head;
        do {
            s++;
            current = current.next;
        } while (current != head);
        return s;
    }

    boolean isEmpty() {
        return head == null;
    }

}
