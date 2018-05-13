package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import sokoban.Field;
import sokoban.Thing;

public class Square extends JPanel {
	private static final long serialVersionUID = 2718721473398628642L;
	private static Image oilImage;
	private static Image honeyImage;
	
	Field field;
	
	public Square(Field f) {
		this.field = f;
	}
	
	public static void setRoughnessImages(Image oilImage, Image honeyImage) {
		Square.oilImage = oilImage;
		Square.honeyImage = honeyImage;
	}

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
