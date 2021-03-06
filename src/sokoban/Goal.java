package sokoban;



/**Speciális mező, a játék célja hogy ezekre a mezőkre kerüljenek a ládák.
Ha a játék véget ér és ezen a mezőn láda áll akkor azért pont jár
annak a játékosnak aki idetolta.
*/
public class Goal extends Field {
	/**
	 * Az objektum ami az adott grafikában grafikusan reprezentálja a a célmezőket.
	 * */
	private static Object graphic;
	
    public Goal(GameManager gm) {
		super();
		
		this.gm = gm;
		
	}

	private Worker scoreOwner;
	private GameManager gm;

    /**
     * @param t az adott thinget ráhelyezi a fieldre
     */
    public void SetThing(Thing t)
    {
    	
        super.SetThing(t);
    }

    /**
     * @return visszadja azt a játékost, akié a pont
     */
    public Worker GetScoreOwner()
    {
    	
        return scoreOwner;
    }

    /**
     * hozzáadja az az aktuális játékoshoz a pontot
     */
    public void Operate()
    {
    	
    	if (scoreOwner != null)
    		scoreOwner = null;
    	else {
	    	scoreOwner = gm.getCurrentPlayer();    	
	    	
	    	scoreOwner.AddScore();
    	}
        
    }
	public String toString() {
		String s = "" + roughness + "G";
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
	 * Beállítja az osztályhoz tartozó grafikus objektumot.
	 * @param graphic a grafikus objektum amire be akarjuk állítani.
	 */
	public static void SetGraphic(Object graphic) {
		Goal.graphic = graphic;
	}
	
	 /**
	 * Visszaadja az osztályt reprezentáló grafikus objektumot.
	 * @return a grafikus objektum 
	 */
	@Override
	public Object GetGraphic() {
		return Goal.graphic;
	}
}
