package sokoban;
public class Hole extends Field {
    private boolean open;

    public Hole()
    {
        super();
        open = false;
    }

    public void SetThing(Thing t)
    {
        if(open)
        {
            t.Destroy();
        }else super.SetThing(t);
    }

    public void Toggle()
    {
        open = !open;
        this.SetThing(super.GetThing());
    }
}
