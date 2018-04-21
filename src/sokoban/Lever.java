package sokoban;



/**Kapcsoló, amely egy hozzá tartozó lyukat vezérel.
Ha láda kerül rá a vonatkozó Hole objektum kinyílik.
 */
public class Lever extends Field {
    private Hole hole;
    private int ID;

    /**
     * konstrunktor
     * @param objName az objektum neve
     */
    public Lever(int ID)
    {
      super();
      this.ID = ID;
    }

    /**
     * átkapcsolja a hozzá tartozó lyukat
     */
    public void Operate()
    {
    	
        hole.Toggle();
    }
    
    public int GetID() {
    	return ID;
    }

    /**
     * @param h az adott lyukat társítja magához
     */
    public void SetHole(Hole h)
    {
    	
        hole=h;
    }
    
    public String toString() {
    	String s = "" + roughness + "L" + ID;
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
