package test;

import sokoban.*;

public class PushBoxPlayerPlayer  implements Test {
	
	Field f1, f2, f3, f4;
	Worker w1,w2,w3;
	Box b1;
	
	
	PushBoxPlayerPlayer() {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		f3 = new Field("f3");
		f4 = new Field("f4");
		
		
		w1 = new Worker("w1", f1);
		b1 = new Box("b1", f2);
		w2 = new Worker("w2", f3);
		w3 = new Worker("w3", f4);
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, f3);
		f3.SetNeighbour(Directions.RIGHT, f4);
		
		f1.SetThing(w1);
		f2.SetThing(b1);
		f3.SetThing(w2);
		f4.SetThing(w3);
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	
}
