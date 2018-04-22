package test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
	private Map<String, Command> commandMap = new TreeMap<>();
	
	public Interpreter() {
		commandMap.put("go", new CommandGo());
		commandMap.put("loadmap", new CommandLoadmap());
		commandMap.put("viewmap", new CommandViewmap());
		commandMap.put("release", new CommandRelease());
		commandMap.put("playerstatus", new CommandPlayerstatus());
		commandMap.put("holestatus", new CommandHolestatus());
	}
	
	public void execute(String input) {
		String[] tokens = input.split(" ");
		Command command = commandMap.get(tokens[0]);
		
		if (command != null)
			command.execute(Arrays.copyOfRange(tokens, 1, tokens.length));
	}
}
