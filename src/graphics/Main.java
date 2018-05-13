package graphics;

import java.awt.Image;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import sokoban.*;

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
		
		MenuElement newGameButtonElement = new MenuElement(loadImage("res/startgame.png"));
		MenuElement exitButtonElement = new MenuElement(loadImage("res/exitgame.png"));
		
		exitButtonElement.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		
		newGameButtonElement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mw.SetContent(startGame());
			}
		});
		
		menu.add(newGameButtonElement);
		menu.add(exitButtonElement);
		
		return menu;
	}

	private static GameBoard startGame() {
		Map map = new Map();
		GameManager gm = new GameManager();
		map.LoadMap(2, "test.txt", gm);
		ArrayList<Image> ImagePlayerIcons = new ArrayList<>();
		int mapsize = map.GetFields().get(0).size();
		int SquareSize = 1024/mapsize + 1;
		
		int maph = map.GetFields().size();
		int SquareSize2 = 768/maph + 1;
		
		LoadIcons(SquareSize, SquareSize2, ImagePlayerIcons);
		GameBoard gb = new GameBoard(map);
		gb.Update();
		
		return gb;
		
	}
	public static void main(String[] args) {


		mw = new MainWindow(1024,  768);
		
		mw.SetContent(createMenu());

		mw.Show();
	}


	private static void LoadIcons(int size,int size2, ArrayList<Image> players ) {
		Image img;
		
		img = (new ImageIcon("res/box.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Box.SetGraphic(img);
		img = (new ImageIcon("res/closedportal.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Hole.SetClosedGraphic(img);
		img = (new ImageIcon("res/portal.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Hole.SetOpenGraphic(img);
		img = (new ImageIcon("res/floor.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Field.SetGraphic(img);
		img = (new ImageIcon("res/goalSauce.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Goal.SetGraphic(img);
		img = (new ImageIcon("res/pgun.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Lever.SetGraphic(img);
		img = (new ImageIcon("res/wall.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		Wall.SetGraphic(img);
		
		
		Image img2 = (new ImageIcon("res/oil.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT);
		img = (new ImageIcon("res/honey.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		
		Square.setRoughnessImages(img2, img);
		
		img = (new ImageIcon("res/rick.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		players.add(img);
		img = (new ImageIcon("res/morty.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 		
		players.add(img);
		img = (new ImageIcon("res/summer.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 
		players.add(img);
		img = (new ImageIcon("res/evil.png")).getImage().getScaledInstance(size, size2, Image.SCALE_DEFAULT); 
		players.add(img);
	}
	
	

}