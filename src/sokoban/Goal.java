package sokoban;
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
        return scoreOwner;
    }

    public void Operate()
    {
        //Skeleton.gm.getCurrentPlayer().AddScore();
    }
}
