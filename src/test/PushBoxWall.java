package test;
import sokoban.*;

public class PushBoxWall implements Test {
	
	Field f1, f2, f3;
	Worker w1;
	Box b1;
	Wall wall;
	
	PushBoxWall () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		f3 = new Field("f3");
		
		
		
		w1 = new Worker("w1", f1);
		b1 = new Box("b1", f2);
		wall = new Wall("wall", f3);
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, f3);

		
		f1.SetThing(w1);
		f2.SetThing(b1);
		f3.SetThing(wall);
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	
}
