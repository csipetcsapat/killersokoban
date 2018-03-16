package sokoban;

public class GameManager {
	private Worker currentPlayer;
	
	public void setCurrentPlayer(Worker player) {
		currentPlayer = player;
	}
	
	public Worker getCurrentPlayer() {
		return currentPlayer;
	}
}
