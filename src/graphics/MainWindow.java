package graphics;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
/**
 * A főablak amiben megjelennek a a játék különböző állapotai(menü,játék).
 * @author Viktor
 *
 */
public class MainWindow {
	private JFrame frame;
	
	/**
	 * Visszaadja az ablakot.
	 * @return Az ablak
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * A jelenleg rajta található komponens ami jelen esetben a játék állapotát jelenti.
	 */
	private Component comp = null;
	
	/**
	 * Létrehozza az ablakot a megadott szélességel és magasságal.
	 * @param width megadott szélesség
	 * @param height megadott magasság
	 */
	public MainWindow(int width, int height) {
		frame = new JFrame("Killer Sokoban");
		frame.setResizable(false);
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Beállítja a komponenst(állapotát a játéknak) a megadott komponensre.
	 * @param comp a megadott komponens
	 */
	public void SetContent(Component comp) {
		if (this.comp != null)
			frame.remove(this.comp);
		
		frame.add(comp, BorderLayout.CENTER);
		this.comp = comp;
		frame.revalidate();
		frame.repaint();
		comp.requestFocus();
	}
	
	/**
	 * Láthatóvá teszi az ablakot.
	 */
	public void Show() {
		frame.setVisible(true);
	}
}
