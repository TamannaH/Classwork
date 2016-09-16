package introduction;

public class Sophomore extends Student {

	public Sophomore(String name) {
		super(name);
	}
	
	public void walk(){
		super.walk();
		System.out.println("...and I am walking to class.");
	}
}
