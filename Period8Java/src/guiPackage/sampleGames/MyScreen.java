package guiPackage.sampleGames;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPackage.Screen;
import guiPackage.components.Action;
import guiPackage.components.Button;
import guiPackage.components.Graphic;
import guiPackage.components.Visible;

public class MyScreen extends Screen implements MouseMotionListener, MouseListener{
	
	public MyScreen(int width, int height) {
		super(width, height);
	}

	private Graphic picture;
	private Button back;
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		back = new Button(50, 50, 100, 60, "Back", Color.GRAY, new Action() {
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.coordScreen);
			}
		});
		picture = new Graphic(50, 50, .5, "resources/sampleImages/minion.jpg");
		viewObjects.add(picture);
		viewObjects.add(back);
	}

	public MouseListener getMouseListener(){
		//when screen is listening for a click
		return this;
	}
	
	public MouseMotionListener getMouseMotionListener(){
		//when screen is listening for a click
		return this;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}

}
