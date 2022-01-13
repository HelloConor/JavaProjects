import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DataExchangeTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				DataExchangeFrame frame = new DataExchangeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
}

class DataExchangeFrame extends JFrame {
	
	public DataExchangeFrame() {
		
		setTitle("DataExchangeTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// construct a file menu
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu fileMenu = new JMenu("File");
		mbar.add(fileMenu);
		
		// add Connect and Exit menu items
		
		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.addActionListener(new ConnectAction());
		fileMenu.add(connectItem);
		
		// Exit item to exit the program
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
			});
		fileMenu.add(exitItem);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);

	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private PasswordChooser dialog = null;
	private JTextArea textArea;
	
	// The Connect action pops up the Password dialog
	
	private class ConnectAction implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			// if first time, construct a dialog
			
			if (dialog == null) dialog = new PasswordChooser();
			
			// set default values
			dialog.setUser(new User("yourname", null));
			
			// pop up dialog 
			if (dialog.showDialog(DataExchangeFrame.this, "Connect"))
			{
				// if accepted, retrieve user input
				User u = dialog.getUser();
				textArea.append("user name = " + u.getName() + " password = "
						+ (new String(u.getPassword())) + "\n");
				
			}
		}
	}
	
}	

class PasswordChooser extends JPanel {
	
	public PasswordChooser() {
		
		setLayout(new BorderLayout());
		
		// construct a panel with username and password fields
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		panel.add(new JLabel("User name:"));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("Password:"));
		panel.add(password = new JPasswordField(""));
		add(panel, BorderLayout.CENTER);
		
		// create OK and Cancel buttons that terminate the dialog
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						ok = true;
						dialog.setVisible(false);
					}
				});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dialog.setVisible(false);
					}
				});
		
		// add buttons to the southern border
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);
				
	}
	
	// Sets the dialog defaults
	// @param u the default user information
	
	public void setUser(User u) {
		
		username.setText(u.getName());
	}
	
	// gets the dialog entrys
	// @param a User Object whose state represent the dialog entries
	
	public User getUser() {
		
		return new User(username.getText(), password.getPassword());		
	}
	
	/**
	 * Show the chooser panel in the dialog
	 * @param parent a component in the owner frame or null
	 * @param title the dialog window title
	 */
	
	public boolean showDialog(Component parent, String title) {
		
		ok = false;
		
		// locate the owner frame 
		
		Frame owner = null;
		if (parent instanceof Frame) owner = (Frame) parent;
		else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
		
		// if first time, or if owner has changed, make new dialog
		
		if (dialog == null || dialog.getOwner() != owner)
		{
			dialog = new JDialog(owner, true);
			dialog.add(this);
			dialog.getRootPane().setDefaultButton(okButton);
			dialog.pack();
		}
		
		// set title and show dialog
		
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
		
	}
	
	private JDialog dialog;
	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private boolean ok;
	
}

/** 
 * a user has a name and password, for security reasons the password is stored as a char[], not a String
 */

class User {
	
	public User(String aName, char[] aPassword)
	{
		name = aName;
		password = aPassword;
	}
	
	public String getName()
	{
		return name;
	}
	
	public char[] getPassword()
	{
		return password;
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public void setPassword(char[] aPassword)
	{
		password = aPassword;
	}
	
	private String name;
	private char[] password;
}




