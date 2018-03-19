package test;

import sokoban.*;

/**
 * ebben a tesztben egy player tol közvetlenül egy player
 * elvárt kimenet: minden marad a helyén
 */

public class PushPlayer implements Test {
	
	Field f1, f2;
	
	Worker w1,w2;
	
	
	PushPlayer () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		
		
		
		
		w1 = new Worker("w1", f1);
		w2 = new Worker("w2", f2);
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		

		
		f1.SetThing(w1);
		f2.SetThing(w2);
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	
}
