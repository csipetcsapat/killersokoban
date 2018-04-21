package sokoban;


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
		GetField().SetThing(null);
		SetField(null);
	}

	/**
	 * @param d ebbe az irányba tolják a dobozt
	 * @param f ezzel az erővel
	 * @return ha elmozdul, akkor true, különben false
	 */
	@Override
	public boolean InteractWorker(Directions d, int f) {
		
		return InteractBox(d, f);
	}

	/**
	 * @param d ebbe az irányba akarják tolni a dobozt
	 * @param f ezzel az erővel
	 * @return ha mozgatható true-val, ha nem false-al tér vissza
	 */
	@Override
	public boolean Movable(Directions d, int f) {
		
		
		Field currentField = GetField();
		
		int roughness = currentField.GetRoughness();
		if( roughness > f) {
			return false;
		}
		
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.Movable(d,  f-roughness))
			return true;
		
		return false;
	}

	/**
	 * @param d ebbe az irányba tolják a dobozt
	 * @param f ezzel az erővel
	 * @return ha mozgatható true-val, ha nem false-al tér vissza
	 */
	@Override
	public boolean InteractBox(Directions d, int f) {
		
		
		Field currentField = GetField();
		int roughness = currentField.GetRoughness();
		if( roughness > f) {
			return false;
		}
		
		
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing == null || thing.InteractBox(d, f-roughness)) {
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
