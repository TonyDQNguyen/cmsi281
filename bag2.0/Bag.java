import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Bag implements Collectible {
    private Node first;
    private int n; // number of nodes
    private int total; // total number of words in this bag


    // Implement a constructor
    // public Bag() { ...
    public Bag(){
        first = null;
        n = 0;
        total = 0;
    } 

    // Implement Collectible interface methods here
    //isEmpty() returns a boolean on whether the bag is empty or not
    public boolean isEmpty(){
        if (first == null){
            return true;
        } else {
            return false;
        }
    }

    //uniqueSize() returns the count of unique String values in the Bag object
    public int uniqueSize() {
        return total;
    }

    //size() returns the total count of String values in the Bag object
    public int size(){
        return n;
    }

    public void add(String item){
        Node temp = first;
        for (Obliterator i = iterator(); i.hasNext(); ){
            if(temp.item.equals(item)){
                temp.count++;
                n++;
                return;
            } else {
                temp = temp.next;
                i.next();
            }
        }
        Node newNode = new Node(first, item, 1);
        first = newNode;
        n++;
        total++;
    }

    public Obliterator iterator() {
        return new BagIterator(first);  
    }

    class BagIterator implements Obliterator {
        public Node current;

        public BagIterator(Node first) {
            current = first;
        }

        public boolean hasNext() { 
            return current != null;  
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Node next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = current.next; 
            return node;
        }
    }


    public static void main(String[] args) throws IOException {
        Bag bag = new Bag();
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String item = s.next(); // Scanner splits input on whitespace, by default
                bag.add(item);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        // Print bag size and distinct contents
        System.out.format("Total number of words: %d\n", bag.size());
        System.out.format("Unique number of words: %d\n", bag.uniqueSize());

        // Print distinct words in bag and their frequency
        for (Obliterator i = bag.iterator(); i.hasNext(); ) {
            Node node = i.next();
            System.out.format("%s %d\n", node.item, node.count);
        }
    }

}
