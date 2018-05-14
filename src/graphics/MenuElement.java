package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Egy menügombot megvalósító osztály. Beállítja az ikont és az elhelyezést.
 * @author Viktor
 *
 */
public class MenuElement extends JLabel {
	private static final long serialVersionUID = 5614960481039513103L;
	/**
	 * Konstruktor létrehozza a gombot az adott ikonnal.
	 * @param image az adott ikon
	 */
	public MenuElement(Image image) {
		setIcon(new ImageIcon(image));
		setAlignmentX(CENTER_ALIGNMENT);
	}

}
