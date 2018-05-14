package sokoban;

/**A játékos által irányított munkást reprezentáló osztály.
A ládákat el tudja tolni.
Ha másik játékos ládát tol rá és nem tud kitérni meghal.
Közvetlenül másik játékos nem tudja megmozdítani.
 */
public class Worker extends Thing {
	
	private int score;
	private int force;
	private int ID;
	private Object graphic;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 * @param field erre a fieldre kerül az objektum
	 */
	public Worker( Field field, int force, int ID) {
		super( field);
		this.force = force;
		this.ID = ID;
		this.score = 0;
		this.name = name;
	}
	
	public String GetName() {
		return name;
	}
	
	public int GetID() {
		return ID;
	}
	
	public int GetForce() {
		return force;
	}
	
	

	/**
	 * @param d ebbe az irányba léptetjük a játékost
	 * @return visszaadja a léptetés sikerességét
	 */
	public boolean Move(Directions d) {
		
		
		
		Field currentField = GetField();
		if (currentField == null)
			return false;
		
		
		Field nextField = currentField.GetNeighbour(d);
		Thing t = nextField.GetThing();
		
		if (t == null || t.InteractWorker(d, force)) {
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
	
	public int GetScore() {
		return score;
	}

	
	/**
	 * növeli az aktuális mező érdességét 1 el
	 */
	public void ReleaseHoney() {
		Field currentField = GetField();
		currentField.SetRoughness(
			currentField.GetRoughness() < 9 ? 
				currentField.GetRoughness() + 1 : 9);
		
	}
	
	
	/**
	 * csökkenti az aktuális mező érdességét 1 el, de min 0
	 */
	public void ReleaseOil() {
		Field currentField = GetField();
		currentField.SetRoughness(			
			currentField.GetRoughness() > 0 ? 
					currentField.GetRoughness() - 1 : 0);
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
	 * @param f ezzel az erővel
	 * @return mindig false-al tér vissza, játékos játékost közvetlenül nem tolhat
	 */
	@Override
	public boolean InteractWorker(Directions d, int f) {
		
		return false;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @param f ezzel az erővel
	 * @return mindig true-val tér vissza
	 */
	@Override
	public boolean Movable(Directions d, int f) {
		return true;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @param f ezzel az erővel
	 * @return mindig true-val tér vissza, de ha az adott d irányban van mellette valami megsemmisül,
	 * ellenkező esetben átlép arra a fieldre
	 */
	@Override
	public boolean InteractBox(Directions d, int f ) {
		
		
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
	
	@Override
	public Object GetGraphic() {
		return graphic;
	}
	
	public void SetGraphic(Object graphic) {
		this.graphic = graphic;
	}
	
	public String toString() {
		return "P" + ID;
	}

}
