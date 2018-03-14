
public class Box extends Thing {

	Box(Field field) {
		super(field);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean InteractWorker(Directions d) {
		return InteractBox(d);
	}

	@Override
	public boolean Movable(Directions d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean InteractBox(Directions d) {
		// TODO Auto-generated method stub
		return false;
	}

}
