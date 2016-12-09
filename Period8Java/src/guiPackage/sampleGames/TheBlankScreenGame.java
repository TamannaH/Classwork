package guiPackage.sampleGames;

import guiPackage.Screen;
import guiPackage.guiApplication;

public class TheBlankScreenGame extends guiApplication {
	
	protected void initScreen() {
		Screen s = new BlankScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		new TheBlankScreenGame();
	}

}
