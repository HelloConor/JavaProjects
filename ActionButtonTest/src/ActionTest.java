import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class ActionTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				ActionFrame frame = new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ActionFrame extends JFrame {
	public ActionFrame() {
		
		setTitle("ActionTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		
		// Define actions of the buttons
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("Images/Yellow_icon.png"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("Images/blue circle.png"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("Images/red circle.png"), Color.RED);
		
		// add buttons for these actions
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		// add panel to frame
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		
		// associate the names with the actions
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
					
	}
	
	public class ColorAction extends AbstractAction {
		public ColorAction(String name, Icon icon, Color c) {
			
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}
		
		public void actionPerformed(ActionEvent event) {
			
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
		
		
	}
	
	private JPanel buttonPanel;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
}