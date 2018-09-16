import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n = 0;
    private Item[] s;


    public RandomizedQueue() {                
    s = (Item[]) new Object[2];
    }
    
    public boolean isEmpty() {            
        return n == 0;
    }
    
    public int size() {                     
        return n;
    }
    
    public void enqueue(Item item) {
        nullcheck(item);
        if (n == s.length) resize(2 * s.length);
        s[n] = item;
        n++;
    }

    public Item dequeue() {
        emptycheck();
        Item item = null;
        if (n == 1) {
            item = s[0];
        } else {
        int index = StdRandom.uniform(n - 1);
        item = s[index];
        s[index] = s[n - 1];
        }
        n--;
        if (n > 0 && n == s.length/4) resize(s.length/2);
        return item;
    }
    
    public Item sample() {
        emptycheck();
        Item item = null;
        if (n == 1) {
            item = s[0];
        } else {
            int index = StdRandom.uniform(n - 1);
            item = s[index];
        }
        return item;
    }                 
   
    public Iterator<Item> iterator() {       
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i = n;
        
        public boolean hasNext() {
            return i < n - 1;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove() not supported.");
        }

        public Item next() {
            if (i >= n - 1) {
                throw new NoSuchElementException("No next item exists.");
            }
            return s[i++];
        }
    }

    private void nullcheck(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void emptycheck() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can not remove. Queue is empty.");
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
}