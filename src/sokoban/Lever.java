package sokoban;
public class Lever extends Field {
    private Hole hole;

    public Lever(String objName)
    {
      super(objName);
    }

    public void Operate()
    {
        hole.Toggle();
    }

    public void SetHole(Hole h)
    {
        hole=h;
    }
}
