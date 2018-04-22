package sokoban;

import java.util.ArrayList;
import java.util.Scanner;

/**A játék alapvető vezérléséért felel, azaz betölti a pályát,
inicializálja  játékteret, ellenőrzi hogy a játék véget ért-e,
illetve nyertest hirdet ha igen.
*/
public class GameManager  implements Loggable {
	private Worker currentPlayer;
	private String objName;
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

	/**
	 * @return visszadja az objektum nevét
	 */
	public String GetObjName() {
		return objName;
	}
	
	public void SetBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}
	
	public void SetPlayers(ArrayList<Worker> players) {
		this.players = players;
	}
	
	public void SetMap(Map map) {
		this.map = map;
	}
	
	public void Play() {
		
		
		// ide kell majd a parancsertelmezo, ez igy csak egy kis WASD tesztloop de mukodik player 1 nek
		
		
		boolean hasEnded = false;
		
		for(Worker w : players) {
	    	System.out.println(""+w.GetID()+" "+w.GetForce() 
	    	//+ w.GetField() == null ? " dead" : " alive"
	    	);
	    }
		map.PrintMap();
		
		Scanner scan= new Scanner(System.in);
		while(!hasEnded) {
			
			
			char input = scan.next().charAt(0);
			
			switch (input) {
				case 'w' : 	players.get(0).Move(Directions.UP);		
							this.setCurrentPlayer(players.get(0));
							break;
				case 's' :  players.get(0).Move(Directions.DOWN);
							this.setCurrentPlayer(players.get(0));
							break;
				case 'a' :  players.get(0).Move(Directions.LEFT);
							this.setCurrentPlayer(players.get(0));
							break;
				case 'd' :  players.get(0).Move(Directions.RIGHT);
							this.setCurrentPlayer(players.get(0));
							break;
				case 27: 	hasEnded = true;
							
				default : continue;
				
			
			}
		    CheckEndgame();
		    
		   
		    
		    for(Worker w : players) {
		    	System.out.println(""+w.GetID()+" "+w.GetForce() 
		    	//+ w.GetField() == null ? " dead" : " alive"
		    	);
		    }
		    
			map.PrintMap();	
		}
		scan.close();
		
		
		
		
	}
	
	public boolean CheckEndgame() {
		return false;
		//TODO:ezt meg kell irni
		
	}
	
	
	
}
