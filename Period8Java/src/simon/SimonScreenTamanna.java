package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPackage.components.TextLabel;
import guiPackage.components.Visible;
import guiPackage.sampleGames.ClickableScreen;

public class SimonScreenTamanna extends ClickableScreen implements Runnable {
	
	public ArrayList<ButtonInterfaceTamanna> buttonList;
	public ArrayList<MoveInterfaceTamanna> moveList;
	public ProgressInterfaceTamanna progress;
	public TextLabel label;
	public int roundNumber;
	public int sequenceIndex;
	public int lastSelectedButton;
	public boolean acceptingInput;
	
	public SimonScreenTamanna(int width, int height) {
		super(width, height);
		roundNumber = 0;
		sequenceIndex = 2;
		
		Thread play = new Thread(this);
		play.start();
	}

	private void changeText(String s)
	{
		try {
			Thread.sleep(1000);
			label.setText(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		roundNumber++;
		sequenceIndex++;
		changeText("Simon's Turn");
		changeText("");
		moveList.add(getAMove());
		showMoves();
		
		changeText("Your Turn");
		playerTurn();
	}

	private void playerTurn() {
		ArrayList<MoveInterfaceTamanna> playerMoves = new ArrayList<MoveInterfaceTamanna>();
		boolean gettingPlayerMoves = true;
		
		while(gettingPlayerMoves)
		{
			
		}
	}
	
	private void showMoves() {
		for(MoveInterfaceTamanna move: moveList)
		{
			try {
				move.getButton().blink();
				Thread.sleep(1000/roundNumber);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ButtonInterfaceTamanna getAButton(Color color) {
		return null;
	}
	
	private MoveInterfaceTamanna getAMove() {
		return null;
	}
	
	private ProgressInterfaceTamanna getProgress() {
		
		ProgressInterfaceTamanna progress = new Progress(0, 0, 300, 100, "", round, sequenceLength);
		return progress;
	
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		buttonList = new ArrayList<ButtonInterfaceTamanna>();
		moveList = new ArrayList<MoveInterfaceTamanna>();
		getButtons();
		
		label = new TextLabel(0, 0, getWidth(), 200, "");
		progress = getProgress();
		moveList.add(getAMove());
		moveList.add(getAMove());
	}

	private void getButtons() {
		ButtonInterfaceTamanna button1 = getAButton(Color.red);
		ButtonInterfaceTamanna button2 = getAButton(Color.blue);
		ButtonInterfaceTamanna button3 = getAButton(Color.yellow);
		ButtonInterfaceTamanna button4 = getAButton(Color.green);
		
		buttonList.add(button1);
		buttonList.add(button2);
		buttonList.add(button3);
		buttonList.add(button4);
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
}
