public class HashTable {

    public static final int SIZE = 10;
    public LinkedList[] arr;

    public HashTable() {
        arr = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = new LinkedList();
        }
    }

    public int generateHash(String text) {
        int hash = 0;
        for (int i = 0; i < text.length(); i++) {
            hash += text.charAt(i);
        }
        return hash % SIZE;
    }

    public void put(String text) {
        int hash = generateHash(text); 
        arr[hash].addToLast(text);      
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + i + "] ");
            arr[i].display();
            System.out.println();
        }
    }
}
