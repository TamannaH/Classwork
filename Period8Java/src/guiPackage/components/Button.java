package guiPackage.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable{
	
	/*
	 * Go back to the Button class and make Button implement Clickable.
	 *  Create the isHovered and act() methods. 
	 *  isHovered() should return true if the parameters int x and
	 *   int y are values between the Button's x value and x+width value and y and y+height,
	 *    respectively. Keep in mind these are private fields (this.x and this.y) so
	 *     you will have to access them using the getters. The act() method is simple, 
	 *     it calls act() on the Button's action (The field you made in step 3)
	 */

	private Color color;
	private Action action;
	private String text;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.color = color;
		this.action = action;
		this.text = text;
		update();
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
		update();
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		if(text!=null){
			g.setFont(new Font(getFont(), Font.PLAIN,getSize()));
			g.drawString(text, 4, getHeight()-5);
		}
		g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), 25, 35);
		g.setColor(color);
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 25, 35);
	}

	public boolean isHovered(int x, int y) {
		if(x>getX()&&x<getX()+getWidth()&&y>getY()&&y<getY()+getHeight())
			return true;
		return false;
	}
	
	public void act(){
		action.act();
	}
}
