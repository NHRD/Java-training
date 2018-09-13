import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n = 0;//size of queue.
    private Item[] s;


    public RandomizedQueue() {                
    // construct an empty randomized queue
    s = (Item[]) new Object[1];
    }
    
    public boolean isEmpty() {            
    // is the randomized queue empty?
    return n == 0;
    }
    
    public int size() {                     
    // return the number of items on the randomized queue
    return n;
    }
    
    public void enqueue(Item item) {
        nullcheck();
        if (n == s.length) resize(2 * s.length);
        s[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        Emptycheck();   
        int index = StdRandom.uniform(n);
        Item item = items[index];
        s[index] = s[n-1];
        s[n-1] = null;
        n--;
        if (n > 0 && n == s.length/4) resize(s.length/2);
        return item;
    }
    
    public Item sample() {
        Emptycheck();
        int index = StdRandom.uniform(n);
        return s[index];
    }                 
    // return a random item (but do not remove it)
    
    public Iterator<Item> iterator() {       
    // return an independent iterator over items in random order
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i = 0;
        
        public boolean hasNext() {
            return i > 0;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove() not supported.");
        }

        public Item next() {
            if (i == 0) {
                throw new NoSuchElementException("No next item exists.");
            }
            return s[i++]
        }
    }

    private void nullcheck(Item item) {
        //client calls either addFirst() or addLast() with a null argument. 
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void Emptycheck() {
        //Client calls either removeFirst() or removeLast when the deque is empty. 
        if (isEmpty()) {
            throw new NoSuchElementException("Can not remove. Queue is empty.");
        }
    }
 }