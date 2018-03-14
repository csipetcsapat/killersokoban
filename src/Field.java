public class Field {
    Thing thing;
    Field[] neighbours= new Field[4];

    public Field(){}

    public void SetThing(Thing t)
    {
        thing = t;
    }

    public Field GetNeighbour(Directions d)
    {
        return neighbours[d.ordinal()];
    }

    public Thing GetThing()
    {
        return thing;
    }

    public void Operate()
    {

    }

    public void SetNeighbour(Directions d,Field f)
    {
        neighbours[d.ordinal()]=f;
    }

}
