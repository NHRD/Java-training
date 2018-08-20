class Forloop{
	public static void main(String[] args){

        String message = "Hello World!!";
        
        char[] characters = message.toCharArray();
        
        for(char c : characters){
            System.out.println(c);
            //System.out.print(c);
        }

	}
}