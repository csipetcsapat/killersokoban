package graphics;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	private static MainWindow mw;
	
	private static Image loadImage(String path) {
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	private static Menu createMenu() {
		Menu menu = new Menu();
		
		MenuElement newGameButtonElement = new MenuElement(loadImage("res/box.png"));
		MenuElement exitButtonElement = new MenuElement(loadImage("res/oil.png"));
		
		exitButtonElement.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		
		menu.add(newGameButtonElement);
		menu.add(exitButtonElement);
		
		return menu;
	}

	public static void main(String[] args) {
		mw = new MainWindow(1024,  768);
		
		mw.SetContent(createMenu());
		mw.Show();
	}

}
