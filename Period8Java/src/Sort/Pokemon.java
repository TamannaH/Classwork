package Sort;

public class Pokemon {
	/*Write a "Pokemon" class. It needs the following fields:
		int level
		int hp
		String name
		boolean poisoned
		
		A constructor that takes a String name and int level as a parameter, initializes these values, sets hp to 100 and poisoned to false.
		A void method "iChooseYou" that prints the name of the Pokemon twice.
		in getHP()
		String getName()
		void setHP(int newHP)
		void setPoisoned(boolean b)
		void lapse() which subtracts 15 points from hp only if the Pokemon is posoned.
	 */
	
	private int level;
	private static int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int level){
		this.name = "";
		this.level = 0;
		this.poisoned = false;
		hp = 100;
	}
	
	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit.");
		}else{
			System.out.println("The attack missed.");
		}
	}
	
	public void iChooseYou(){
		System.out.println(name +", "+name +"!");
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		Pokemon.hp = hp;
	}

	public boolean poisoned() {
		return poisoned;
	}

	public void lapse(){
		if(poisoned()){
			hp = hp - 15;
		}
	}

	public void setPoisoned(boolean b) {
		poisoned = b;
	}
}
