package guiPackage.sampleGames;

import java.util.ArrayList;

import guiPackage.Screen;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;

public class CoordinateScreen extends Screen {

	private TextLabel label;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(40, 45, 760, 40, "Sample Text");
		viewObjects.add(label);
	}
	
}
