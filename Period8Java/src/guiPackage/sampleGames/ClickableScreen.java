package guiPackage.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPackage.Screen;
import guiPackage.components.Clickable;
import guiPackage.components.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener{

	ArrayList<Clickable> clickables;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < clickables.size(); i++){
			
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

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();

		for(int i = 0; i < viewObjects.size(); i++){
			if(viewObjects.get(i) instanceof Clickable){
				clickables.add((Clickable)viewObjects.get(i));
			}
		}
	}

	public abstract void initAllObjects(ArrayList<Visible> viewObjects);

}
