package Chatbot;

public class TamannaSchool extends Object implements Chatbot{
	
	private  boolean inSchoolLoop;
	private String schoolResponse;

	public void talk() {
		public void talk() {
			inSchoolLoop = true;
			while(inSchoolLoop){
				TamannaMain.print("Type 'quit' to go back.");
				//static call on promptInput method form TamannaMain class
				schoolResponse = TamannaMain.promptInput();
				if (schoolResponse.indexOf("quit") >= 0)
				{
					inSchoolLoop = false; 
					TamannaMain.promptForever();
				}
				TamannaMain.print("That's my favorite part about school.");
			
			}
		}
	}

	public boolean isTriggered(String userInput) {
		
		String[] triggers = {"school", "class", "teacher"};
		
		//idea: create a for loop to iterate
		//through your array of triggers
		
		if (TamannaMain.findKeyword(userInput, "school", 0) >= 0)
		{
			return true;
		}
		
		if (TamannaMain.findKeyword(userInput, "class", 0) >= 0)
		{
			return true;
		}
		return false;
	}	
}
