import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				ToolBarFrame frame = new ToolBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

class ToolBarFrame extends JFrame {
	public ToolBarFrame() {
		
		setTitle("Tool Bar Test");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// add panel for colour change
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		// set up actions
		
		Action blueAction = new ColorAction("Blue", Color.BLUE);
		Action yellowAction = new ColorAction("Yellow", Color.YELLOW);
		Action redAction = new ColorAction("Red", Color.RED);
		
		
		// this action closes down the program 
		Action exitAction = new AbstractAction("Exit") {
			
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		
		// populate tool bar
		
		JToolBar bar = new JToolBar();
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar, BorderLayout.NORTH);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
	private JPanel panel;

	// this color action sets the background of the panel when the action from the toolbar is clicked
	class ColorAction extends AbstractAction {
	
		public ColorAction(String name, Color c) {
		
			putValue(Action.NAME, name);
			putValue("Color", c);
			putValue(Action.SHORT_DESCRIPTION, name + " background");
		
		
		
		}
	
		public void actionPerformed(ActionEvent event) {
		
			Color c = (Color) getValue("Color");
			panel.setBackground(c);
		}

	}
}


