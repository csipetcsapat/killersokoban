package sokoban;

import test.Skeleton;

public class Box extends Thing {

	public Box(String objName, Field field) {
		super(objName, field);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Destroy() {
		Skeleton.log.call(this);
		
		GetField().SetThing(null);
	}

	@Override
	public boolean InteractWorker(Directions d) {
		Skeleton.log.call(this);
		
		return InteractBox(d);
	}

	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.Movable(d))
			return true;
		
		return false;
	}

	@Override
	public boolean InteractBox(Directions d) {
		Skeleton.log.call(this);
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.InteractBox(d)) {
			currentField.Operate();
			currentField.SetThing(null);
			nextField.SetThing(this);
			nextField.Operate();
			
			this.SetField(nextField);
			
			return true;
		}
		
		return false;
	}
}
