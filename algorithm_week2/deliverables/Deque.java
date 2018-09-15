import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n = 0;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        nullcheck(item);
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            first.previous = null;
            first.next = null;
            last = first;
        } else {
        oldfirst.previous = first;
        first.next = oldfirst;
        }
        n++;
    }

    public void addLast(Item item) {
        nullcheck(item);
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            last.previous = null;
            last.next = null;
            first = last;
        } else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        n++;
    }

    public Item removeFirst() {
        removeEmptycheck();
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            first = null;
            last = first;
        }
        return item;
    }

    public Item removeLast() {
        removeEmptycheck();
        Item item = last.item;
        last = last.previous;
        n--;
        if (isEmpty()) {
            last = null;
            first = last;
        }
        return item;
    }

    public Iterator<Item> iterator() {
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
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void removeEmptycheck() { 
        if (isEmpty()) {
            throw new NoSuchElementException("Can not remove. Queue is empty.");
        }
    }
}