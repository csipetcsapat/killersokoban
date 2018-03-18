package sokoban;

import test.Skeleton;

public class Goal extends Field {
    public Goal(String objName) {
		super(objName);
	}

	private Worker scoreOwner;

    public void SetThing(Thing t)
    {
        super.SetThing(t);
    }

    public Worker GetScoreOwner()
    {
    	Skeleton.log.call(this);
        return scoreOwner;
    }

    public void Operate()
    {
    	Skeleton.log.call(this);
        //Skeleton.gm.getCurrentPlayer().AddScore();
    }
}
