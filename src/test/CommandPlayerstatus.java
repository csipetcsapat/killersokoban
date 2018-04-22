package test;

import java.util.ArrayList;

import sokoban.Worker;

public class CommandPlayerstatus implements Command {

	@Override
	public void execute(String[] args) {
		int id = Integer.parseInt(args[0]);
		
		ArrayList<Worker> players = Proto.gm.GetPlayers();

		for (Worker worker : players) {
			if (worker.GetID() == id) {
				if (worker.GetField() == null)
					System.out.print("Player " + id  + " is dead.");
				else
					System.out.print("Player " + id + " is alive.");
				
				System.out.println(" Force: " + worker.GetForce());
				
				return;
			}
		}
		
		System.out.println("No such player.");
	}

}
