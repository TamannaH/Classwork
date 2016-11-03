package caveExplorer;

public class Inventory {

	private boolean hasMap;
	private String map;
	
	public Inventory() {
		hasMap = true;
		updateMap();
	}

	private void updateMap() {
		
	}

	public String getDescription() {
		if(hasMap){
			return map;
		}else{
			return "You have no inventory.";
		}
	}
}
