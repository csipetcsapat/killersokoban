package graphics;
import java.awt.Image;
import java.awt.Graphics;


import sokoban.*;

public class Square {
	
	static Image oil, honey;
	Image bg, layer, fg;
	
	static int size = 100;
	int dimX;
	int dimY;
	
	
	static void SetSize(int Size) {
		size = Size;
	}
	
	static void SetLayer(Image Oil, Image Honey) {
		oil = Oil;
		honey = Honey;
	}
	
	Square(int x, int y) {
		dimX = x;
		dimY = y;
	}
	
	void Set(Graphics g, Field field ) {
		
		
		
		bg = (Image)field.GetGraphic();
		g.drawImage(bg, dimX * size, dimY*size, size, size, null);
			
		
		
		if (field.GetRoughness() > 6) {
			
			g.drawImage(honey, dimX * size, dimY*size, size, size, null);
			
		} else if(field.GetRoughness() < 4 ) {
			//layer = oil
			g.drawImage(oil, dimX * size, dimY*size, size, size, null);
		} 
		
		Thing thing;
		if ((thing = field.GetThing()) != null) {
			fg = (Image)thing.GetGraphic();
			g.drawImage(fg, dimX * size, dimY*size, size, size, null);		
		} 
		
	

		

		
		
	}
	
	
}
