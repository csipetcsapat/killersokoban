public class Field {
    private Thing thing;
    private Field[] neighbours= new Field[4];

    public Field(){}

    public void SetThing(Thing t)
    {
    	Skeleton.log.call();
    	
        thing = t;
    }

    public Field GetNeighbour(Directions d)
    {
    	Skeleton.log.call();
    	
        return neighbours[d.ordinal()];
    }

    public Thing GetThing()
    {
    	Skeleton.log.call();
    	
        return thing;
    }

    public void Operate()
    {
    	Skeleton.log.call();
    }

    public void SetNeighbour(Directions d,Field f)
    {
    	Skeleton.log.call();
    	
        neighbours[d.ordinal()]=f;
    }

}
