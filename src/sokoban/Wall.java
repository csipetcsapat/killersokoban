package sokoban;



/**A falat vagy oszlopot reprezentáló osztály,
egy mezőnyi helyet foglal semmi nem tudja megmozdítani.
 */
public class Wall extends Thing {
	private static Object graphic;

	/**
	 * kostruktor
	 * @param objName az objektum neve
	 * @param field erre a fieldre állítódik be
	 */
	public Wall( Field field) {
		super(field);
	}

	/**
	 * törli magát a játéktérről, de a fal nem tud meghalni
	 */
	@Override
	public void Destroy() {
		

	}

	/**
	 * @param d ebbe az irányba tolják
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean InteractWorker(Directions d, int f) {
		
		return false;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean Movable(Directions d, int f) {
		
		return false;
	}

	/**
	 * @param d ebbe az irányba tolják
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean InteractBox(Directions d, int f) {
	
		return false;
	}
	
	@Override
	public Object GetGraphic() {
		return graphic;
	}
	
	public static void SetGraphic(Object graphic) {
		Wall.graphic = graphic;
	}
	
	public String toString() {
		return "#";
	}

}
