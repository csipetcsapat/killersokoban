package sokoban;

import test.Skeleton;

public class Hole extends Field {
    private boolean open;

    public Hole(String objName)
    {
        super(objName);
        open = false;
    }

    public void SetThing(Thing t)
    {
        if(open && t != null)
        {
            t.Destroy();
        }else super.SetThing(t);
    }

    public void Toggle()
    {
    	Skeleton.log.call(this);
        open = !open;
        this.SetThing(super.GetThing());
    }
}
