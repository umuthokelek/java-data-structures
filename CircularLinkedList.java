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

    void display() {
        Node current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
    }

    boolean isEmpty() {
        return head == null;
    }

}
