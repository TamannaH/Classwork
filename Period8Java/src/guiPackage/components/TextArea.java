package guiPackage.components;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class TextArea extends TextLabel {
	
	//private 

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
	}

	public void update(Graphics2D g){
		String[] words = getText().split(" ");
		
		
		FontMetrics fm = g.getFontMetrics();
		
		int stringWidth = fm.stringWidth(getText());
		int stringHeight = fm.getHeight();
		
		int xStart = 4;
		int yStart = stringHeight + 5;
		
		int count = 0; 
		String outputLine = "";
		for(int i = 0; i < words.length; i++){
			if(count + fm.stringWidth(words[i]) < getWidth()){
				outputLine = outputLine + " " + words[i];
			}
			else{
				yStart += stringHeight;
				g.drawString(outputLine, xStart, yStart);
				outputLine = "";
				count = 0;
			}
		}
		
	}
}
