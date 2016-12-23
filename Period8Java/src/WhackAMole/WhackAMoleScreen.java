package WhackAMole;

import java.util.ArrayList;
import java.util.List;

import guiPackage.components.TextLabel;
import guiPackage.components.Visible;
import guiPackage.sampleGames.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	
	private ArrayList<MolesInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;
	private int h;
	private int w;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 60.0;
		Thread play = new Thread(this);
		play.start();
	}
	
	private int getHeight() {
		return h;
	}

	private int getWidth() {
		return w;
	}

	public void update(){
		super.update();

	}
	
	public void run() {
		changeText("Set...");
		changeText("Go!");
		changeText("");
		timeLabel.setText(""+timeLeft);
		
		while(timeLeft >0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			timeLeft = timeLeft - .1;
			timeLabel.setText(""+(int)(timeLeft*10)/10.0);
		}
	}
	
	private void changeText(String string) {
		try{
			Thread.sleep(1000);
			label.setText(string);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private PlayerInterface getAPlayer() {
		 return null;
	}
	
	private MolesInterface getAMole() {
	    return null;

	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		moles = new ArrayList<MolesInterface>();
		player = getAPlayer();
		label = new TextLabel(getWidth()/2-60, getHeight()/2-30, 120, 60, "Ready...");
		timeLabel = new TextLabel(getWidth()/2-60,50, 120, 60, "");
		
		viewObjects.add(label);
		viewObjects.add(player);
		viewObjects.add(timeLabel);
	}
}
