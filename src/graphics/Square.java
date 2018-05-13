package graphics;
import java.awt.Image;
import java.awt.Graphics;


import sokoban.*;

 public class Square { 
	
	
	
	static Image oil, honey;
	
	
	static int size = 100;
	
	
	
	static void SetSize(int Size) {
		size = Size;
	}
	
	static void SetLayer(Image Oil, Image Honey) {
		oil = Oil;
		honey = Honey;
	}
	
	
	
	static void Draw(Graphics g, Field field, int dimX, int dimY ) {
		
		g.drawImage((Image)field.GetGraphic(), dimX * size, dimY*size, size, size, null);
			
		
		
		if (field.GetRoughness() > 6) {
			
			g.drawImage(honey, dimX * size, dimY*size, size, size, null);
			
		} else if(field.GetRoughness() < 4 ) {
			//layer = oil
			g.drawImage(oil, dimX * size, dimY*size, size, size, null);
		} 
		
		Thing thing;
		if ((thing = field.GetThing()) != null) {
			
			g.drawImage((Image)thing.GetGraphic(), dimX * size, dimY*size, size, size, null);		
		} 
		
	

		

		
		
	}
	
	
}
