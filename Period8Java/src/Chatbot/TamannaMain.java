package Chatbot;

import java.util.Scanner;

public class TamannaMain {

	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;
	//list all the chatbots available under this class
	static Chatbot school;
	
	public static void main(String[] args){
		
		//demonstrateStringMethods();
		createFields();
		String s1 = " ";
		String s2 = "a";
		System.out.print(s1.compareTo(s2));
		promptName();
		promptForever();
	
	}
	
	private static void promptName() {
		print("Enter your name");
		user = input.nextLine();
		print("Glad to meet you " + user + ". For the rest of time, I will call you " + user + "." + " You may call me Computer. We should become friends.");
	}

	private static void promptForever() {
		inMainLoop = true;
		while(inMainLoop){
			print("Hi, " + user + ". How are you?");
			response = promptInput();
			
			//response to how you feel
			if (findKeyword(response, "good", 0) >= 0){
				print("That's wonderful. So glad you feel good.");
			}
			
			//response to liking school
			else if (response.indexOf("good") >= 0){
				print("School is great! Tell me about school.");
				//exit this while loop
				inMainLoop = false;
				//go to the school's talk method
				school.talk();
			}
			
			else{
				print("I don't understand.");
			}		
		}
	}

	public static int findKeyword(String searchString, String keyword, int startPosition) {
		
		//delete white spance
		searchString = searchString.trim();
		//make lowercase 
		searchString = searchStrong.toLowerCase();
		keyword = keyword.toLowerCase();
		//find first position of key word,
		int position = searchString.indexOf(0);
		//keep searching until context keyword found
		while (position >= 0){
			//Assume preceeded and followed by space
			String before = " ";
			Sting after = " ";
			
			//check character in front, in it exists
			if (position > 0){
				before = searchString.substring(position-1,  position);
		}
		//check if there is a character after the keyword
		
		//keyword not found
		if (position + keyword.length() < searchString.length()){
			after = searchString.substring(position + keyword.length().position + keyword.length() + 1);
		}
			
		if (before.compareTo("a") < 0 && after.compareTo("a") < 0){
			return position;
		}else{
			//position + 1 one space after our current position, so this finds the NEXT word
			position = searchString.indexOf(keyword, position + 1);
		}
			return -1; 
		
	}

	public static void createFields(){
		
		input = new Scanner(System.in);
		user = "";
		school = new TamannaSchool(); //constructor
	}
	
	private static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
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
}
