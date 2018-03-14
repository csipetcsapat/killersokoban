public class Goal extends Field {
    private Worker scoreOwner;
    private GameManager gameManager;

    public Goal(GameManager gm)
    {
        super();
        this.gameManager=gm;
    }

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
        Worker w=gameManager.GetCurrentPlayer();
        w.AddScore;
    }
}
