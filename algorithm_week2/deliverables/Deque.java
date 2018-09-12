import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {
        //construct an empty deque
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        //is the deque empty?
        return first == null;
    }

    public int size() {
        //return the number of items on the deque.
        return n;
    }

    public void addFirst(Item item) {
        //add the item to the front
        nullcheck(item);
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            first = last;
        } else {
        first.next = oldfirst;
        oldfirst.previous = first;
        }
        n++;
    }

    public void addLast(Item item) {
        //add the item to the end
        nullcheck(item);
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        n++;
    }

    public Item removeFirst() {
        //remove and return the item from the first
        removeEmptycheck();
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item removeLast() {
        //remove and return the item from he end
        removeEmptycheck();
        Item item = last.item;
        last = last.previous;
        n--;
        return item;
    }

    public Iterator<Item> iterator() {
        //return an iterator over items in order from front to end
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove() not supported.");
        }

        public Item next() {
            if (current.next == null) {
                throw new NoSuchElementException("No next item exists.");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private void nullcheck(Item item) {
        //client calls either addFirst() or addLast() with a null argument. 
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void removeEmptycheck(){
        //Client calls either removeFirst() or removeLast when the deque is empty. 
        if (isEmpty()) {
            throw new NoSuchElementException("Can not remove. Queue is empty.");
        }
    }
}