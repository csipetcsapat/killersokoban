package graphics;

import javax.swing.JFrame;

public class MainWindow {
	private JFrame frame;
	
	public MainWindow(int width, int height) {
		frame = new JFrame("Killer Sokoban");
		frame.setSize(width, height);
		frame.setLayout(null);
	}
	
	public void Show() {
		frame.setVisible(true);
	}
}
