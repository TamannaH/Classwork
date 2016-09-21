package introduction;

public class RandomDiceRoll{

	public static void main(String[] args) {
		
		int[] results = new int[6]; //fills the array with 6 zeroes
		
		//declared variable, logic test, increment
		int totalRolls = 1000;
		for (int index = 0; index < totalRolls; index++)
		{
			int result = rollFairDie();
			System.out.println("Roll #" + (index + 1) + ": " + rollFairDie());
			results[result-1]++;
		}
		//print the results
		for (int i = 0; i < 6; i++){
			double percentage =  ((int) (1000*(double)results[i]/totalRolls))/10.0;
			System.out.println((i+1)+ " appeared " + percentage + "%."); 
		}
		System.out.println(results[0]);
	}
	
	//return 1, 2, 3, 4, 5, 6 with equal probability  
	public static int rollFairDie(){
		double rand = Math.random(); //returns a double (0, 1)
		int roll = (int) (6*rand);//[0,5]
		//int roll = (int) (6*rand)+1;//[1,6]
		roll++; //[1.6]
		return roll;
	}
	
	public static int rollUnfairDie(){
		double rand = Math.random();
		int roll = (int) (6*rand)+1;
		if ((roll == 2)||(roll == 4))
		{
			roll++;
		}
		
		if ((roll == 3)||(roll == 5))
		{
			roll--;
		}
		return roll;
	}
}
