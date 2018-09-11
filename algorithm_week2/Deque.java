Public class Deque<Item> implements Iterable<Item> {

    public Deque() {
        //construct an empty deque
    }

    public boolean isEmpty() {
        //is the deque empty?

    }

    public int size() {
        //return the number of items on the deque.
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
            throw new java.lang.IllegalArgumentException("Null is prohibited.")
        }
    }
    
    private void removeEmpty(){
        if (isEmpty()) {
            throw new java.util.NoSuchEementException("Can not remove. Queue is empty.")
        }
    }
}