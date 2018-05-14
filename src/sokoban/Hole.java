package sokoban;

/**Lyuk, ha nyitva van és ládát tolnak rá az leesik azaz kikerül a játéktérről.
Ha játékos áll rá ugyanilyen állapotban, akkor meghal.
Ha nem tartozik hozzá kapcsoló mindig nyitva van.
 */
public class Hole extends Field {
    private boolean open;
    private int ID;
    /**
	 * Az objektumok amik az adott grafikában grafikusan reprezentálják a nyitott és a zárt lyukat.
	 * */
    private static Object graphicO, graphicC;

    /**
     * konstruktor
     * @param objName az objektum neve
     */
    public Hole(int ID)
    {
        super();
        open = true;
        this.ID = ID;
    }

    /**
     * @param t az adott thinget ráhelyezi a fieldre
     */
    public void SetThing(Thing t)
    {
    	
        if(open && t != null)
        {
            t.Destroy();
        }else super.SetThing(t);
    }
    
    public boolean GetStatus() {
    	return open;
    }

    
    public int GetID() {
    	return ID;
    }
    /**
     * kinyitja/bezárja a lyukat, majd újra set-eli a rajta lévő thingeket
     */
    public void Toggle()
    {
    	
        open = !open;
        this.SetThing(super.GetThing());
    }
    public String toString() {
    	String s = "" + roughness + "H"+ ID;
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
    
    /**
	 * Beállítja az nyitott lyukhoz tartozó grafikus objektumot.
	 * @param graphic a grafikus objektum amire be akarjuk állítani.
	 */
    public static void SetOpenGraphic(Object graphic) {
		Hole.graphicO = graphic;
	}
    
    /**
	 * Beállítja az zárt lyukhoz tartozó grafikus objektumot.
	 * @param graphic a grafikus objektum amire be akarjuk állítani.
	 */
    public static void SetClosedGraphic(Object graphic) {
    	Hole.graphicC = graphic;
    }
    /**
  	 * Visszaadja a lyuk állapotától függöen a lyukat reprezentáló grafikus objektumot.
  	 * @return a grafikus objektum 
  	 */
	@Override
	public Object GetGraphic() {
		
		
		return open == true ?  Hole.graphicO : Hole.graphicC;
	}
}
