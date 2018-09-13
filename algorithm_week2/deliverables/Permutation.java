public class Permutation {

    public static void main(String[] args) {

        int nu = Integer.parseInt(args[0]);
        RandomizedQueue result = new RandomizedQueue();
        while (!(args[0]) && !(StdIn.Empty())) {
            result = result.enqueue();
        }
        int i = 0;
        while (i < nu) {
            System.out.println(result.dequeue());
            i++;
        }
    }
}