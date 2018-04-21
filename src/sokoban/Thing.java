package sokoban;



/**A mezőkön elhelyezkedő tárgyak absztrakt ősosztálya.
 */
public abstract class Thing implements Loggable {
	private Field field;
	private String objName;

	/**
	 * konstruktor
	 * @param objName az objektum neve
	 * @param field az a field, amelyre a thing kerül
	 */
	Thing(String objName, Field field) {
		this.field = field;
		this.objName = objName;
	}

	/**
	 * @return visszaadja az objektum nevét
	 */
	public String GetObjName() {
		return objName;
	}

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract void Destroy();

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract boolean InteractWorker(Directions d, int f);

	/**
	 * @param field beállítja az objektumhoz tartozó a fieldet
	 */
	public void SetField(Field field) {
		
		
		this.field = field;
	}

	/**
	 * @return visszaadja az objektumhoz tartozó fieldet
	 */
	public Field GetField() {
		
		
		return field;
	}

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract boolean Movable(Directions d, int f);

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract boolean InteractBox(Directions d, int f);
}
