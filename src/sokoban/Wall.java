package sokoban;

import test.Skeleton;

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
		Skeleton.log.call(this);
		return false;
	}

	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		return false;
	}

	@Override
	public boolean InteractBox(Directions d) {
		Skeleton.log.call(this);
		return false;
	}

}
