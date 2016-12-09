package guiPackage.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {
	
	//FIELDS
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	
	//CONSTRUCTOR
	public Component(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}
	
	/**
	 	draw the component
	 	@param createGraphics
	 */
	
	public abstract void update(Graphics2D g);

	public BufferedImage getImage(){
		return image;
	}
	 
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return w;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return h;
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update() {
		update(image.createGraphics());
	}

}
