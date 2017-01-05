package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPackage.components.Button;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;
import guiPackage.sampleGames.ClickableScreen;

public class SimonScreenTamanna extends ClickableScreen implements Runnable {
	
	public ArrayList<ButtonInterfaceTamanna> buttonList;
	public ArrayList<MoveInterfaceTamanna> sequence;
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
		
		Thread app = new Thread(this);
		app.start();
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
		sequence.add(randomMove());
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
		for(MoveInterfaceTamanna move: sequence)
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
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		buttonList = new ArrayList<ButtonInterfaceTamanna>();
		sequence = new ArrayList<MoveInterfaceTamanna>();
		getButtons();
		
		label = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
		progress = getProgress();
		sequence.add(randomMove());
		sequence.add(randomMove());
		
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceTamanna randomMove() {
		final ButtonInterfaceTamanna b = getAButton(null);
		//code that randomly selects a ButtonInterfaceX
		return getMove(b);
	}
	
	private MoveInterfaceTamanna getMove(ButtonInterfaceTamanna b) {
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceTamanna getProgress() {
		return null;
	}
	
	private void getButtons() {
		
		int numberOfButtons = 4; 
		
		ButtonInterfaceTamanna button1 = getAButton(Color.red);
		ButtonInterfaceTamanna button2 = getAButton(Color.blue);
		ButtonInterfaceTamanna button3 = getAButton(Color.yellow);
		ButtonInterfaceTamanna button4 = getAButton(Color.green);
		
		buttonList.add(button1);
		buttonList.add(button2);
		buttonList.add(button3);
		buttonList.add(button4);
		
		addButton(button1);
		addButton(button2);
		addButton(button3);
		addButton(button4);
	}

	private void addButton(ButtonInterfaceTamanna button1) {
		// TODO Auto-generated method stub
		
	}
}
