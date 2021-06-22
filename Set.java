public class Set<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(T newData) {
            data = newData;
        }
    }

    private Node<T> head;

    public Set() {
        head = null;
    }

    public boolean add(T newItem) {
        if (isEmpty()) {
            head = new Node<T>(newItem);
            head.next = null;
            return true;
        }
        else {
            if (contains(newItem)) {
                return false;
            }
            else {
                Node<T> position = head;
                while (position.next != null) {
                    position = position.next;
                }
                position.next = new Node<T>(newItem);
                position.next.next = null;
                return true;
            }
        }
    }

    public Set<T> intersection(Set<T> otherSet) {
        Set<T> interset = new Set<T>();

        Node<T> position = otherSet.head;
        while (position != null) {

            if (contains(position.data)) {
                interset.add(position.data);
            }
            position = position.next;
        }
        return interset;
    }

    public Set<T> union(Set<T> otherSet) {
        Set<T> uni = new Set<T>();

        Node<T> positionSet = head;
        while (positionSet != null) {
            uni.add(positionSet.data);
            positionSet = positionSet.next;
        }

        Node<T> position = otherSet.head;
        while (position != null) {
            if (!contains(position.data)) {
                uni.add(position.data);
            }
            position = position.next;
        }
        return uni;

    }

    public boolean contains(T item) {
        Node<T> position = head;
        while (position != null) {
            if (position.data.equals(item)) {
                return true;
            }
            position = position.next;
        }
        return false;
    }


    public void print() {
        Node<T> position = head;
        while (position != null) {
            System.out.print(position.data + " ");
            position = position.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}