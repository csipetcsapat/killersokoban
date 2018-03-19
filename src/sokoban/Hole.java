package sokoban;

import test.Skeleton;
/**Lyuk, ha nyitva van és ládát tolnak rá az leesik azaz kikerül a játéktérről.
Ha játékos áll rá ugyanilyen állapotban, akkor meghal.
Ha nem tartozik hozzá kapcsoló mindig nyitva van.
 */
public class Hole extends Field {
    private boolean open;

    /**
     * konstruktor
     * @param objName az objektum neve
     */
    public Hole(String objName)
    {
        super(objName);
        open = false;
    }

    /**
     * @param t az adott thinget ráhelyezi a fieldre
     */
    public void SetThing(Thing t)
    {
    	Skeleton.log.call(this);
        if(open && t != null)
        {
            t.Destroy();
        }else super.SetThing(t);
    }

    /**
     * kinyitja/bezárja a lyukat, majd újra set-eli a rajta lévő thingeket
     */
    public void Toggle()
    {
    	Skeleton.log.call(this);
        open = !open;
        this.SetThing(super.GetThing());
    }
}
