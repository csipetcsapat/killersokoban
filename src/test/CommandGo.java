package test;

import java.util.ArrayList;

import sokoban.Directions;
import sokoban.Worker;

public class CommandGo implements Command {

	@Override
	public void execute(String[] args) {
		int id = Integer.parseInt(args[0]);
		Directions d = null;
		
		if (args[1].equals("up"))
			d = Directions.UP;
		else if (args[1].equals("right"))
			d = Directions.RIGHT;
		else if (args[1].equals("down"))
			d = Directions.DOWN;
		else if (args[1].equals("left"))
			d = Directions.LEFT;
		
		ArrayList<Worker> players = Proto.gm.GetPlayers();
		
		for (Worker worker : players) {
			if (worker.GetID() == id) {
				if (worker.GetField() == null) {
					System.out.println("Player " + id + " is dead.");
					return;
				}
				
				Proto.gm.setCurrentPlayer(worker);
				boolean move = worker.Move(d);
				
				if (move)
					System.out.println("Player " + id + " moved.");
				else
					System.out.println("Could not move.");
				return;
			}
		}
		
		System.out.println("No such player.");
	}

}
