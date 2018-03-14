
public class Worker extends Thing {

	Worker(Field field) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean InteractBox(Directions d) {
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing != null) {
			Destroy();
		} else {
			currentField.SetThing(null);
			nextField.SetThing(this);
		}
		
		return true;
	}

}
