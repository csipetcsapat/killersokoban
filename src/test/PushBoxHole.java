package test;
import sokoban.*;

public class PushBoxHole implements Test {
	
	Field f1, f2;
	Hole h1;
	Worker w1;
	Box b1;
	
	PushBoxHole () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		h1 = new Hole("h1");
		
		
		
		w1 = new Worker("w1", f1);
		b1 = new Box("b1", f2);
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, h1);

		
		f1.SetThing(w1);
		f2.SetThing(b1);
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	

}
