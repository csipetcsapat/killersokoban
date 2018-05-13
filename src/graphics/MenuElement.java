package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuElement extends JLabel {
	private static final long serialVersionUID = 5614960481039513103L;

	public MenuElement(Image image) {
		setIcon(new ImageIcon(image));
		setAlignmentX(CENTER_ALIGNMENT);
	}

}
