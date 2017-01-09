package guiPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPackage.components.Clickable;
import guiPackage.components.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener{

	ArrayList<Clickable> clickables;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
	}
	
	public abstract void initAllObjects(ArrayList<Visible> viewObjects);
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();

		for(int i = 0; i < viewObjects.size(); i++){
			if(viewObjects.get(i) instanceof Clickable){
				clickables.add((Clickable)viewObjects.get(i));
			}
		}
	}

	 public void addObject(Visible v){
		 super.addObject(v);
		 if(v instanceof Clickable){
		 clickables.add((Clickable) v);
		 }
	}

	 public void remove(Visible v){
		 super.remove(v);
		 clickables.remove((Clickable) v);
	} 
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public void mouseClicked(MouseEvent e) {
		for(Clickable c: clickables){
			if(c.isHovered(e.getX(), e.getY())){
				c.act();
				break;
			}
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
