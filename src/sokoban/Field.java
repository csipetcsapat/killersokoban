package sokoban;

import test.Skeleton;

public class Field implements Loggable {
    private Thing thing;
    private Field[] neighbours= new Field[4];
    private String objName;

    public Field(String objName) {
    	this.objName = objName;
    }

    public void SetThing(Thing t)
    {
    	Skeleton.log.call(this);
    	
        thing = t;
    }

    public Field GetNeighbour(Directions d)
    {
    	Skeleton.log.call(this);
    	
        return neighbours[d.ordinal()];
    }

    public Thing GetThing()
    {
    	Skeleton.log.call(this);
    	
        return thing;
    }

    public void Operate()
    {
    	Skeleton.log.call(this);
    }

    public void SetNeighbour(Directions d,Field f)
    {
    	Skeleton.log.call(this);
    	
        neighbours[d.ordinal()]=f;
    }

	public String GetObjName() {
		return objName;
	}

}
