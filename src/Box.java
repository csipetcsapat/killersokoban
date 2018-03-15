
public class Box extends Thing {

	Box(Field field) {
		super(field);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Destroy() {
		Skeleton.log.call(this);
		
		GetField().SetThing(null);
		
		Skeleton.log.endCall();
	}

	@Override
	public boolean InteractWorker(Directions d) {
		Skeleton.log.call(this);
		Skeleton.log.endCall();
		
		return InteractBox(d);
	}

	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.Movable(d)) {
			Skeleton.log.endCall();
			return true;
		}
		
		Skeleton.log.endCall();
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
			
			Skeleton.log.endCall();
			return true;
		}
		
		Skeleton.log.endCall();
		return false;
	}
}
