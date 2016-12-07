package guiPackage;

import java.awt.Graphics;

import javax.swing.JFrame;

public class guiApplication extends JFrame{
	
	private Screen currentScreen;
	
	public static void main(String[] args){
		new guiApplication();
	}
	
	public guiApplication(){
		//terminate program when window is closed
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = 40;
		int y = 40;
		int width = 600;
		int height = 400;
		setBounds(x, y, width, height);
		initScreen();
		setVisible(true);
	}

	protected void initScreen() {
		Screen startScreen = new Screen(getWidth(), getHeight());
		currentScreen = startScreen;
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
}
