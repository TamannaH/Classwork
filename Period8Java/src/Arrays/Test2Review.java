package Arrays;

public class Test2Review {

	private static boolean[][] grid;
	
	public static void main(String[] args){
		grid = new boolean[5][5];
		printGrid(grid);
		buttonClick(3,3);
		printGrid(grid);
		buttonClick(3,3);
		printGrid(grid);
	}
	
	public static void switchRow(boolean[] row, int x){
		//switch row[x-1], row[x], row[x+1] IF THEY EXIST
		for(int i =- 1; i < 2; i++){
			if(x + i >= 0 && x + i < row.length){
				row[x+i] = !row[x+i];
			}
		}
	}
	
	public static void switchCol(boolean[][] grid, int r, int c){
		//switches ABOVE and BELOW the value in row r and column c
		switchIfValid(grid, r-1, c);
		switchIfValid(grid, r+1, c);
	}
	
	public static void switchIfValid(boolean[][] grid, int r, int c){
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length){
			grid[r][c] = !grid[r][c];
		}
	}
	
	private static void buttonClick(int r, int c) {
		if(r >= 0 && r < grid.length){
			switchRow(grid[r], c);
		}
			switchCol(grid, r, c);
			
		//check if a single light is on
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[row].length; col++){
				if(grid[row][col])return;
			}
		}
		System.out.println("You have solved the puzzle!");
	}

	public static void printGrid(boolean[][] grid){
		for(boolean[] row: grid){
			for(boolean b: row){
					if(b)System.out.print("O");
					else System.out.print("X");
				}
					System.out.print("\n");
		}
		System.out.println("- - - - - - - - -");
	}

}
