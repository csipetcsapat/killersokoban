package sokoban;

import test.Skeleton;

public class Goal extends Field {
    public Goal(String objName) {
		super(objName);
	}

	private Worker scoreOwner;

    public void SetThing(Thing t)
    {
    	Skeleton.log.call(this);
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
    	Worker w = Skeleton.gm.getCurrentPlayer();
    	w.AddScore();
        scoreOwner = w;
    }
}
