package guiPackage.sampleGames;

import guiPackage.guiApplication;

public class MouseFollower extends guiApplication {

	private CoordinateScreen cordScreen;
	
	public static void main(String[] args){
		guiApplication game = new MouseFollower();
		Thread app = new Thread(game);
		app.start();
		
	}
	
	protected void initScreen() {
		cordScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(cordScreen);
	}

}
