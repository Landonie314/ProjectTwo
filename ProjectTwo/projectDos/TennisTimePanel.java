//Landon Jones
//03/06/2023
//Java Project 2
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
import javax.swing.ButtonModel;
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
	
	//Implemented guiItems: Button, radioButton, textArea, label, comboBox, checkBox, toggleButton, Slider (8 unique things)
	public TennisTimePanel() {
		predict = new Predictor("./projectDos/data2.txt");
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(800, 500));
		
		
		//Just some labels //Wont change
		//Humidity
		JLabel humidityLbl = new JLabel("Humidity: 0");
		humidityLbl.setBounds(432, 120, 97, 32);
		add(humidityLbl);
		//Temp
		JLabel temperLbl = new JLabel("Temperature: 0");
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
		JRadioButton sunRadio = new JRadioButton("Sunny");
		sunRadio.setSelected(true);
		buttonGroup_1.add(sunRadio);
		sunRadio.setBounds(665, 281, 109, 32);
		add(sunRadio);
		//Rainy
		JRadioButton rainRadio = new JRadioButton("Rainy");
		buttonGroup_1.add(rainRadio);
		rainRadio.setBounds(665, 310, 109, 32);
		add(rainRadio);
		//Overcast
		JRadioButton overRadio = new JRadioButton("Overcast");
		buttonGroup_1.add(overRadio);
		overRadio.setBounds(665, 340, 109, 32);
		add(overRadio);
		//Tornado
		JRadioButton tornRadio = new JRadioButton("Tornado");
		buttonGroup_1.add(tornRadio);
		tornRadio.setBounds(665, 370, 109, 32);
		add(tornRadio);
		
			//ComboBox
		//The only required element
		JComboBox comboBox = new JComboBox();
		String [] myActivities = predict.getActivities();
		comboBox.setModel(new DefaultComboBoxModel(myActivities));
		comboBox.setBounds(409, 331, 194, 50);
		add(comboBox);
		
		//Allows me to scroll the text area
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
		temper.setMinorTickSpacing(1);
		temper.setMajorTickSpacing(10);
		temper.setPaintLabels(true);
		temper.setValue(0);
		temper.setPaintTicks(true);
		temper.setBounds(539, 192, 236, 60);
		//Slider listener
		temper.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				temperLbl.setText("Temperature: " + temper.getValue());
			}
		});
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
		humidity.setMinorTickSpacing(1);
		humidity.setPaintLabels(true);
		humidity.setMajorTickSpacing(10);
		humidity.setValue(0);
		humidity.setPaintTicks(true);
		humidity.setBounds(539, 104, 235, 60);
		//Slider listener
		humidity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				humidityLbl.setText("Humidity: " + humidity.getValue());
			}
		});
		add(humidity);
				
		
			//Buttons
		//Create button
		JButton btnCreate = new JButton("Create!");
		btnCreate.setBounds(511, 436, 105, 23);
		add(btnCreate);
		//listener
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Starting variables
				boolean aIsWindy = false;
				//gets humidity
				int humid = humidity.getValue();
				//gets temperature
				int temp = temper.getValue();
				//Conditional based on user selection
				if(windyBox.isSelected()) {
					aIsWindy = true;
				}
				//Returns activity
				String aAct = comboBox.getSelectedItem().toString();
				//returns outlook
				String aOut = "";
				if(sunRadio.isSelected()) {
					aOut = "sunny";
				}
				if(rainRadio.isSelected()) {
					aOut = "rainy";
				}
				if(overRadio.isSelected()) {
					aOut = "overcast";
				}
				if(tornRadio.isSelected()) {
					aOut = "tornado";
				}
				
				//Adds the selected parameters to an instance and then adds it to the predictor.
				Instance toAdd = new Instance(aOut, temp, humid, aIsWindy, aAct);
				predict.addInstance(toAdd);
				
			}
		});
		
		//Deletes
		JButton btnDelete = new JButton("Delete!");
		btnDelete.setBounds(191, 16, 105, 23);
		add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				predict.removeInstance(finder.getValue());
			}
		});
				
		//Toggles on random values for a new instance
		JToggleButton tglbtnRandom = new JToggleButton("Randomizer!");
		tglbtnRandom.setBounds(365, 436, 121, 23);
		add(tglbtnRandom);
		
		//Listener for random toggle
		tglbtnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Our random generation
				Instance yep = new Instance();
				predict.initializeRandom();
				yep = predict.randomInstance();
				String out = yep.getOutlook();
				//Toggled on
				if(tglbtnRandom.isSelected()) {
				//Assigning random values
				humidity.setValue(yep.getHumidity());
				temper.setValue(yep.getTemperature());
				comboBox.setSelectedItem(yep.getPlay());
				//selection for button group
					if(out.equals("sunny")) {
						sunRadio.setSelected(true);
					}
					if(out.equals("rainy")) {
						rainRadio.setSelected(true);
					}
					if(out.equals("overcast")) {
						overRadio.setSelected(true);
					}
					if(out.equals("tornado")) {
						tornRadio.setSelected(true);
					}
				//Windy?
					if(yep.getWindy() == true) {
						windyBox.setSelected(true);
					}
			}
				//Toggled off
				else {
					//Sets to default values
					humidity.setValue(0);
					temper.setValue(0);
					yep.setPlay("tennis");
					comboBox.setSelectedItem(yep.getPlay());
					sunRadio.setSelected(true);
					windyBox.setSelected(false);
				}
				
			}
		});
		
	}
	//writes to the file
	public void doClose() {
		predict.writeFile("./projectDos/data2.txt");
	}
}
