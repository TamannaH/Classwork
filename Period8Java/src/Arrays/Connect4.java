package Arrays;

import java.util.Scanner;

public class Connect4 {
	
	public static Scanner in = new Scanner(System.in);
	static String[][] board;
	static String piece;
	
	public static void main(String[] args) {
		board = new String[7][8];
		piece = "O";
		
		for(int row = 0; row < board.length; row++){
			//populate with coordinates
				for(int col = 0; col < board[row].length; col++){
					board[row][col] = "(" + row + ", " + col + ")";
				}
			}
		
		board = makeGrid(board);
		printPic(board);
		startExploring();
	}
	
	private static String[][] makeGrid(String[][] board) {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++)
				board[row][col] = " ";
		}
		return board;
	}
	
//	private static void startExploring(){
//		while(true){
//			System.out.println("Which column do you want to drop your piece?");
//			String input = in.nextLine();
//			int tracker;
//			if(isValid(input)){
//				
//				
//			}
//			
//			
//			if(starti == treasurei && startj == treasurej){
//				break;
//			}
//			
//			System.out.println("What do you want to do?");
//			
//			int[] newCoordinates = interpretInput(input);
//			starti = newCoordinates[0];
//			startj = newCoordinates[1];
//		}
//		
//		System.out.println("Congrats! You found the treasure!!");
//	}
	
	private static boolean isValid(String input) {
		int key = Integer.parseInt(input);
		for(int num = 0; num < board.length; num++){
			if (key == num){
				return true;
			}
		}

		return false;
	}
	
//	private static int[] interpretInput(String input) {
//		//verify input is valid
//		while(!isValid(input)){
//			System.out.println("Sorry, in this game, you can only use the w, a, s, d controls.");
//			System.out.println("Tell me again what you would like to do.");
//			input = in.nextLine();
//		}
//		
//		int currentj;
//		int currenti;
//	
//		if(input.equals("w")) currenti--;
//		if(input.equals("s")) currenti++;
//		if(input.equals("a")) currentj--;
//		if(input.equals("a")) currentj++;
//		
//		int[] newCoordinates = {starti, startj};
//		if(currenti >= 0 && currenti< arr2D.length && currentj >= 0 && currentj < arr2D[0].length){
//			newCoordinates[0] = currenti;
//			newCoordinates[1] = currentj;
//		}else{
//			System.out.println("Sorry, you've reaced the edge of the known universe. You may go no further in that direction.");
//		}
//		return newCoordinates;
//	}

	public static void printPic(String[][] pic){
		for (String[] row : pic){
			for (String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
