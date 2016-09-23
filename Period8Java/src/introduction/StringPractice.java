package introduction;

import java.util.Scanner;

public class StringPractice {

	static Scanner input;
	static String user;
	
	public static void main(String[] args){
		
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
	
	}
	
	private static void promptName() {
		print("Enter your name");
		user = input.nextLine();
		print("Glad to meet you " + user + ". For the rest of time, I will call you " + user + "." + " You may call me Computer. We should become friends.");
	}

	private static void promptForever() {
		while(true){
			promptInput();
		}
		
	}

	public static void createFields(){
		
		input = new Scanner(System.in);
		user = "";
	}
	
	private static void promptInput() {
		print("Please type something, " + user + ".");
		String userInput = input.nextLine();
		print("Congrats! You typed: " + userInput);
	}

	
	public static void print(String s){
		String printString = "";
		int cutoff = 35;
		
		//check for words to add
		//in other words s has a length greater than 0
		while (s.length() > 0){
			String cut = "";
			String nextWord = "";
			
			//check to see if the next word will fit on the line AND there must still be words to add
			
			while (cut.length() + nextWord.length() < cutoff && s.length() > 0){
				
				//add the next word to the line
				cut += nextWord;
				
				s = s.substring(nextWord.length());
				
				//identify the following word without the space
				int endOfWord = s.indexOf(" ");
				
				//if there are no more spaces, this is the last word, so add the whole thing
				
				if (endOfWord == -1){
					endOfWord = s.length() - 1; //-1 for index
				}
				
				nextWord = s.substring(0, endOfWord + 1);
			}
			
			printString += cut+"\n";
		}
		
		System.out.println(printString);
	}
	
	
	
	
	
	
	public static void demonstrateStringMethods(){
		String text1 = new String("Hello World"); //constructors always use the word new, but strings are the only ones that don't
		String text2 = "Hello World"; //same as above
		
		if (text1.equals(text2)){
			//when comparing objects/methods don't use ==, use .equals
			
			print("These strings are equal:");
		}
		print(text1);
		print(text2);
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyva";
		
		if (word1.compareTo(word2) < 0){
			print("word1 comes before word2.");
		}
	}
	
	/*
	public static void print(String s)
	{
		System.out.println(s);
	}*/
}
