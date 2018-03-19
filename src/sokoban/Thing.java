package sokoban;

import test.Skeleton;

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
	public abstract boolean InteractWorker(Directions d);

	/**
	 * @param field beállítja az objektumhoz tartozó a fieldet
	 */
	public void SetField(Field field) {
		Skeleton.log.call(this);
		
		this.field = field;
	}

	/**
	 * @return visszaadja az objektumhoz tartozó fieldet
	 */
	public Field GetField() {
		Skeleton.log.call(this);
		
		return field;
	}

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract boolean Movable(Directions d);

	/**
	 * leszármazottakban van megvalósítva
	 */
	public abstract boolean InteractBox(Directions d);
}
