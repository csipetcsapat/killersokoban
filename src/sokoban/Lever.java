package sokoban;
public class Lever extends Field {
    private Hole hole;

    public Lever()
    {
      super();
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
