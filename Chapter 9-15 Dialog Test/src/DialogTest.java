import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				DialogFrame frame = new DialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class DialogFrame extends JFrame {
	
	public DialogFrame() {
		
		setTitle("DialogTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// construct a file menu
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		// add About and Exit menu Items
		
		// The About item shows the about dialog
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				if (dialog == null) // first time
					dialog = new AboutDialog(DialogFrame.this);
					dialog.setVisible(true); // pop up dialog
				
			}
		});
		fileMenu.add(aboutItem);
		
		// The Exit item exits the program
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenuItem helpItem = new JMenuItem("Help");
		aboutItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				if (dialog1 == null) // first time
					dialog1 = new HelpDialog(DialogFrame.this);
					dialog1.setVisible(true); // pop up dialog
				
			}
		});
		fileMenu.add(helpItem);
		
		
		
	}
		
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	private AboutDialog dialog;
	private HelpDialog dialog1;
}

class AboutDialog extends JDialog {
	
	public AboutDialog(JFrame owner) {
		
		super(owner, "About DialogTest", true);
		
		// add HTML label to center
		
		add(new JLabel("<html><h1><i>Hello Conor<i><h1><hr>This is a test on Dialog Box</html>"), BorderLayout.CENTER);
		
		// OK button closes the Dialog
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		
		// add button to southern border
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		
		setSize(250, 150);
		
		
	}
}

class HelpDialog extends JDialog {
	
	public HelpDialog(JFrame owner) {
		
		super(owner, "Help DialogTest", true);
		
		// add HTML label to center
		
		add(new JLabel("<html><h1><i>Hello Conor<i><h1><hr>This is a test on Dialog Box</html>"), BorderLayout.CENTER);
		
		// OK button closes the Dialog
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		
		// add button to southern border
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		
		setSize(250, 150);
		
		
	}
}



