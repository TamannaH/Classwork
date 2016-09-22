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
		String printString = s;
		int cutoff = 10;
		if (printString.length() > cutoff){
			
			for (int i = 0; i*cutoff < s.length(); i++){
				printString = printString + getCut(s, cutoff, i+1)+"\n";
			}
		}
		System.out.println(printString);
	}
	
	private static String getCut(String s, int cutoff, int cut){
	
			int cutIndex = cut * cutoff;
			if (cutIndex > s.length())
				{
					cutIndex = s.length();
				}
			
			String currentCut = s.substring(0, cutIndex);
			
			int indexOfLastSpace = currentCut.length()-1;
			//start at last index, go backwards
			for(int index = currentCut.length()-1; index >= 0; index--){
				String letter = currentCut.substring(index, index+1);
				if (letter.equals(" ")){
					indexOfLastSpace = index;
					break;
				}
			}
			
			//shorten the cut to end on a space
			currentCut = currentCut.substring(0, indexOfLastSpace);
			return currentCut;
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
