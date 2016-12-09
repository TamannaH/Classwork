package guiPackage;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class guiApplication extends JFrame{
	
	//you cannot instantiate an abstract class!!!
	
	private Screen currentScreen;
	
	public guiApplication(){
		//terminate program when window is closed
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		int x = 40;
		int y = 40;
		int width = 600;
		int height = 400;
		setBounds(x, y, width, height);
		initScreen();
		setVisible(true);
	}
	
	/*
	 	This is a methods for creating and setting the starting screen.
	 */

	protected abstract void initScreen();
	
	public void setScreen(Screen screen){
		currentScreen = screen;
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
}
