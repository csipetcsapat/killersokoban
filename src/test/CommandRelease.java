package test;

import java.util.ArrayList;

import sokoban.Worker;

public class CommandRelease implements Command {

	@Override
	public void execute(String[] args) {
		int id = Integer.parseInt(args[0]);
		
		ArrayList<Worker> players = Proto.gm.GetPlayers();
		
		Worker player = null;
		for (Worker worker : players) {
			if (worker.GetID() == id) {
				if (worker.GetField() == null) {
					System.out.println("Player " + id + " is dead.");
					return;
				}
				
				player = worker;
				break;
			}
		}
		
		if (player == null) {
			System.out.println("No such player.");
			return;
		}
		
		if (args[1].equals("honey")) {
			player.ReleaseHoney();
			System.out.println("Honey released.");
		} else if (args[1].equals("oil")) {
			player.ReleaseOil();
			System.out.println("Oil released.");
		} else
			System.out.println("No such material.");
	}

}
