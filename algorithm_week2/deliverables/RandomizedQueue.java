public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n;//size of queue.

    public RandomizedQueue() {                
    // construct an empty randomized queue
    }
    
    public boolean isEmpty() {            
    // is the randomized queue empty?
    }
    
    public int size() {                     
    // return the number of items on the randomized queue
    }
    
    public void enqueue(Item item) {
        nullcheck(item);
    }        
    // add the item
    
    public Item dequeue() {
        Emptycheck();
    }                  
    // remove and return a random item
    
    public Item sample() {
        Emptycheck();
    }                 
    // return a random item (but do not remove it)
    
    public Iterator<Item> iterator()         
    // return an independent iterator over items in random order
    
    public static void main(String[] args)   
    // unit testing (optional)

    private void nullcheck(Item item) {
        //client calls either addFirst() or addLast() with a null argument. 
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Null is prohibited.");
        }
    }
    
    private void Emptycheck(){
        //Client calls either removeFirst() or removeLast when the deque is empty. 
        if (isEmpty()) {
            throw new NoSuchElementException("Can not remove. Queue is empty.");
        }
 }