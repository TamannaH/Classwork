package guiPackage.sampleGames;

import guiPackage.guiApplication;

public class MouseFollower extends guiApplication {

	private CoordinateScreen cordScreen;
	
	public static void main(String[] args){
		new MouseFollower();
	}
	
	protected void initScreen() {
		cordScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(cordScreen);
	}

}
