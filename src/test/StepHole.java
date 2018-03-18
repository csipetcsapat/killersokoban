package test;

import sokoban.*;

public class StepHole implements Test {
	
	Field f1, h1;	
	Worker w1;
	
	
	StepHole () {
		
		f1 = new Field("f1");
		h1 = new Hole("h1");
		
		
		
		
		w1 = new Worker("w1", f1);
		
		
		
		f1.SetNeighbour(Directions.RIGHT, h1);
		

		
		f1.SetThing(w1);
		
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}

}
