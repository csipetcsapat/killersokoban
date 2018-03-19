package sokoban;

import test.Skeleton;

/**A falat vagy oszlopot reprezentáló osztály,
egy mezőnyi helyet foglal semmi nem tudja megmozdítani.
 **/
public class Wall extends Thing {

	/**
	 * kostruktor
	 * @param objName az objektum neve
	 * @param field erre a fieldre állítódik be
	 */
	public Wall(String objName, Field field) {
		super(objName, field);
	}

	/**
	 * törli magát a játéktérről
	 */
	@Override
	public void Destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param d ebbe az irányba tolják
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean InteractWorker(Directions d) {
		Skeleton.log.call(this);
		return false;
	}

	/**
	 * @param d ebbe az irányba tolnák
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean Movable(Directions d) {
		Skeleton.log.call(this);
		return false;
	}

	/**
	 * @param d ebbe az irányba tolják
	 * @return mindig false-al tér vissza, mert a fal nem mozdítható
	 */
	@Override
	public boolean InteractBox(Directions d) {
		Skeleton.log.call(this);
		return false;
	}

}
