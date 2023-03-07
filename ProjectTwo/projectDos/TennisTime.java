//Landon Jones
//03/06/2023
//Java Project 2
package projectDos;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import projectDos.TennisTimePanel;

public class TennisTime {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TennisTimePanel panel = new TennisTimePanel();
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		//Listens for window to close then writes to the file
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}
		});

	}
}