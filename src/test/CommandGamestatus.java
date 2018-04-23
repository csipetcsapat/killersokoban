package test;

public class CommandGamestatus implements Command {

	@Override
	public void execute(String[] args) {
		if (Proto.gm.CheckEndgame())
			System.out.println("Game ended.");
		else
			System.out.println("Game is in progress.");
	}

}
