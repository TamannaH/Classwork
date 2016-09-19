package introduction;

public class Student {
	
	//fields: information in the local variables is not kept, only field variables are
	private String name;
	
	//constructor (initialize fields)
	public Student(String name){
		//this refers to the name of the field
		this.name = name;
	}
	
	public void talk(){
		System.out.println("Hello my name is " + name);
	}
	
	public void speak(){
		System.out.println("Hello I am " + name);
	}	
	
	public void walk(){
		System.out.println("Hi I am " + name);
	}
	
	//(Student)jillian.talk();
}
