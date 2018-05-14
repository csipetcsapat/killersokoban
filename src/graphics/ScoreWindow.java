package graphics;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sokoban.Worker;
/**
 * Az eredény kiíró ablak. Ez az ablak felelős azért ,hogy kiírja a végeredményt ha vége a játéknak.
 * @author Viktor
 *
 */
public class ScoreWindow {
	/**
	 * Konstruktor az ablak létrhezosáa az eredményekkel a megadott játékosok segítségével. Az ok gombra kattintással eltűnik.
	 * @param players a megadott játékosok
	 */
	public ScoreWindow(ArrayList<Worker> players) {
		JFrame frame = new JFrame("Scores");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(new JLabel(" - Jeez, Rick! The game is over! What do we do now?\n"));
		frame.add(new JLabel(" - Player another round, Morty! That's what we do!"));
		
		for (Worker player : players)
			frame.add(new JLabel(player.GetName() + ": " + player.GetScore()));
		
		Button okButton = new Button("Ok");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.add(okButton);
		frame.pack();
		frame.setVisible(true);
	}
}
