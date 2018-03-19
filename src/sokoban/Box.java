package sokoban;

import test.Skeleton;

/**A játékbeli ládák reprezentálása. 1 mezőnyi helyet foglal a játéktéren.
Ha tolják akkor arrébb mozdul amennyiben bizonyos feltételek teljesülnek.
Ha az összes még mozgatható láda a célzónákra kerül a a játék véget ér.
*/
public class Box extends Thing {

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 * @param field a field, amire kerül
	 */
	public Box(String objName, Field field) {
		super(objName, field);
		// TODO Auto-generated constructor stub
	}

	/**
	 * törli magát a játéktérről
	 */
	@Override
	public void Destroy() {

		Skeleton.log.call(this);
		
		GetField().SetThing(null);
		SetField(null);
	}

	/**
	 * @param d ebbe az irányba tolják a dobozt
	 * @return ha elmozdul, akkor true, különben false
	 */
	@Override
	public boolean InteractWorker(Directions d) {
		Skeleton.log.call(this);
		
		return InteractBox(d);
	}

	/**
	 * @param d ebbe az irányba akarják tolják a dobozt
	 * @return ha mozgatható true-val, ha nem false-al tér vissza
	 */
	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.Movable(d))
			return true;
		
		return false;
	}

	/**
	 * @param d ebbe az irányba akarják tolják a dobozt
	 * @return ha mozgatható true-val, ha nem false-al tér vissza
	 */
	@Override
	public boolean InteractBox(Directions d) {
		Skeleton.log.call(this);
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.InteractBox(d)) {
			currentField.Operate();
			currentField.SetThing(null);
			nextField.SetThing(this);
			nextField.Operate();
			
			if (nextField.GetThing() != null)
				this.SetField(nextField);
			
			return true;
		}
		
		return false;
	}
}
