import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

// a frame with a button panel
class ButtonFrame extends JFrame {
	public ButtonFrame() {
		
		setTitle("ButtonTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// create the buttons
		JButton yellowButton = new JButton("Yellow");
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		
		buttonPanel = new JPanel();
		
		// add buttons to the panel
		buttonPanel.add(yellowButton);
		buttonPanel.add(redButton);
		buttonPanel.add(blueButton);
		
		// add panel to frame
		add(buttonPanel);
		
		// create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction redAction = new ColorAction(Color.RED);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		
		// assocuiate actions with buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
				
	}
	
	// add action listner that sets the panels background colour
	private class ColorAction implements ActionListener {
		public ColorAction(Color c) {
			
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event) {
			
			buttonPanel.setBackground(backgroundColor);
		}
		
		private Color backgroundColor;
	}
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
}