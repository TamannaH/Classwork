package introduction;

public class RandomCard {

	public static void main (String[] args) {
		String[] suits = {"Diamonds", "Clubs", "Spades", "Hearts"}; //fills the array with 6 zeroes
		String[] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		int values = (int) (Math.random()*value.length);
		int suit = (int) (Math.random()*suits.length);
		
		System.out.println(value[values] + " of " + suits[suit]); 
	}
}
