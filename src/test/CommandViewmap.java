package test;

import java.util.ArrayList;

import sokoban.Map;
import sokoban.Worker;

public class CommandViewmap implements Command {

	@Override
	public void execute(String[] args) {
		Map map = Proto.gm.GetMap();
		
		if (map == null) {
			System.out.println("No map loaded.");
			return;
		}
		
		ArrayList<Worker> players = Proto.gm.GetPlayers();
		
		for (Worker worker : players)
			System.out.println(worker.GetID() + " " + worker.GetForce());
		
		map.PrintMap();
	}

}
