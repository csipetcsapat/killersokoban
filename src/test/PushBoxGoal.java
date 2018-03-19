package test;
import sokoban.*;

/**
 * ebben a tesztben egy box-ot rátulunk egy goal-ra
 * elvárt kimenet: a box rákerül a goal-ra, majd az set-eli
 */

public class PushBoxGoal implements Test {
	
	Field f1, f2;
	Goal g1;
	Worker w1;
	Box b1;
	
	PushBoxGoal () {
		
		f1 = new Field("f1");
		f2 = new Field("f2");
		g1 = new Goal("g1");
				

		w1 = new Worker("w1", f1);
		b1 = new Box("b1", f2);
		
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, g1);

		
		f1.SetThing(w1);
		f2.SetThing(b1);
		
		Skeleton.gm.setCurrentPlayer(w1);	
	}
	
	public void Run() {
		w1.Move(Directions.RIGHT);
	}
	

}
