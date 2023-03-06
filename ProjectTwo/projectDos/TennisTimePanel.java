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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TennisTimePanel extends JPanel{
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Predictor predict;
	
	
	public TennisTimePanel() {
		predict = new Predictor("./projectDos/data2.txt");
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(800, 500));
		
		
		//Just some labels //Wont change
		//Humidity
		JLabel humidityLbl = new JLabel("Humidity:");
		humidityLbl.setBounds(432, 120, 97, 32);
		add(humidityLbl);
		//Temp
		JLabel temperLbl = new JLabel("Temperature:");
		temperLbl.setBounds(432, 200, 97, 32);
		add(temperLbl);
		//Activity
		JLabel activityLbl = new JLabel("Activity:");
		activityLbl.setBounds(451, 290, 97, 32);
		add(activityLbl);
		
		//Labels the creation section
		JLabel mainLbl = new JLabel("Make your own Instance!");
		mainLbl.setBounds(562, 31, 200, 32);
		add(mainLbl);
		
		//Labels the instance finder
		JLabel lblFindAnInstance = new JLabel("Find an Instance!");
		lblFindAnInstance.setBounds(59, 11, 200, 32);
		add(lblFindAnInstance);
		
		//Label for finder //Will change
		JLabel intstanceLbl = new JLabel(predict.getInstance(0).toString());
		intstanceLbl.setBounds(40, 129, 235, 50);
		add(intstanceLbl);
		
		//Label for instance number
		JLabel instNumLbl = new JLabel("Instance #: 1");
		instNumLbl.setBounds(265, 72, 97, 32);
		add(instNumLbl);
				
		
			//Checkbox
		//Allows for yes/no windy
		JCheckBox windyBox = new JCheckBox("Windy?");
		windyBox.setBounds(665, 416, 97, 23);
		add(windyBox);
		
			//Radiobutton group for outlook selection
		//Sunny
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sunny");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(665, 281, 109, 32);
		add(rdbtnNewRadioButton);
		//Rainy
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Rainy");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(665, 310, 109, 32);
		add(rdbtnNewRadioButton_1);
		//Overcast
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Overcast");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(665, 340, 109, 32);
		add(rdbtnNewRadioButton_2);
		//Tornado
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Tornado");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(665, 370, 109, 32);
		add(rdbtnNewRadioButton_3);
		
			//ComboBox
		//The only required element
		JComboBox comboBox = new JComboBox();
		String [] myActivities = predict.getActivities();
		comboBox.setModel(new DefaultComboBoxModel(myActivities));
		comboBox.setBounds(409, 331, 194, 50);
		add(comboBox);
		
		//Allows me to scross the text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 192, 324, 269);
		add(scrollPane);
		
		//Text area that displays the list of activities
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(predict.toString());
		scrollPane.setViewportView(textArea);
		
			//Sliders
		//Slider for Temperature
		JSlider temper = new JSlider();
		temper.setValue(0);
		temper.setPaintTicks(true);
		temper.setMinorTickSpacing(10);
		temper.setBounds(539, 192, 236, 60);
		add(temper);
		
		//Allows you to slide for an instance
		JSlider finder = new JSlider();
		finder.setMinorTickSpacing(1);
		finder.setMajorTickSpacing(5);
		finder.setPaintLabels(true);
		finder.setValue(0);
		finder.setPaintTicks(true);
		finder.setBounds(20, 58, 235, 60);
		//sets max to size of predictions
		finder.setMaximum(predict.getSize()-1);
		//Adjusts the value of the instance to the value of slider
		finder.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Gets instance at value of slider
				intstanceLbl.setText(predict.getInstance(finder.getValue()).toString());
				//Label displays what number instance it is.
				instNumLbl.setText("Instance #: " + (finder.getValue()+1));
			}
		});
		add(finder);
		
		
		
		//Slider for Humidity
		JSlider humidity = new JSlider();
		humidity.setValue(0);
		humidity.setPaintTicks(true);
		humidity.setMinorTickSpacing(10);
		humidity.setBounds(539, 104, 235, 60);
		add(humidity);
				
		
			//Buttons
		//Create button
		JButton btnCreate = new JButton("Create!");
		btnCreate.setBounds(511, 436, 105, 23);
		add(btnCreate);
		//listener
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isWindy = false;
				if(windyBox.isSelected()) {
					isWindy = true;
				}
				Instance toAdd = new Instance();
			}
		});
		
		//Deletes
		JButton btnDelete = new JButton("Delete!");
		btnDelete.setBounds(191, 16, 105, 23);
		add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
				
		//Toggles on random values for a new instance
		JToggleButton tglbtnRandom = new JToggleButton("Randomizer!");
		tglbtnRandom.setBounds(365, 436, 121, 23);
		add(tglbtnRandom);
		
		
		tglbtnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}
