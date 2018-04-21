package sokoban;

import java.util.ArrayList;

/**A játék alapvető vezérléséért felel, azaz betölti a pályát,
inicializálja  játékteret, ellenőrzi hogy a játék véget ért-e,
illetve nyertest hirdet ha igen.
*/
public class GameManager  implements Loggable {
	private Worker currentPlayer;
	private String objName;

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 */
	public GameManager() {
    	
    }

	/**
	 * @param player beállítja az aktuális játékost
	 */
	public void setCurrentPlayer(Worker player) {
		
		currentPlayer = player;
	}

	/**
	 * @return visszaadja az aktuális játékost
	 */
	public Worker getCurrentPlayer() {
		
		return currentPlayer;
	}

	/**
	 * @return visszadja az objektum nevét
	 */
	public String GetObjName() {
		return objName;
	}
	
	public void SetBoxes(ArrayList<Box> boxes) {}
	
	public void SetPlayers(ArrayList<Worker> players) {}
	
	
}
