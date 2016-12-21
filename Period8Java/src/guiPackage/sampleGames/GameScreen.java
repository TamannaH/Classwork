package guiPackage.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPackage.Screen;
import guiPackage.components.Action;
import guiPackage.components.Button;
import guiPackage.components.ClickableGraphic;
import guiPackage.components.Graphic;
import guiPackage.components.Visible;

public class GameScreen extends Screen implements MouseMotionListener, MouseListener {

	private ClickableGraphic picture;
	
	public GameScreen(int width, int height) {
		super(width, height);
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		
		picture = new ClickableGraphic(50, 50, .5, "resources/sampleImages/minion.jpg");
		picture.setAction(new Action(){
			public void act(){
				picture.setX(picture.getX() + 10);
			}
		});
		viewObjects.add(picture);
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
		if(picture.isHovered(e.getX(), e.getY())){
			picture.act();
		}
	}
	
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
