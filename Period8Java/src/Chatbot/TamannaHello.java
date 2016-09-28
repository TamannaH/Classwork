package Chatbot;

public class TamannaHello implements Chatbot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	private String[] calmResponses = {"We already said hello. Let's move the converstation along.", "You said hello already. Did you forget?"};
	private String[] angryResponses = {"Okay seriously. Stop saying hi.", "What is with you and saying hello?"};
	
	private int helloCount;
	
	public TamannaHello(){
		helloCount = 0;
	}
	
	public void talk() {
		
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse(); //helper method
			helloResponse = TamannaMain.promptInput();
			
			//negate use
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				TamannaMain.promptForever();
			}
		}
	}

	private void printResponse() {
		
		if (helloCount > 4){
			int responseSelection = (int)(Math.random()*angryResponses.length);
			TamannaMain.print(angryResponses[responseSelection]);
		}else{
				int responseSelection = (int)(Math.random()*calmResponses.length);
				TamannaMain.print(calmResponses[responseSelection]);
		}
		
	}

	public boolean isTriggered(String userInput) {
		
		if (TamannaMain.findKeyword(userInput, "hello", 0) >= 0){
			return true;
		}	
		
		if (TamannaMain.findKeyword(userInput, "hi", 0) >= 0){
			return true;
		}	
		
		if (TamannaMain.findKeyword(userInput, "hey", 0) >= 0){
			return true;
		}	
		
		return false;
	}
}
