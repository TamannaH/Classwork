package guiPackage.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends TextLabel implements Clickable{

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
		//updating the picture
		update();
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 35);
		g.setColor(Color.BLACK);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight(), 25, 35);	
		if(text != null){
//			g.setColor(Color.white);
//			String t = getText();
//			int cutoff = t.length();
//			while (cutoff > 0 && fm.stringWidth(t) > getWidth()){
//				cutoff--;
//				t = t.substring(0, cutoff);
//			}
			g.setFont(new Font(getFont(), Font.PLAIN,getSize()));
			g.drawString(text, 4, getHeight()-5);
		}
			
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