package graphics;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class MainWindow {
	private JFrame frame;
	private Component comp = null;
	
	public MainWindow(int width, int height) {
		frame = new JFrame("Killer Sokoban");
		frame.setSize(width, height);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void SetContent(Component comp) {
		if (this.comp != null)
			frame.remove(this.comp);
		
		frame.add(comp, BorderLayout.CENTER);
		this.comp = comp;
		frame.revalidate();
		frame.repaint();
		comp.requestFocus();
	}
	
	public void Show() {
		frame.setVisible(true);
	}
}
