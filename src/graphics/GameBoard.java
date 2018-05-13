package graphics;

import sokoban.*;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameBoard extends JPanel { 
	
	Map map;
	
	void SetMap (Map m) {
		this.map = m;
	}
	
	
	
	
	
	
	public void paintComponent(Graphics g) {
		
		int i,j;
		i = j = 0;
		for( ArrayList<Field> Rows :  map.GetFields()) {
			for(Field field : Rows) {				
				Square.Draw(g,field, i, j );
				i++;
			}		
			j++;
		}
		
		
		
		
	}
	
	
	

}
