package graphics;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sokoban.Worker;

public class SetNamesWindow {
	private boolean ok;
	public SetNamesWindow(JFrame owner, ArrayList<Worker> players) {
		ok = false;
		
		JDialog dialog = new JDialog(owner);
		dialog.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		dialog.setResizable(false);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ok = true;
				dialog.dispose();
			}
		});
		
		dialog.add(new JLabel("Player 1 name (Rick):"));
		dialog.add(textField1);
		dialog.add(new JLabel("Player 2 name (Morty):"));
		dialog.add(textField2);
		dialog.add(okButton);
		
		
		dialog.pack();
		dialog.setVisible(true);
		
		if (!ok) {
			players.get(0).setName("Rick");
			players.get(1).setName("Morty");
		} else {
			players.get(0).setName(textField1.getText());
			players.get(1).setName(textField2.getText());
		}
	}
}
