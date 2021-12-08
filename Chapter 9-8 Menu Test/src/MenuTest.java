import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				MenuFrame frame = new MenuFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

class MenuFrame extends JFrame {
	public MenuFrame() {
		
		setTitle("MenuTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		
		// this adds File on the menu bar and adds New to it
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));
		
		// demonstrate the accelerators 
		
		// this adds Open as a submenu of 'File' and allows user to use keyboard shortcut to use as well
		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		// a seperator is the line to seperate the actions
		fileMenu.addSeparator();
		
		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		
		// this add an exit sub-menu of 'File'
		fileMenu.add(new AbstractAction("Exit") {
			
			public void actionPerformed(ActionEvent event) {
				
				System.exit(0);
			}
		});
		
		// demonstrate check box and radio buttons 
		
		readonlyItem = new JCheckBoxMenuItem("Read-Only");
		readonlyItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				boolean saveOK = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOK);
				saveAsAction.setEnabled(saveOK);
				
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		// demonstrate icons
		
		Action cutAction = new TestAction("Cut");
		
		Action copyAction = new TestAction("Copy");
		
		Action pasteAction = new TestAction("Paste");
		
		
		JMenu editMenu = new JMenu("Edit");
		//editMenu.add(cutAction);
		
		
		// demonstrate nested menus
		
		JMenu optionMenu = new JMenu("Options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		
		// deonstrate mnenonics 
		
		JMenu helpMenu = new JMenu("Help");
		//helpMenu.setMnemonic("H");
		
		JMenuItem indexItem = new JMenuItem("Index");
		//indexItem.setMnemonic("I");
		helpMenu.add(indexItem);
		
		// you can also add he mnenonic key to an action
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		// add all top level menus to menu bar
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		// demonstrate pop ups
		
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
		panel.addMouseListener(new MouseAdapter() {
		});
		
		
		
		
		
	}
	
	private static int DEFAULT_WIDTH = 300;
	private static int DEFAULT_HEIGHT = 300;
	
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
}

// a sample action that prints the action name to System.out

// when one of the Actions are selected then  this prints a message out

class TestAction extends AbstractAction
{
   public TestAction(String name)
   {
      super(name);
   }

   public void actionPerformed(ActionEvent event)
   {
      System.out.println(getValue(Action.NAME) + " selected.");
   }
}
