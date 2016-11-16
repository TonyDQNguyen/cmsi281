public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {
    Node last;

    public CircularLinkedList() {
        super();
        last = null;
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(String s) {
        Node newFirst = new Node(first, s);
        first = newFirst;
        if (n == 0){
            last = first;
        }
        last.next = first;
        n++;
    }

     /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void remove(String s) {
        Node current = first;
        Node prev = null;
        if (first.value.equals(s)) {
            first = first.next;
            n--;
            return;
        }
        while (current != last) {
            if (current.value.equals(s)) {
                prev.next = current.next;
                n--;
                return;
            }
        prev = current;
        current = current.next;
        }
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */
    public void removeAll(String s) {
        Node current = first;
        Node prev = null;
        if (first.value.equals(s)) {
            first = first.next;
            n--;
        }
        while (current != last) {
            if (current.value.equals(s)) {
                prev.next = current.next;
                n--;
            }
        prev = current;
        current = current.next;
        }
    }
    

    public String first() {
        return first.value;
    }

    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
        public Node current;
        public Node prev;

        public CircularLinkedListIterator() {
            current = first;
            prev = last;
        }

        public boolean hasNext() {
            return n != 0;
        }

        public String next() {
            prev = current;
            current = current.next;
            if (current.value == first.value){
                current = first;
            }
            return current.value;
        }

        public void remove() {
            current.value = current.next.value;
            prev.next = current.next;
            current.next = current.next.next;
            n--;
        }

        public String removeKthElement(int k) {
            for (int i = 0; i < k; i++) {
                next();
            }
            String temp = current.value;
            remove();
            return temp;
        }

        public boolean oneElementLeft() {
            return n == 1;
        }
    }
}