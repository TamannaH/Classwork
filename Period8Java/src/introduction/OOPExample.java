package introduction;

public class OOPExample {

	public static void main(String[] args) {
		
		Student jillian = new Senior("Jillian");
		Student jason = new Freshman("Jason");
		Student jordan = new Sophomore("Jordan");
		
		jillian.talk(); //use the talk method for jillian
		
		jason.speak();
		jordan.walk();
		
		//casting a Student into a Junior
		//((Junior)jordan.boastScore();
	}
	
}
