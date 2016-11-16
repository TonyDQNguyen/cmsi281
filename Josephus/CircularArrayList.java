import java.util.NoSuchElementException;

public class CircularArrayList extends AbstractArrayList implements CircularCollectible {

    public CircularArrayList() {
        super();
    }

    public CircularArrayList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void add(String s) {
        //add as usual if size is less than static array total size
        if (size < arraySize) {
            elements[size] = s;         
            size++;
        } else {
            // else double array size
            arraySize = arraySize * 2;
            //creating new array
            String[] doubleElements = new String[arraySize];

            // and then copy the elements over one by one...
            for (int i = 0; i < size; i++) {
                doubleElements[i] = elements[i];
            }

            elements = doubleElements;

            //add new element as usual
            elements[size] = s;         
            size++;
        }
    }

     /** remove(String s):
     *  removes the first element in the list for which
     *      element.equals(s)
     *  is true.
     */


    public void remove(String s) {
        for (int i = 0; i < size; i++){
            if(elements[i].equals(s)){
                for (int j = i; j < size(); j++){                    
                    elements[j]=elements[j+1];
                }
                size--;
                return; 
            }        
        }        
    }

    /** removeAll(String s):
     *  removes all elements in the list for which
     *      element.equals(s)
     *  is true.
     */


    public void removeAll(String s) {
        for (int i = 0; i < size; i++){
            if(elements[i].equals(s)){
                for (int j = i; j < size(); j++){                    
                    elements[j]=elements[j+1];
                }
                size--; 
            }        
        }  
    }

    
    public String first() {
        int i;
        //for (i = 0; elements[i] == null || i < size; i++);
        return elements[0];
    }
    
    public CircularIterator iterator() {
        return new CircularArrayListIterator();
    }

    class CircularArrayListIterator implements CircularIterator {
        public int index = 0;
        public String current = "";

        public CircularArrayListIterator() {
            index = 0;
        }

        public String current(){
            return current;
        }
        
        public boolean hasNext() {
            return size!= 0;
        }

        public String next() {
             //if (!hasNext()) throw new NoSuchElementException();
            index = (index+1)%size;
            current = elements[index];
            return current;
        }

        public void remove(){
            for(int i = index; i < size; i++){
                elements[i] = elements[i+1];
            }
            size--;
            next();
        }

        public String removeKthElement(int k) {
            for (int i = 0; i < k; i++){
                next();
            }
            String temp = elements[k];
            remove();
            return temp;
        }        
            

        public boolean oneElementLeft() {
            return size == 1;
        }
    }
}