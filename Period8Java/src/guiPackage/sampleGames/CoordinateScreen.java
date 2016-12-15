package guiPackage.sampleGames;

import guiPackage.components.Button;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.Action;

import guiPackage.Screen;
import guiPackage.components.TextArea;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener{

	private TextLabel label;
	private TextArea paragraph;
	private Button goToFollower;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(40,45,760,40,"Sample Text");
//		paragraph = new TextArea(40,85,500,500,
//				"This is a whole paragraph. Notice how "
//				+ "as the paragraph gets to the edge"
//				+ " of the page, a new line is created.");
		//viewObjects.add(paragraph);
		goToFollower = Button(40, 50, 100, 30, "Button", new Color(0, 80, 150), new Action()) {
				
			public void act() {
				
			}
		});
		
		goToFollower.setSize(12);
		viewObjects.add(label);
		viewObjects.add(goToFollower);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent m) {
		label.setText("Mouse at " + m.getX() + ", " + m.getY());
//		
//		if (m.getX() == 100 && m.getY() == 100){
//			addText(viewObjects);
//		}
	}
//	
//	public void addText(ArrayList<Visible> viewObjects) {
//		paragraph = new TextArea(40,100,500,700,
//				"This is a whole paragraph. Notice how "
//				+ "as the paragraph gets to the edge"
//				+ " of the page, a new line is created.");
//		viewObjects.add(paragraph);
//		
//	}
	
	//overrides method to activate mouseMotionListener
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

}