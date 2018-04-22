package test;

import sokoban.Map;

public class CommandLoadmap implements Command {

	@Override
	public void execute(String[] args) {
		Map map = new Map();
		
		if (map.LoadMap(0, args[0], Proto.gm)) {
			System.out.println("Map loaded.");
			Proto.gm.SetMap(map);
		} else
			System.out.println("Could not load map.");
	}

}
