package caveExplorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArraysIntro{

	static String[][] arr2D;
	static int starti;
	static int startj;
	public static Scanner in;
	static int treasurei;
	static int treasurej;
	static String[][] pic;
	
	public static void main(String[] args){
		
//		String[][] mines = new String[6][6];
//		//plantMines(mines);
//		picMaking(mines);
//		
//		//printPic(field);
//		
//		//picMaking(mines);
		in = new Scanner(System.in);
		arr2D = new String[5][5];
		for(int row = 0; row < arr2D.length; row++){
//		populate with coordinates
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col] = "(" + row + ", " + col + ")";
			}
		}
		
		starti = 2;
		startj = 2;
		treasurei = 4;
		treasurej = 3;
		pic = new String[5][5];
		
		startExploring();
	}
	
	private static void startExploring(){
		while(true){
			printPic(pic);
			System.out.println("You are in room " + arr2D[starti][startj] + ".");
			
			if(starti == treasurei && startj == treasurej){
				break;
			}
			
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			
			int[] newCoordinates = interpretInput(input);
			starti = newCoordinates[0];
			startj = newCoordinates[1];
		}
		
		System.out.println("Congrats! You found the treasure!!");
	}

	private static int[] interpretInput(String input) {
		//verify input is valid
		while(!isValid(input)){
			System.out.println("Sorry, in this game, you can only use the w, a, s, d controls.");
			System.out.println("Tell me again what you would like to do.");
			input = in.nextLine();
		}
		
		int currentj = starti;
		int currenti = startj;
		
		for(int r = 0; r < pic.length; r++){
			for(int c = 0; c < pic[r].length; c++){
				System.out.println(" ");
				if((r == starti) && (c == startj)){
					System.out.println("X");
				}
			}
		}
		
		input = input.toLowerCase();
		if(input.equals("w")) currenti--;
		if(input.equals("s")) currenti++;
		if(input.equals("a")) currentj--;
		if(input.equals("a")) currentj++;
		
		int[] newCoordinates = {starti, startj};
		if(currenti >= 0 && currenti< arr2D.length && currentj >= 0 && currentj < arr2D[0].length){
			newCoordinates[0] = currenti;
			newCoordinates[1] = currentj;
		}else{
			System.out.println("Sorry, you've reaced the edge of the known universe. You may go no further in that direction.");
		}
		return newCoordinates;
	}

	private static boolean isValid(String input) {
		String[] validKeys = {"w", "a", "s", "d"};
		
		for(String key: validKeys){
			if(input.toLowerCase().equals(key)){
				return true;
			}
		}
		return false;
	}

	/*
	private static String[][] createField(boolean[][] mines) {
		String[][] field = new String[mines.length][mines[0].length];
		
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				if(mines[row][col]){
					field[row][col] = "X";
				}else{
					field[row][col] = countNearby(mines, row, col);
				}
			}
		}
		
		return field;
	}

	
	private static String countNearby(boolean[][] mines, int row, int col) {
		for(int r = row - 1; r <= row + 1; r++){
			for(int c = col - 1; c <= col + 1; c++){
				//check that this element exists
				if(r >= 0 && r < mines.length && c >= 0 && c < mines[0].length){
					
				}
			}
		}
		return null;
		
		//this method ONLY considers actual elements
//		int count = 0;
//		for (int r = 0; r < mines.length; r++){
//			for (int c = 0; c < mines[r].length; c++){
//				if(Math.abs(r - row) + Math.abs(c - col) == 1 && mines[r][c]){
//					
//				}
//			}
//		}
//		return "" + count;
		
		//this method allows you to be most specific
		//for example, you only want North and East
		int count = 0;
		count += isValidAndTrue(mines, row - 1, col);
		count += isValidAndTrue(mines, row + 1, col);
		count += isValidAndTrue(mines, row, col - 1);
		count += isValidAndTrue(mines, row, col + 1);
		
		return "" + count;
	}

//	private static int isValidAndTrue(boolean[][] mines, int i, int col) {
//		if (i >= 0 && i < mines.length && col >= 0 && col < mines[0].length && mines[i][col]){
//			return 1;
//		}
//		return 0;
//	}

	private static void plantMines(boolean[][] mines) {
		int numberOfMines = 10;
		while (numberOfMines > 0){
			int row = (int)(Math.random() * mines.length);
			int col = (int)(Math.random() * mines[0].length);
			
			//this prevents the same mine from being selected twice
			while(mines[row][col]){
				row = (int)(Math.random() * mines.length);
				col = (int)(Math.random() * mines[0].length);
			}
		}
	}
*/
	public static void picMaking(String[][] mines){
		//String[] xox = {"x", "o", "x", "o", "x"};
		//System.out.println(Arrays.toString(xox));
		//a 1D array prints a horizontal string
		
		//String[][] arr2D = new String[4][4];
		
//		String[][] arr2D = new String[5][4];
//		System.out.println("The height is " + arr2D.length);
//		System.out.println("The width is " + arr2D[0].length);
//		//5 is the row and the column is 4
//		
//		for(int row = 0; row < arr2D.length; row++){
//			//populate with coordinates
//			for(int col = 0; col < arr2D[row].length; col++){
//				arr2D[row][col] = "(" + row + ", " + col + ")";
//			}
//		}
		//print the 2D array
		//Every element in a 2D array IS itself an array,
		//so a for-each loop looks like this:
//		for(String[] row : arr2D){
//			System.out.println(Arrays.toString(row));
//		}
		
		CaveRoom[][] caves = CaveExplorer.caves;
		//convert these caves to a string representation
		
		String[][] pic = new String[8][8];
		
//		for (int row = 0; row < pic.length; row++){
//			for(int col = 0; col < pic[row].length; col++){
//				pic[row][col] = " ";
//			}
//		}
//		
		//sun
		pic[1][3] = "O";
		pic[2][3] = "|";
		pic[1][2] = "-";
		pic[1][4] = "-";
		
		
		//grassy field
		for(int row = 5; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				pic[row][col] = "W";
			}
		}
		
		//top row and bottom row should be "_"
		for(int col = 0; col < pic[0].length; col++){
			pic[0][col] = "_";
			pic[pic.length - 1][col] = "_";
		}
		
		//first and last col should be "|"
		for(int row = 1; row < pic.length; row++){
			pic[row][0] = "|";
			pic[row][pic[0].length - 1] = "|";
		}
		
		//printPic(pic);
	}
	
	public static void printPic(String[][] pic){
		for (String[] row : pic){
			for (String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
}