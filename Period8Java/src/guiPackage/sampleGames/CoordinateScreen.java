package guiPackage.sampleGames;

import guiPackage.components.Button;
<<<<<<< HEAD
import guiPackage.components.Graphic;
=======
>>>>>>> refs/remotes/origin/master

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

<<<<<<< HEAD
import guiPackage.components.Action;
=======
import javax.swing.Action;
>>>>>>> refs/remotes/origin/master

import guiPackage.Screen;
import guiPackage.components.TextArea;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{

	private TextLabel label;
	private TextArea paragraph;
<<<<<<< HEAD
	private Button button;
	private Graphic picture;
=======
	private Button goToFollower;
>>>>>>> refs/remotes/origin/master
	
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
<<<<<<< HEAD
		button = new Button(40, 200, 80, 40, "Button", new Color(100, 100, 250), new Action() {
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.myScreen);
=======
		goToFollower = Button(40, 50, 100, 30, "Button", new Color(0, 80, 150), new Action()) {
				
			public void act() {
				
>>>>>>> refs/remotes/origin/master
			}
		});
		
<<<<<<< HEAD
		picture = new Graphic(50, 50, .5, "resources/sampleImages/minion.jpg");
		viewObjects.add(picture);
		viewObjects.add(label);
		button.setSize(12);
		viewObjects.add(button);
=======
		goToFollower.setSize(12);
		viewObjects.add(label);
		viewObjects.add(goToFollower);
>>>>>>> refs/remotes/origin/master
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
		//programmed to listen to input
		return this;
	}
	
	public MouseListener getMouseListener(){
		//programmed to listen to input
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(), e.getY())){
			button.act();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}