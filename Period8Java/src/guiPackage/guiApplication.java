package guiPackage;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class guiApplication extends JFrame implements Runnable{
	
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
		//stop controls from last screen		
		if (currentScreen != null){
			if (currentScreen.getMouseListener() != null){
				removeMouseListener(currentScreen.getMouseListener());
			}
		}
		
		if (currentScreen != null){
			if (currentScreen.getMouseMotionListener() != null){
				removeMouseMotionListener(currentScreen.getMouseMotionListener());
			}
		}		
		
		currentScreen = screen;
		
		//add controls for new screen
		if(currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void run(){
		while(true){
			currentScreen.update();
			//updates the window
			repaint();
			try {
				Thread.sleep(40);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
