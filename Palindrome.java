import java.util.Scanner;

class Palindrome{
    public static void main(Stirng[] args){
        Scanner scan = new Scanner(System.in);
        String str, another = "y";
        int left, right, count, remain = 0;

        while(another.equalsIgnoreCase("y")){
            
            System.out.println("Enter a string to test if it is a Palindrome and press enter:");
            str = (String) scan.nextLine();
            left = 0;
            right = str.length() -1;

            while( (str.charAt(left) == str.charAt(right)) && (left < right) ){
                left++;
                right--;
                count++;
            }//end of the second while loop.
            System.out.println();
            if(left < right){
                System.out.println("That is not a palindrome.");
                System.out.println("However, there were " + count + "common characters on both sides.");
                remain = (str.length() - (2*count));
                System.out.println("There are " + remain + "characters incorrectly matched.");
            }else{
                System.out.println("Yes, that stirng is a palindrome.");
            }

            System.out.println();
            System.out.print("Would you like to try another palindrome (y/n)?");
            another = scan.nextLine;
        }//end of the initial while loop.
    }//end of the main method;
}//end of the class