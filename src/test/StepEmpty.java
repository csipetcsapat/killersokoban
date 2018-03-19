package test;

import sokoban.*;

/**
 * ebben a tesztben egy player egy üres fieldre lép
 * elvárt kimenet: a player az adott fieldre átkerül
 */

public class StepEmpty implements Test {
	
	Field f1, f2;
	
	Worker w1;
	
	
	StepEmpty () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		
		
		
		
		w1 = new Worker("w1", f1);
		
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		

		
		f1.SetThing(w1);
		
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}

}
