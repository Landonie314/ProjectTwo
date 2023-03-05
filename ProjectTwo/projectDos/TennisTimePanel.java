package projectDos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TennisTimePanel extends JPanel{
	private int count;
	private JButton push;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Predictor predict;
	
	public TennisTimePanel() {
		predict = new Predictor("./projectDos/data2.txt");
		System.out.println(predict.getActivities());
		
		count = 0;
		push = new JButton ("Random!");
		push.setBounds(10, 11, 105, 23);
		push.addActionListener(new ButtonListener());
		setLayout(null);
		
		add (push);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(800, 500));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Windy?");
		chckbxNewCheckBox.setBounds(484, 324, 97, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Make your own Instance!");
		lblNewLabel.setBounds(298, 6, 200, 32);
		add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sunny");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(484, 194, 109, 32);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Rainy");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(484, 225, 109, 32);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Overcast");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(484, 255, 109, 32);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Tornado");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(484, 285, 109, 32);
		add(rdbtnNewRadioButton_3);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setBounds(454, 49, 200, 74);
		add(slider);
		
		//The only required element
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(474, 394, 194, 50);
		add(comboBox);
		
		//Allows me to scross the text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 211, 286, 232);
		add(scrollPane);
		
		//Text area that displays the list of activities
		JTextArea textArea = new JTextArea();
		textArea.setText(predict.toString());
		scrollPane.setViewportView(textArea);
	}
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event){
			count++;
			
		}
	}
}
