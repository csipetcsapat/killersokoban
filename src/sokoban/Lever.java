package sokoban;

import test.Skeleton;

public class Lever extends Field {
    private Hole hole;

    public Lever(String objName)
    {
      super(objName);
    }

    public void Operate()
    {
    	Skeleton.log.call(this);
        hole.Toggle();
    }

    public void SetHole(Hole h)
    {
    	Skeleton.log.call(this);
        hole=h;
    }
}
