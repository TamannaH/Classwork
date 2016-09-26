package Chatbot;

public class TamannaSchool extends Object implements Chatbot{

	public void talk() {
		private boolean inSchoolLoop;
		private String schoolResponse;
		
		public void talk(){
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
	
	
}
