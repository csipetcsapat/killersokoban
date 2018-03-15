
public abstract class Thing {
	private Field field;
	
	Thing(Field field) {
		this.field = field;
	}
	
	public abstract void Destroy();
	public abstract boolean InteractWorker(Directions d);
	
	public void SetField(Field field) {
		Skeleton.log.call(this);
		
		this.field = field;
		
		Skeleton.log.endCall();
	}
	
	public Field GetField() {
		Skeleton.log.call(this);
		Skeleton.log.endCall();
		return field;
	}
	
	public abstract boolean Movable(Directions d);
	public abstract boolean InteractBox(Directions d);
}
