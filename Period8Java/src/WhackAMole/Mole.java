package WhackAMole;

import guiPackage.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements PlayerInterface {
	
	private double appearanceTime;
	
	public Mole(int x, int y) {
		super(x, y, .50, "resources/sampleImages/mole.jpg");
	}

	public void setAppearanceTime(double d){
		this.appearanceTime = d;
	}
	
	public double getAppearanceTime(){
		return appearanceTime;
	}
	
	@Override
	public void increaseScore(int i) {
		// TODO Auto-generated method stub

	}

}
