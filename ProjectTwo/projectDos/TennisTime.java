package projectDos;

import javax.swing.JFrame;

import projectDos.TennisTimePanel;

public class TennisTime {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TennisTimePanel panel = new TennisTimePanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}