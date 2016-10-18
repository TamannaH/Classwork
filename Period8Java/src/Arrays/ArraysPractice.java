package Arrays;

public class ArraysPractice {
	
	/*If you want to put different primitive types into an array, you must use their
	wrapper class.
	
	ARRAY
		fixed length
		indices start at zero
		indexed (ordered)
		common data type (ex. "Student[]")
		arrays of any type must be Object[]
		
	Pass-by-value: changes the assignment, not the value
 */
	
	static boolean[] boos3;
	
	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		
		int[] fiftyNumbers = new int[50];
		populate(fiftyNumbers);
		print(fiftyNumbers);
		randomize(fiftyNumbers, 50);
		print(fiftyNumbers);
		rollDice(fiftyNumbers, 2);
		print(fiftyNumbers);
		
		//count each die roll and provide a percentage
		countResult(fiftyNumbers, 3);
		print(fiftyNumbers);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The process took " + (endTime - currentTime) + " ms.");
	}
	
	private static void countResult(int[] fiftyNumbers, int numberOfDice) {
		//count each die roll and provide a percentage
		System.out.println("countResult method");
		int[] counter = new int[numberOfDice*6];
		
		for (int n: fiftyNumbers){
			counter[n-1] = counter[n-1] + 1;
		}
		
		for (int i = numberOfDice; i < counter.length; i++){
			System.out.println((i + 1) + " was rolled " + 100*counter[i]/fiftyNumbers.length + " percent of the time.");
		}
	}

	private static void rollDice(int[] fiftyNumbers, int numberOfDice) {
		System.out.println("rollDice method");
		//Populate an array with the roll of two dice
		for (int i = 0; i < fiftyNumbers.length; i++){
			int dice = 0;
			for (int j = 0; j < numberOfDice; j++){
				dice = dice + (int)(1+6*Math.random());
				fiftyNumbers[i] = dice;
			}
		}
	}

	private static void randomize(int[] fiftyNumbers, int max) {
		System.out.println("randomize method");
		for (int i = 0; i < fiftyNumbers.length; i++){
			int randomNumber = (int) (1+(max*Math.random()));
			fiftyNumbers[i] = randomNumber;
		}
	}

	private static void print(int[] fiftyNumbers) {
		for (int i = 0; i < fiftyNumbers.length; i++){
			System.out.println(fiftyNumbers[i]);
		}
		
	}

	private static void populate(int[] fiftyNumbers) {
		System.out.println("populate method");
		//Populate and print an array with the numbers 1 - 50.
		for (int i = 0; i < fiftyNumbers.length; i++){
			fiftyNumbers[i] = i+1;
		}
	}
/*
	private void demonstratePassByValue(){
		
		//how do you time a process?
		long currentTime = System.currentTimeMillis();
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		someStrings[999] = getASpecialString(s);
		print(someStrings);
		//long is an integer that takes up more memory than an int
		//time is measured in long
		long endTime = System.currentTimeMillis();
		System.out.println("The process took " + (endTime - currentTime) + " ms.");
		
		private static String getASpecialString(String s) {
			return "THIS STRING IS SPECIAL!";
		}

		private static void makeSpecial(String s) {
			s = "THIS STRING IS SPECIAL!";
		}

		private static void print(String[] s) {
			for (int i = 0; i < s.length; i++){
				System.out.println(s[i]);
			}
			
		}

		private static void standardPopulate(String[] s) {
			/*int i = 0;
			
			for(String x: s){
				i++;
				x = "String #" + i;
			}*/
			/*
			for (int i = 0; i < s.length; i++){
				String string = "String #" + (i+1);
				string = s[i];
			}
		}
	}

	public static void initializingArraysExample(){
		/**Primitive Type[]
		 * primitive types are "already" in the system
		 * cannot mix types
		 * 
		 * Object[]
		 * unless initialized, start as null
		 * different types of objects in an array of common super class
		*/
		/*
		//two different ways to instantiate an array
		boolean[] boos1 = new boolean[3];
		//this can only be done at the declaration because it sets size AND content:
		boolean[] boos2 = {false, false, false};
		//this does NOT work: 
		//boos3 = {false, true, true};
		//this is all that will work:
		boos3 = new boolean[3];
		
		
		/**two ways of iterating through an array with a for loop:
		STANDARD FOR LOOP
			-the index is important to keep track of
			-you need to customize the order
		*/
		/*
		for(int i = 0; i < boos1.length; i++){
			System.out.println(boos1[i]);
		}
		
		/**
		 * "FOR - EACH" LOOP
		 * 		-the index is not important
		 * 		-you don't need to customize
		 * 		-automatically assigns a "handle"
		 * 		-faster
		 */
		/*
		for(boolean b: boos1){
			System.out.println(b);
		}
		
		//OBJECT ARRAYS
		String[] someStrings1 = new String[3];
		someStrings1[0] = "a";
		someStrings1[1] = "b";
		someStrings1[2] = "c";
		//...but it is repetitive
		
		//let's try a loop to instantiate:
		for (int i = 0; i < someStrings1.length; i++){
			someStrings1[i] = "a new String";
		}
		
		//a loop to print it:
		for (String s: someStrings1){
			System.out.println(s);
		}
		
		/*
		String[] someStrings1 = new String[3];
		String[] someStrings2 = {"a", "b", "c"};
	
		for(String s: someStrings1){
			
		}
			System.out.println(s);
			String a = s.substring(0);
			System.out.println(a);
		}
		
	*/	
	}
