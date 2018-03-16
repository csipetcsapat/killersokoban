package sokoban;

public class Worker extends Thing {

	Worker(String objName, Field field) {
		super(objName, field);
	}
	
	public boolean Move(Directions d) {
		Skeleton.log.call(this);
		
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
		Skeleton.log.call(this);
		
		GetField().SetThing(null);
	}

	@Override
	public boolean InteractWorker(Directions d) {
		Skeleton.log.call(this);
		
		return false;
	}

	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		
		return true;
	}

	@Override
	public boolean InteractBox(Directions d) {
		Skeleton.log.call(this);
		
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
