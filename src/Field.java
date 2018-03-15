public class Field {
    private Thing thing;
    private Field[] neighbours= new Field[4];

    public Field(){}

    public void SetThing(Thing t)
    {
    	Skeleton.log.call(this);
    	
        thing = t;
        
        Skeleton.log.endCall();
    }

    public Field GetNeighbour(Directions d)
    {
    	Skeleton.log.call(this);
    	Skeleton.log.endCall();
    	
        return neighbours[d.ordinal()];
    }

    public Thing GetThing()
    {
    	Skeleton.log.call(this);
    	Skeleton.log.endCall();
    
        return thing;
    }

    public void Operate()
    {
    	Skeleton.log.call(this);
    	Skeleton.log.endCall();
    }

    public void SetNeighbour(Directions d,Field f)
    {
    	Skeleton.log.call(this);
    	
        neighbours[d.ordinal()]=f;
        
        Skeleton.log.endCall();
    }

}
