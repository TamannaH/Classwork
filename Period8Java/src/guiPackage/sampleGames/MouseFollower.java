package guiPackage.sampleGames;

import guiPackage.guiApplication;

public class MouseFollower extends guiApplication {

	public static CoordinateScreen coordScreen;
	public static MouseFollower game;
	public static MyScreen myScreen;
	
	public static void main(String[] args){
		game = new MouseFollower();
		Thread app = new Thread(game);
		app.start();
		
	}
	
	protected void initScreen() {
		coordScreen = new CoordinateScreen(getWidth(), getHeight());
		//myScreen = new MyScreen(getWidth(), getHeight());
		setScreen(coordScreen);
	}

}
