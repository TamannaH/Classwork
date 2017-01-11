package guiPackage.components;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class MovingComponent extends Component implements Runnable {
	
	private long moveTime; //time when the image last moved
	private double vx; //the horizontal velocity
	private double vy; //the vertical velocity
	private double posx; //the actual x-coordinate of the object
	private double posy; //the actual y-coordinate of the object
	private boolean running;
	
	public static final int REFRESH_RATE = 20;
	
	public MovingComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		vx = 0;
		vy = 0;
		running = false;
	}
	
	public boolean isAnimated(){
		return true;
		//moving components are always animated
	}

	public void run() {
		posx = getX();
		posy = getY();
		running = true;
		moveTime = System.currentTimeMillis();
		
		while(running){
			try{
				Thread.sleep(REFRESH_RATE);
				checkBehaviors();
				update();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public abstract void checkBehaviors();

	public void update(Graphics2D g) {
		long currentTime = System.currentTimeMillis();
		//calculates time since last move
		long difference = currentTime - moveTime;
		if(difference >= REFRESH_RATE){
			//an update is happening, so update moveTime
			moveTime = currentTime;
			//calculate new position
			posx += vx*(double)difference/REFRESH_RATE;
			posy += vy*(double)difference/REFRESH_RATE;
			//set only location on the screen
			//NOT the actual position
			super.setX((int)posx);
			super.setY((int)posy);
			g.setColor(Color.black);
		}
		drawImage(g);
	}

	public abstract void drawImage(Graphics2D g);

	public void setX(int x){
		super.setX(x);
		posx = x;
	}
	
	public void setY(int y){
		posy = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void play() {
		if(!running){
			Thread go = new Thread(this);
			go.start();
		}
	}
	
	
}
