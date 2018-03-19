package sokoban;

import test.Skeleton;

/**A játék alapvető vezérléséért felel, azaz betölti a pályát,
inicializálja  játékteret, ellenőrzi hogy a játék véget ért-e,
illetve nyertest hirdet ha igen.
**/
public class GameManager  implements Loggable {
	private Worker currentPlayer;
	private String objName;

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 */
	public GameManager(String objName) {
    	this.objName = objName;
    }

	/**
	 * @param player beállítja az aktuális játékost
	 */
	public void setCurrentPlayer(Worker player) {
		Skeleton.log.call(this);
		currentPlayer = player;
	}

	/**
	 * @return visszaadja az aktuális játékost
	 */
	public Worker getCurrentPlayer() {
		Skeleton.log.call(this);
		return currentPlayer;
	}

	/**
	 * @return visszadja az objektum nevét
	 */
	public String GetObjName() {
		return objName;
	}
}
