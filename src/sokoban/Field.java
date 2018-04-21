package sokoban;


/**A játéktér mezőit reprezentáló osztály.
Ezek nyilvántartják a szomszédjaikat és a rajtuk található Thing osztályú “tárgyakat�.
*/


public class Field implements Loggable {
    private Thing thing;
    private Field[] neighbours= new Field[4];
    private String objName;
    private int roughness;

    /**
     * konstruktor
     * @param objName az objektum neve
     */
    public Field() {
    	
    	roughness = 10;
    }

    /**
     * @param t az adott thinget ráhelyezi a fieldre
     */
    public void SetThing(Thing t)
    {
    	
        thing = t;
    }

    /**
     * @param d ebbe az irányba kérdezi meg a szomszéd mezőt
     * @return visszaadja a kérdezett mezőt
     */
    public Field GetNeighbour(Directions d)
    {
    	
    	
        return neighbours[d.ordinal()];
    }

    /**
     * @return visszaadja a fielden lévő thinget
     */
    public Thing GetThing()
    {
        return thing;
    }
    
    public int GetRoughness() 
    {
    	return roughness;
    }
    
    public void SetRoughness(int r) 
    {
    	roughness = r;
    }
    
    

    /**
     * nem csinál semmit, leszármazottakban lesz szerepe
     */
    public void Operate()
    {
    	
    }

    /**
     * @param d ebbe az irányba állítja be a szomszédot
     * @param f erre a fieldre
     */
    public void SetNeighbour(Directions d,Field f)
    {
    	
        neighbours[d.ordinal()]=f;
    }

    /**
     * @return visszaadja az objektum nevét
     */
	public String GetObjName() {
		return objName;
	}

}
