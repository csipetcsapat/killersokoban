package sokoban;

/**A játékos által irányított munkást reprezentáló osztály.
A ládákat el tudja tolni.
Ha másik játékos ládát tol rá és nem tud kitérni meghal.
Közvetlenül másik játékos nem tudja megmozdítani.
 */
public class Worker extends Thing {
	
	private int score;

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 * @param field erre a fieldre kerül az objektum
	 */
	public Worker(String objName, Field field) {
		super(objName, field);
	}

	/**
	 * @param d ebbe az irányba léptetjük a játékost
	 * @return visszaadja a léptetés sikerességét
	 */
	public boolean Move(Directions d) {
		
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing t = nextField.GetThing();
		
		if (t == null || t.InteractWorker(d)) {
			currentField.SetThing(null);
			nextField.SetThing(this);
			
			if (nextField.GetThing() != null)
				SetField(nextField);

			return true;
		}
		
		return false;
	}

	/**
	 * növeli a játékos pontjainak számát 1-gyel
	 */
	public void AddScore() {
		++score;
	}

	/**
	 * törli a játékost a játéktérről
	 */
	@Override
	public void Destroy() {
		
		
		GetField().SetThing(null);
		SetField(null);
	}

	/**
	 * @param d ebbe az irányba akarja tolni egy másik játékos
	 * @return mindig false-al tér vissza, játékos játékost közvetlenül nem tolhat
	 */
	@Override
	public boolean InteractWorker(Directions d) {
		
		
		return false;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @return mindig true-val tér vissza
	 */
	@Override
	public boolean Movable(Directions d) {
		
		
		return true;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @return mindig true-val tér vissza, de ha az adott d irányban van mellette valami megsemmisül,
	 * ellenkező esetben átlép arra a fieldre
	 */
	@Override
	public boolean InteractBox(Directions d) {
		
		
		Field currentField = GetField();
		Field nextField = currentField.GetNeighbour(d);
		Thing thing = nextField.GetThing();
		
		if (thing != null) {
			Destroy();
		} else {
			currentField.SetThing(null);
			nextField.SetThing(this);
			
			if (nextField.GetThing() != null)
				SetField(nextField);
		}
		
		return true;
	}

}
