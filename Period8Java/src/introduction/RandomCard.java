package introduction;

public class RandomCard {

	public static String main(String[] args) {
		String[] suits = {"King", "Jack", "Queen", "Spades", "Hearts"}; //fills the array with 6 zeroes
		String[] value = {"Ace", "2", "3", "4", "5"};
		
		return value[(int)value.length * Math.random())] + "of" suits[(int)suits.length * Math.random())];
	}
	
	/*public static String pickCard(){
		
	}*/

}
