package introduction;

public class RandomCard {

	public static String main (String[] args) {
		String[] suits = {"Diamonds", "Clubs", "Spades", "Hearts"}; //fills the array with 6 zeroes
		String[] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		return "The card is " + value[(int) ((int)value.length * Math.random())] + " of " + suits[(int) ((int) suits.length * Math.random())];
	}
}
