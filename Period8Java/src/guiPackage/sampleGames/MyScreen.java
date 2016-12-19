package guiPackage.sampleGames;

import java.util.ArrayList;

import guiPackage.Screen;
import guiPackage.components.Button;
import guiPackage.components.Graphic;
import guiPackage.components.Visible;

public class MyScreen extends Screen {
	
	public MyScreen(int width, int height) {
		super(width, height);
	}

	private Graphic picture;
	private Button button;
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = 
		picture = new Graphic(50, 50, .5, "resources/sampleImages/minion.jpg");
		viewObjects.add(picture);
	}

}
