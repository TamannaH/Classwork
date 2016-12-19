package guiPackage.sampleGames;

import guiPackage.guiApplication;

public class MouseFollower extends guiApplication {

	public static CoordinateScreen cordScreen;
	public static MouseFollower game;
	public static MyScreen myScreen;
	
	public static void main(String[] args){
		guiApplication game = new MouseFollower();
		Thread app = new Thread(game);
		app.start();
		
	}
	
	protected void initScreen() {
		myScreen = new MyScreen(getWidth(), getHeight());
		setScreen(myScreen);
	}

}
