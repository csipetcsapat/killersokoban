package sokoban;

public class Skeleton {
	public static final GameManager gm = new GameManager();
	public static final Logger log = new Logger();

	public static void main(String[] args) {
		Field f1 = new Field("f1");
		Field f2 = new Field("f2");
		Field f3 = new Field("f3");
		
		f1.SetNeighbour(Directions.RIGHT, f2);
		f2.SetNeighbour(Directions.RIGHT, f3);
		
		Worker w = new Worker("w", f1);
		Box b = new Box("b", f2);
		f2.SetThing(b);
		w.Move(Directions.RIGHT);
		
		log.printCallStack();
	}

}
