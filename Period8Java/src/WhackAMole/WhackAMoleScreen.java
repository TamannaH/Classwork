package WhackAMole;

import java.util.ArrayList;
import java.util.List;

import guiPackage.ClickableScreen;
import guiPackage.components.Action;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	
	private ArrayList<MolesInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;
	
	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread play = new Thread(this);
		play.start();
	}

	public void update(){
		super.update();

	}
	
	public void run() {
		changeText("Set...");
		changeText("Go!");
		changeText("");
		timeLabel.setText(""+timeLeft);
		
		while(timeLeft > 0){
			//frame updates every tenth of a second (100ms)
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			timeLeft = timeLeft - .1;
			timeLabel.setText(""+(int)(timeLeft*10)/10.0);	
			disappearMoles();
			addNewMoles();
		}
	}
	
	private void addNewMoles() {
		//probability of mole appearing depends on time left
		double probability = .2 + .1 * (30.0 - timeLeft)/30;
		if(Math.random() < probability){
			final MolesInterface mole = getAMole();
			
			//between .5 and 2.5 seconds
			mole.setAppearanceTime((int)(500 + Math.random() * 2000));
			mole.setAction(new Action(){
				public void act(){
					player.increaseScore(1);
					//remove mole from viewObjects
					remove(mole);
					//remove mole from "database"
					moles.remove(mole);
				}
			});
			//add mole to visible
			addObject(mole);
			//add mole to mole list
			moles.add(mole);
		}
	}

	private void disappearMoles() {
		//each mole has a "clock"
		//when the clock counts down to zero, it disappears
		
		for(int i = 0; i < moles.size(); i++){
			MolesInterface m = moles.get(i);
			m.setAppearanceTime(m.getAppearanceTime() - 100);
			
			if (m.getAppearanceTime() <= 0){
				//remove from viewObjects
				remove(m);
				//remove it from our mole database
				moles.remove(i);
				i--; //compensate for i++
			}
		}		
	}

	private void changeText(String string) {
		try{
			Thread.sleep(1000);
			label.setText(string);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * this is a placeholder because early in the game design
	 * process, the players aren't designed yet, so we use this
	 * method later, one we learn how to create a Player
	 */
	private PlayerInterface getAPlayer() {
		 return new Player(20, 20);
	}
	
	/**
	 * this is a placeholder because early in the game design
	 * process, the players aren't designed yet, so we use this
	 * method later, one we learn how to create a Enemy (mole)
	 */	
	private MolesInterface getAMole() {
	    return (MolesInterface) new Mole((int)(getWidth() * Math.random()) - 100, (int)(getHeight() * Math.random()));

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
