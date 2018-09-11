Public class Deque<Item> implements Iterable<Item> {

    private Item[] s;
    private int N = 0;

    public Deque() {
        //construct an empty deque
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        //is the deque empty?
        return (N ==0);
    }

    public int size() {
        //return the number of items on the deque.
        return s.length;
    }

    public void addFirst(Item item) {
        //add the item to the front
    }

    public void addLast(Item item) {
        //add the item to the end
    }

    public Item removeFirst() {
        //remove and return the item from the first
    }

    public Item removeLast() {
        //remove and return the item from he end
    }

    public Iterator<Item> iterator() {
        //return an iterator over items in order from front to end
    }

    public static void main(String[] args) {
        //unit testing(optional)
    }

    private void boundarycheck(String i) {
        if (i == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void removeEmpty(){
        if (isEmpty()) {
            throw new java.util.NoSuchEementException("Can not remove. Queue is empty.");
        }
    }

    private void nextcheck(int N) {
        if (s[N] == null) {
            throw new java.util.NoSuchEementException("No next item.");
        }
    }

    private void remove() { 
        throw new java.lang.UnsupportedOperationException("Not supported.");
    }
}