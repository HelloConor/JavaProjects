import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				ComboBoxFrame frame = new ComboBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ComboBoxFrame extends JFrame {
	public ComboBoxFrame() {
		
		setTitle("ComboBoxTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// add sample text to frame
		label = new JLabel("The quick brown box jumps over the lazy dog");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		// make combo box and add faces names
		faceCombo = new JComboBox();
		faceCombo.setEditable(true);
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		// the combo box listener changes the label font to the selected face name
		
		faceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				label.setFont(new Font((String) faceCombo.getSelectedItem(), Font.PLAIN, DEFAULT_SIZE));
							
			}
		});
		
		// makes a panel and adds the combobox to that panel, added to south position
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel, BorderLayout.SOUTH);
		
	}
	
	public static int DEFAULT_WIDTH = 300;
	public static int DEFAULT_HEIGHT = 300;
	
	private JLabel label;
	private JComboBox faceCombo;
	private static int DEFAULT_SIZE = 12;
}