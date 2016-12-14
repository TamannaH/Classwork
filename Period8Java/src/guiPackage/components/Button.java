package guiPackage.components;

import java.awt.Color;
import java.awt.Graphics2D;

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
	private Action act;
	private int x;
	private int y;
	private int w;
	private int h;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action act) {
		super(x, y, w, h, text);		
		this.color = color;
		this.act = act;
	
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void update(Graphics2D g) {
		//g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		g.drawRoundRect(10, 120, 25, 5, 25, 25);
		g.fillRoundRect(10, 120, 25, 5, 25, 25);
		
	}
	
	public boolean isHovered(int xcor, int ycor){
		if ((xcor < getX() && xcor < getX() + w) && (ycor < getY() && ycor < getY() + h)){
			return true;
		}
		return false;
	}
}
