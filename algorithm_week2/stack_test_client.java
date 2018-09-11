public class StackClient {

    public static void(String[]args) {
        /*Class name shold be updated in accoradnace with the name of used stack type.*/
        StackOfStrings stack = new StackOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.po());
            }
            elsev{
                stack.push(s);
        while (!(stack.isEmpty)) {
            System.out.println(stack.pop());
            }
        }
    }
}