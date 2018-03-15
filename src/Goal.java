public class Goal extends Field {
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
