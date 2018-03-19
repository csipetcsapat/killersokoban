package sokoban;

import test.Skeleton;

/**Speciális mező, a játék célja hogy ezekre a mezőkre kerüljenek a ládák.
Ha a játék véget ér és ezen a mezőn láda áll akkor azért pont jár
annak a játékosnak aki idetolta.
*/
public class Goal extends Field {
    public Goal(String objName) {
		super(objName);
	}

	private Worker scoreOwner;

    /**
     * @param t az adott thinget ráhelyezi a fieldre
     */
    public void SetThing(Thing t)
    {
    	Skeleton.log.call(this);
        super.SetThing(t);
    }

    /**
     * @return visszadja azt a játékost, akié a pont
     */
    public Worker GetScoreOwner()
    {
    	Skeleton.log.call(this);
        return scoreOwner;
    }

    /**
     * hozzáadja az az aktuális játékoshoz a pontot
     */
    public void Operate()
    {
    	Skeleton.log.call(this);
    	Worker w = Skeleton.gm.getCurrentPlayer();
    	w.AddScore();
        scoreOwner = w;
    }
}
