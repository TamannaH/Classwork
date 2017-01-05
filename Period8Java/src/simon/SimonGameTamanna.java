package simon;

import guiPackage.guiApplication;

public class SimonGameTamanna extends guiApplication {

	public static SimonScreenTamanna mainScreen;
	
	public SimonGameTamanna() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		mainScreen = new SimonScreenTamanna(getWidth(), getHeight());
		setScreen(mainScreen);
	}

	public static void main(String[] args) {
		SimonGameTamanna game = new SimonGameTamanna();
		Thread app = new Thread(game);
		app.start();

}
}
