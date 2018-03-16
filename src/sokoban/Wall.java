package sokoban;

public class Wall extends Thing {

	Wall(Field field) {
		super(field);
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
