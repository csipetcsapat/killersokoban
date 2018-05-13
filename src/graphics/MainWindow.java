package graphics;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {
	private JFrame frame;
	
	public MainWindow(int width, int height) {
		frame = new JFrame("Killer Sokoban");
		frame.setSize(width, height);
		frame.setLayout(null);
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/menu.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Show() {
		frame.setVisible(true);
	}
}
