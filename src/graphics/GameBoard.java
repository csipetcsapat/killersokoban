package graphics;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import sokoban.Directions;
import sokoban.Field;
import sokoban.GameManager;
import sokoban.Map;

public class GameBoard extends JPanel {
	static final long serialVersionUID = -1524486995037653542L;
	private Map map;

	public GameBoard(Map map, GameManager gm) {
		this.map = map;
		setFocusable(true);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W)
					gm.MovePlayer(0, Directions.UP);
				else if (e.getKeyCode() == KeyEvent.VK_D)
					gm.MovePlayer(0, Directions.RIGHT);
				else if (e.getKeyCode() == KeyEvent.VK_A)
					gm.MovePlayer(0, Directions.LEFT);
				else if (e.getKeyCode() == KeyEvent.VK_S)
					gm.MovePlayer(0, Directions.DOWN);
				else if (e.getKeyCode() == KeyEvent.VK_Q)
					gm.GetPlayers().get(0).ReleaseHoney();
				else if (e.getKeyCode() == KeyEvent.VK_E)
					gm.GetPlayers().get(0).ReleaseOil();
				else if (e.getKeyCode() == KeyEvent.VK_UP)
					gm.MovePlayer(1, Directions.UP);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					gm.MovePlayer(1, Directions.RIGHT);
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					gm.MovePlayer(1, Directions.LEFT);
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					gm.MovePlayer(1, Directions.DOWN);
				else if (e.getKeyCode() == KeyEvent.VK_SHIFT)
					gm.GetPlayers().get(1).ReleaseHoney();
				else if (e.getKeyCode() == KeyEvent.VK_CONTROL)
					gm.GetPlayers().get(1).ReleaseOil();
				
				if (gm.CheckEndgame())
					System.out.println("over");
				Update();
			}
		});
	}
	
	public void Update() {
		repaint();
		//map.PrintMap();
		ArrayList<ArrayList<Field>> fields = map.GetFields();
		setLayout(new GridLayout(fields.size(), fields.get(0).size()));
		
		for (ArrayList<Field> row : fields) {
			for (Field f : row)
				add(new Square(f));
		}
	}
}
