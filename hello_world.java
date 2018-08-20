class HelloWorld{
	public static void main(String[] args){

		String message = "Hello World!!";

		message = message.concat(" Lovely day, isn't it??");
		
		message = message.replace('o', '0');
		message = message.replace('e', '3');
		message = message.replace('l', '1');

		System.out.println(message);
	}
}