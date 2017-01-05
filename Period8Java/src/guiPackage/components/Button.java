package guiPackage.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable{
	
	private Color color;
	private Action action;
	private int clicks = 0;
	
	public Button(int x, int y, int width, int height, String text, Color color, Action action) {
		super(x, y, width, height, text);
		setColor(color);
		setAction(action);
	}
	
	public int getClicks()
	{
		return clicks;
	}
	
	public void setClicks(int clicks)
	{
		this.clicks = clicks;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
		update();
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public void update(Graphics2D g)
	{		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 25, 25);
		
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 25, 25);
		
		if(getText() != null)
		{
			int cutoff = getText().length();
			String t = getText();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth())
			{
				cutoff--;
				t = t.substring(0, cutoff);
			}
			
			
			g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
			g.drawString(t, (getWidth() - fm.stringWidth(t))/3, (getHeight() + fm.getHeight() - fm.getDescent())/2);
		}
	}

	public boolean isHovered(int x, int y) {
		if(x > getX() && x < getX() + getWidth())
			if(y > getY() && y < getY() + getHeight())
				return true;
				
		return false;
	}

	public void act() {
		if(action != null)
			action.act();
	}
}