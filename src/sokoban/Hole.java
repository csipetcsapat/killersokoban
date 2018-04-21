package sokoban;

/**Lyuk, ha nyitva van és ládát tolnak rá az leesik azaz kikerül a játéktérről.
Ha játékos áll rá ugyanilyen állapotban, akkor meghal.
Ha nem tartozik hozzá kapcsoló mindig nyitva van.
 */
public class Hole extends Field {
    private boolean open;
    private int ID;

    /**
     * konstruktor
     * @param objName az objektum neve
     */
    public Hole(int ID)
    {
        super();
        open = false;
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
}
