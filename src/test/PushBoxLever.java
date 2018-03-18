package test;
import sokoban.*;

public class PushBoxLever implements Test {
	
	Field f1, f2;
	Lever l1;
	Worker w1;
	Box b1;
	Hole h1;
	
	PushBoxLever (Boolean open) {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		l1 = new Lever("l1");
		h1 = new Hole("h1");
		
		
		
		w1 = new Worker("w1", f1);
		b1 = new Box("b1", f2);
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, l1);

		
		f1.SetThing(w1);
		f2.SetThing(b1);
		l1.SetHole(h1);
		if(!open)
		h1.SetThing(b1); /// lever csak akkor mukodik ha van rajta cucc
		
			
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	
}
