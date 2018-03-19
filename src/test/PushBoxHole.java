package test;
import sokoban.*;

/**
 * ebben a tesztben a tesztben egy boxot rátolunk egy hole-ra
 * elvárt kimenet: a box rákerül az adott hole-ra, majd az set-eli
 */

public class PushBoxHole implements Test {
	
	Field f1, f2;
	Hole h1;
	Worker w1;
	Box b1;
	
	PushBoxHole (Boolean open) {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		h1 = new Hole("h1");
		if(open)
			h1.Toggle();
		
		
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
