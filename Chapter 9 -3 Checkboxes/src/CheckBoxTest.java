import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				CheckBoxFrame frame = new CheckBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class CheckBoxFrame extends JFrame {
	public CheckBoxFrame() {
		
		setTitle("Checkboxes");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// add sample label text
		label = new JLabel("The quick brown fox jumped over the lazy dog");
		label.setFont(new Font("Serif", Font.PLAIN, FONTSIZE));
		add(label, BorderLayout.CENTER);
		
		// this listener sets the font of the label to the check box state
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				// this changes the Font from plain to either Italic or Bold
				int mode = 0;
				if (bold.isSelected()) mode += Font.BOLD;
				if (italic.isSelected()) mode += Font.ITALIC;
				label.setFont(new Font("Serif", mode, FONTSIZE));
			}
		};
		
		// add the check boxes
		
		JPanel buttonPanel = new JPanel();
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		buttonPanel.add(bold);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	
	private  static final int FONTSIZE = 12;
}
