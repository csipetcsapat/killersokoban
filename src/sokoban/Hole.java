package sokoban;
public class Hole extends Field {
    private boolean open;

    public Hole(String objName)
    {
        super(objName);
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
