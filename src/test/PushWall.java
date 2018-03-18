package test;

import sokoban.*;

public class PushWall implements Test {
	
	Field f1, f2;
	
	Worker w1;
	Wall wall;
	
	
	PushWall () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		
		
		
		
		w1 = new Worker("w1", f1);
		wall = new Wall("wall", f2);
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		

		
		f1.SetThing(w1);
		f2.SetThing(wall);
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
}
