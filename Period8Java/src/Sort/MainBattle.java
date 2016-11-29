package Sort;

public class MainBattle {
	public static void main(String[] args){
		Pokemon squirtle = new Pokemon("Squirtle", 26);
		Pokemon pikachu = new Pokemon("Pikachu", 26);
		
		squirtle.iChooseYou();
		pikachu.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast.");
		
		squirtle.attack(pikachu, new Attack() {
			//cuts health(hp) in half
			public void attack(Pokemon target) {
				int newHP = target.getHp()/2;
				target.setHp(newHP);
			}
		});
		
		squirtle.attack(pikachu, new Attack() {
			//poisons the target
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		
		squirtle.lapse();
		pikachu.lapse();
		
		printScore(squirtle, pikachu);
	}

	private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName() +", HP = "+ p1.getHp());
		System.out.println(p2.getName() +", HP = "+ p2.getHp());
	}
}
