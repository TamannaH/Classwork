package guiPackage.sampleGames;

import guiPackage.guiApplication;

public class ClickGraphicsGame extends guiApplication {

	public ClickGraphicsGame() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		ClickGraphicsGame game = new ClickGraphicsGame();
		Thread app = new Thread(game);
		app.start();	
	}
	
	@Override
	protected void initScreen() {
		GameScreen screen = new GameScreen(getWidth(), getHeight());
		setScreen(screen);
	}
}
