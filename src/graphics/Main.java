package graphics;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import sokoban.*;

public class Main {

	public static void main(String[] args) {
		MainWindow mw = new MainWindow(1024,  768);
		
		ArrayList<Image> ImagePlayerIcons = new ArrayList<>();; 
		
		int SquareSize = 100;
		
		Square.SetSize(SquareSize);
		
		LoadIcons(SquareSize, ImagePlayerIcons);
		
		

		
		mw.Show();
	}


	private static void LoadIcons(int size, ArrayList<Image> players ) {
		Image img;
		
		img = (new ImageIcon("res/box.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Box.SetGraphic(img);
		img = (new ImageIcon("res/closedportal.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Hole.SetClosedGraphic(img);
		img = (new ImageIcon("res/portal.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Hole.SetOpenGraphic(img);
		img = (new ImageIcon("res/floor.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Field.SetGraphic(img);
		img = (new ImageIcon("res/goalSauce.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Goal.SetGraphic(img);
		img = (new ImageIcon("res/pgun.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Lever.SetGraphic(img);
		img = (new ImageIcon("res/wall.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Wall.SetGraphic(img);
		
		
		Image img2 = (new ImageIcon("res/oil.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT);	
		img = (new ImageIcon("res/honey.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		Square.SetLayer(img2, img);
		
		img = (new ImageIcon("res/rick.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		players.add(img);
		img = (new ImageIcon("res/morty.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 		
		players.add(img);
		img = (new ImageIcon("res/summer.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 
		players.add(img);
		img = (new ImageIcon("res/evil.png")).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT); 
		players.add(img);
	}
	
	

}