package sokoban;

public class Wall extends Thing {

	public Wall(String objName, Field field) {
		super(objName, field);
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean InteractWorker(Directions d) {
		return false;
	}

	@Override
	public boolean Movable(Directions d) {
		return false;
	}

	@Override
	public boolean InteractBox(Directions d) {
		return false;
	}

}
