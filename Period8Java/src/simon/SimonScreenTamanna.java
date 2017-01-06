package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPackage.components.Action;
import guiPackage.components.Button;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;
import guiPackage.sampleGames.ClickableScreen;

public class SimonScreenTamanna extends ClickableScreen implements Runnable {
	public ArrayList<ButtonInterfaceTamanna> buttonList;
	public ArrayList<MoveInterfaceTamanna> moveList;
	public ArrayList<MoveInterfaceTamanna> sequenceOfMoves;
	public ProgressInterfaceTamanna progress;
	public TextLabel turn;
	public int roundNumber;
	public int sequenceIndex;
	public static boolean acceptingInput;
	
	public SimonScreenTamanna(int width, int height) {
		super(width, height);
		roundNumber = 0;
		sequenceIndex = 2;
		
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		buttonList = new ArrayList<ButtonInterfaceTamanna>();
		moveList = new ArrayList<MoveInterfaceTamanna>();
		sequenceOfMoves = new ArrayList<MoveInterfaceTamanna>();
		getButtons();
		
		turn = new TextLabel(0, 0, getWidth(), 200, "");
		progress = getProgress();
		moveList.add(getMove());
		moveList.add(getMove());
	}

	private void getButtons() {
		ButtonInterfaceTamanna button1 = getAButton(10, 150, 50, 50, Color.blue);
		ButtonInterfaceTamanna button2 = getAButton(10, 150, 50, 50, Color.green);
		ButtonInterfaceTamanna button3 = getAButton(10, 150, 50, 50, Color.red);
		ButtonInterfaceTamanna button4 = getAButton(10, 150, 50, 50, Color.yellow);
		
		buttonList.add(button1);
		buttonList.add(button2);
		buttonList.add(button3);
		buttonList.add(button4);
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	
	private void add(ButtonInterfaceTamanna button1) {
		// TODO Auto-generated method stub
		
	}

	private void changeText(String s)
	{
		try {
			Thread.sleep(1000);
			turn.setText(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		acceptingInput = false;
		sequenceOfMoves = new ArrayList<MoveInterfaceTamanna>();
		newRound();
		
		changeText("Simon's Turn");
		changeText("");
		moveList.add(getMove());
		showMoves();
		
		changeText("Your Turn");
		acceptingInput = true;
		
	}
	
	private void newRound()
	{
		roundNumber++;
		sequenceIndex ++;
		
		progress.setRound(roundNumber);
		progress.setSequenceLength(sequenceIndex);
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
	
	public void checkMove(MoveInterfaceTamanna move)
	{
		if(acceptingInput)
		{
			sequenceOfMoves.add(move);
			if(sequenceOfMoves.equals(moveList.subList(0, sequenceOfMoves.size())))
			{
				move.getButton().blink();
				if(sequenceOfMoves.equals(moveList))
				{
					Thread play = new Thread(this);
					play.start();
				}
			}
			else
			{
				acceptingInput = false;
				changeText("You Lost!");
			}
		}
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceTamanna getProgress() {
		
		ProgressInterfaceTamanna progress = new Progress(0, 0, 300, 100, "", roundNumber, sequenceIndex);
		return progress;
	
	}
	
	private ButtonInterfaceTamanna getAButton(int x, int y, int width, int height, Color color) {
		ButtonInterfaceTamanna button = new Button(x, y, width, height, color);
		button.setAction(new Action() {
			public void act()
			{
				button.blink();
				checkMove(new Move(button));
			}
		});
		
		return button;
	}
	
	private MoveInterfaceTamanna getMove() {
		MoveInterfaceTamanna move;
		
		do
		{
			ButtonInterfaceTamanna randomButton = buttonList.get((int)  Math.random() * buttonList.size());
			move = new Move(randomButton);
			
		}while(!moveList.get(moveList.size() - 1).equals(move));
		
		return move;
	}
}
	

