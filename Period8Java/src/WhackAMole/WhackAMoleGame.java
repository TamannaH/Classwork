package WhackAMole;

import guiPackage.guiApplication;

public class WhackAMoleGame extends guiApplication {

	public static void main(String[] args){
		WhackAMoleGame game = new WhackAMoleGame();
		Thread app = new Thread(game);
		app.start();
	}
	
	public WhackAMoleGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		WhackAMoleScreen wams = new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(wams);
	}

}
