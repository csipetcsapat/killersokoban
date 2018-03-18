package sokoban;

import test.Skeleton;

public abstract class Thing implements Loggable {
	private Field field;
	private String objName;
	
	Thing(String objName, Field field) {
		this.field = field;
		this.objName = objName;
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public abstract void Destroy();
	public abstract boolean InteractWorker(Directions d);
	
	public void SetField(Field field) {
		Skeleton.log.call(this);
		
		this.field = field;
	}
	
	public Field GetField() {
		Skeleton.log.call(this);
		
		return field;
	}
	
	public abstract boolean Movable(Directions d);
	public abstract boolean InteractBox(Directions d);
}
