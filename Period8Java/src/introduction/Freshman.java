package introduction;

public class Freshman extends Student {

	public Freshman(String name) {
		
		super(name);
	}
	
	public void speak(){
		super.speak();
		System.out.println("...and I want to go to Boston.");
	}
}
