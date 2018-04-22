package test;

import java.util.ArrayList;

import sokoban.Hole;

public class CommandHolestatus implements Command {

	@Override
	public void execute(String[] args) {
		int id = Integer.parseInt(args[0]);
		ArrayList<Hole> holes = Proto.gm.GetMap().GetHoles();
		for (Hole hole : holes) {
			if (hole.GetID() == id) {
				System.out.println("Hole " + id + " is " + (hole.GetStatus() ? "open" : "closed") + ".");
			}
		}
	}

}
