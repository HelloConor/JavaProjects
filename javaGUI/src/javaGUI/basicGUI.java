package javaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class basicGUI implements ActionListener {	
	private int count = 0;
	private JLabel label = new JLabel("Number of clicks: 0");
	private JFrame frame = new JFrame();
	
	public basicGUI() {
		
		// This is the clickable button function
		JButton button = new JButton("Click me");
		button.addActionListener(this);
		
		// this is the panel with button and text
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		
		// add panel to frame
		frame.add(panel, BorderLayout.CENTER);
		// what happens when user closes frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add title to the window
		frame.setTitle("Our GUI");
		//window to match certain size
		frame.pack();
		// window is visible
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// creates the GUI Frame now that the constructor above is written
		new basicGUI();
	}	
	// process the button presses
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
		
		
	}
				

}


