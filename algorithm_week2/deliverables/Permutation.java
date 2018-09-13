public class Permutation {

    public static void main(String[] args) {

        int nu = Integer.parseInt(args[0]);
        String[] items = StdIn.readStrings();
        RandomizedQueue result = new RandomizedQueue();
        for (int i = 0; i < items.length; i++) {
            result = result.enqueue(items[i]);
        }
        int j = 0;
        while (j < nu) {
            System.out.println(result.dequeue());
            j++;
        }
    }
}