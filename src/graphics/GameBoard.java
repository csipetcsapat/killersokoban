package graphics;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import sokoban.Field;
import sokoban.Map;

public class GameBoard extends JPanel {
	static final long serialVersionUID = -1524486995037653542L;
	private Map map;

	public GameBoard(Map map) {
		this.map = map;
	}
	
	public void Update() {
		map.PrintMap();
		ArrayList<ArrayList<Field>> fields = map.GetFields();
		setLayout(new GridLayout(fields.size(), fields.get(0).size()));
		
		for (ArrayList<Field> row : fields) {
			for (Field f : row)
				add(new Square(f));
		}
	}
}
