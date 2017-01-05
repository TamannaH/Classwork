package simon;

import guiPackage.components.Clickable;

public interface ButtonInterfaceTamanna extends Clickable {
	public void blink();
	b.setAction(new Action(){

		public void act(){
			if(acceptingInput){
				Thread blink = new Thread(new Runnable(){
					public void run(){
					
					}
				});
				
				blink.start();
				b.highlight();
			}
		}

	});
}
