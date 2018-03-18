package sokoban;

import test.Skeleton;

public class GameManager  implements Loggable {
	private Worker currentPlayer;
	private String objName;
	
	public GameManager(String objName) {
    	this.objName = objName;
    }
	public void setCurrentPlayer(Worker player) {
		Skeleton.log.call(this);
		currentPlayer = player;
	}
	
	public Worker getCurrentPlayer() {
		Skeleton.log.call(this);
		return currentPlayer;
	}
	
	public String GetObjName() {
		return objName;
	}
}
