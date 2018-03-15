
public class Worker extends Thing {

	Worker(Field field) {
		super(field);
	}
	
	public boolean Move(Directions d) {
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing t = nextField.GetThing();
		
		if (t == null || t.InteractWorker(d)) {
			currentField.SetThing(null);
			nextField.SetThing(this);
			SetField(nextField);

			return true;
		}
		
		return false;
	}

	@Override
	public void Destroy() {
		GetField().SetThing(null);
	}

	@Override
	public boolean InteractWorker(Directions d) {
		return false;
	}

	@Override
	public boolean Movable(Directions d) {
		return true;
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
