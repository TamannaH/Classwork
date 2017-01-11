package guiPackage.sampleGames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import guiPackage.Screen;
import guiPackage.components.Action;
import guiPackage.components.AnimatedComponent;
import guiPackage.components.Button;
import guiPackage.components.Graphic;
import guiPackage.components.MovingComponent;
import guiPackage.components.TextArea;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{

	private TextLabel label;
	private TextArea paragraph;

	private Button button;
	private Graphic picture;

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

		paragraph = new TextArea(40,85,550,500,
				"This is a whole paragraph. Notice how "
				+ "as the paragraph gets to the edge"
				+ " of the page, a new line is created.");
		button = new Button(40,200,80,40,"Button",new Color(100,100,250), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		
		picture = new Graphic(50, 50, .5, "resources/sampleImages/minion.jpg");
		
//		MovingComponent mc = new MovingComponent(30, 60, 40, 40);
//		mc.setVy(3);
//		mc.play();
		
		
		
//		viewObjects.add(picture);
//		viewObjects.add(label);
//		button.setSize(12);
//		viewObjects.add(button);
//		viewObjects.add(goToFollower);
//		goToFollower.setSize(12);
//		viewObjects.add(label);
	
//		viewObjects.add(mc);
		
		addAnimation(viewObjects);
	}

	private void addAnimation(ArrayList<Visible> viewObjects) {
		AnimatedComponent a = 
				new AnimatedComponent(40, 50, 150, 150);	
		try{
			int numberInRow = 7;
			int rows = 1;
			int w = 261;
			int h = 255;
			
			ImageIcon icon = new ImageIcon("resources/sampleImages/spritestrip.png");
			//create a for loop that will take a
			//"sub-image" from the sprite grid
			for(int i = 0; i < numberInRow * rows; i++){
				//declare the "cropped image"
				BufferedImage cropped = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin + w*(i%numberInRow);
				int y1 = topMargin + (i/numberInRow);
				Graphics2D g = cropped.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, w, h, x1, y1, x1 + w, y1 + h, null);
				a.addFrame(cropped, 20);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.play();
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