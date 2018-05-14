package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import sokoban.Field;
import sokoban.Thing;

/**
 * Egy mezőt reprezentáló JPanel ezekből épül fel a GameBoard. 
 * @author Viktor
 *
 */
public class Square extends JPanel {
	private static final long serialVersionUID = 2718721473398628642L;
	/**
	 * Az olajos mezőnek a grafikus objektuma.
	 */
	private static Image oilImage;
	/**
	 * Az mézes mezőnek a grafikus objektuma.
	 */
	private static Image honeyImage;
	
	Field field;
	/**
	 * Konstruktor lérehozza az adott mezőt reprezentáló mezőt.
	 * @param f adott mező
	 */
	public Square(Field f) {
		this.field = f;
	}
	
	/**
	 * Beállítja az olajos és mézes mező grafikus objektumait.
	 * @param oilImage az olajos mező grafikus objektuma
	 * @param honeyImage a mézes mező grafikus objektuma
	 */
	public static void setRoughnessImages(Image oilImage, Image honeyImage) {
		Square.oilImage = oilImage;
		Square.honeyImage = honeyImage;
	}
	
	/**
	 * Kirajzoló függvény
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage((Image)field.GetGraphic(), 0, 0, this);
		
		if (field.GetRoughness() < 4)
			g.drawImage(oilImage, 0, 0, this);
		else if (field.GetRoughness() > 6)
			g.drawImage(honeyImage, 0, 0, this);
		
		Thing t;
		if ((t = field.GetThing()) != null)
			g.drawImage((Image)t.GetGraphic(), 0, 0, this);
	}
	
	
}
