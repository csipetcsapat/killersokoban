package graphics;
import java.awt.Image;
import java.awt.Graphics;


import sokoban.*;

public class Square {
	
	static int size = 100;
	int dimX;
	int dimY;
	
	
	static void SetSize(int Size) {
		size = Size;
	}
	
	Square(int x, int y) {
		dimX = x;
		dimY = y;
	}
	
	void Set(Graphics g, Field field ) {
		
		Image bg, layer, fg;
		
		bg = (Image)field.GetGraphic();
		g.drawImage(bg, dimX * size, dimY*size, size, size, null);
			
		
		
		if (field.GetRoughness() > 6) {
			//layer = honey
			g.drawImage(layer, dimX * size, dimY*size, size, size, null);
			
		} else if(field.GetRoughness() < 4 ) {
			//layer = oil
			g.drawImage(layer, dimX * size, dimY*size, size, size, null);
		} 
		
		Thing thing;
		if ((thing = field.GetThing()) != null) {
			fg = (Image)thing.GetGraphic();
			g.drawImage(fg, dimX * size, dimY*size, size, size, null);		
		} 
		
	

		

		
		
	}
	
	
}
