package test;

import sokoban.*;

/**
 * ebben a tesztben egy player egy hole-ra lép
 * elvárt kimenet: a player rákerül az adott hole-ra, majd az set-eli
 */

public class StepHole implements Test {
	
	Field f1;
	Hole h1;
	Worker w1;
	
	
	StepHole (Boolean open) {
		
		f1 = new Field("f1");
		h1 = new Hole("h1");
		if(open)
		h1.Toggle();
		
		
		w1 = new Worker("w1", f1);
		
		
		
		f1.SetNeighbour(Directions.RIGHT, h1);
		

		
		f1.SetThing(w1);
		
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}

}
