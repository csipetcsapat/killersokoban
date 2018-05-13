package sokoban;

import graphics.Drawable;

/**A játéktér mezőit reprezentáló osztály.
Ezek nyilvántartják a szomszédjaikat és a rajtuk található Thing osztályú “tárgyakat�.
*/


public class Field implements Drawable {
    protected Thing thing;
    private Field[] neighbours= new Field[4];
    protected int roughness;
    private Object graphic;

    /**
     * konstruktor
     * @param objName az objektum neve
     */
    public Field() {
    	
    	roughness = 5;
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
    
    
	
	@Override
	public Object GetGraphic() {
		return graphic;
	}

	@Override
	public void SetGraphic(Object graphic) {
		this.graphic = graphic;
	}

	public String toString() {
		
		
		String s = "" + roughness + "F";
		String thingStr;
		
		if (thing != null) {
			if ((thingStr = thing.toString()) == "#") {
				s = "#";
			} else {
				s += thingStr;
			}
			
		}
		
		return s;
				
		
	}

}
