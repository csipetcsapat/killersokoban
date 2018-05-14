package graphics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 * A menüt megvalósító JPanel betölt egy háttéret.
 * @author Viktor
 *
 */
public class Menu extends JPanel {
	private static final long serialVersionUID = 5075331387152684938L;
	private Image backgroundImage;

	/**
	 * Konstruktor létrehozza a JPanel a háttérrel.
	 */
	public Menu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		try {
			backgroundImage = ImageIO.read(new File("res/menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(Box.createRigidArea(new Dimension(0, 390)));
	}
	
	/**
	 * Komponenst add hozzá az ablakhoz.
	 */
	@Override
	public Component add(Component comp) {
		super.add(Box.createRigidArea(new Dimension(0, 20)));
		return super.add(comp);
	}
	
	/**
	 * Kirajzzoló függvény.
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(backgroundImage, 0, 0, this);
	}
}
