package sokoban;

import java.util.ArrayList;
import java.util.Set;

/**A játék alapvető vezérléséért felel, azaz betölti a pályát,
inicializálja  játékteret, ellenőrzi hogy a játék véget ért-e,
illetve nyertest hirdet ha igen.
*/
public class GameManager {
	private Worker currentPlayer;
	private ArrayList<Worker> players;
	private ArrayList<Box> boxes;
	private Map map;
	
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
	
	public void SetBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}
	
	public void SetPlayers(ArrayList<Worker> players) {
		this.players = players;
	}
	
	public ArrayList<Worker> GetPlayers() {
		return players;
	}
	
	public void SetMap(Map map) {
		this.map = map;
	}
	
	public Map GetMap() {
		return map;
	}
	
	public void Play() {
		
	}
	
	public boolean CheckEndgame() {
		if (IsEveryBoxOnGoalField()) //also true if there are no boxes left
			return true;
		
		for (Worker player : players) {
			if (player.GetField() == null)
				continue;
			
			Set<Field> accessibleFields = map.AccessibleFields(player.GetField());
			for (Box box : boxes) {
				if (box.GetField() == null)
					continue;
				
				if (IsBoxAccessible(box, accessibleFields, player.GetForce()))
					return false;
			}
		}
		
		return true;
	}
	
	
	private boolean IsBoxAccessible(Box box, Set<Field> accessibleFields, int force) {
		
		Field neighbour = box.GetField().GetNeighbour(Directions.DOWN);
		if (box.Movable(Directions.UP, force) && neighbour != null &&
				accessibleFields.contains(neighbour))
			return true;
		
		neighbour = box.GetField().GetNeighbour(Directions.LEFT);
		if (box.Movable(Directions.RIGHT, force) && neighbour != null &&
				accessibleFields.contains(neighbour))
			return true;
		
		neighbour = box.GetField().GetNeighbour(Directions.UP);
		if (box.Movable(Directions.DOWN, force) && neighbour != null &&
				accessibleFields.contains(neighbour))
			return true;
		
		neighbour = box.GetField().GetNeighbour(Directions.RIGHT);
		if (box.Movable(Directions.LEFT, force) && neighbour != null &&
				accessibleFields.contains(neighbour))
			return true;
		
		
		return false;
	}
	
	private boolean IsEveryBoxOnGoalField() {
		for (Box box : boxes) {
			for (Goal goal : map.GetGoals()) {
				if (box.GetField() != goal)
					return false;
			}
		}
		
		if (map.GetGoals().size() == 0)
			return false;
		
		return true;
	}
	
}
