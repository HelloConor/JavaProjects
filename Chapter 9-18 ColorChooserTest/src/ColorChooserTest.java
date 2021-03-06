import java.awt.*;
import java.awt.event.*;

import javax.print.attribute.standard.DialogOwner;
import javax.swing.*;
import javax.swing.event.*;

public class ColorChooserTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable()
				{
					public void run() 
					{
						ColorChooserFrame frame = new ColorChooserFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
	}
}

class ColorChooserFrame extends JFrame
{
	public ColorChooserFrame()
	{
		setTitle("ColorChooserTest");
		setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
		
		// add chooser panel to frame
		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel);
	}	
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
}

// a panel with buttons to pop up three types of color choosers
class ColorChooserPanel extends JPanel
{
	public ColorChooserPanel()
	{
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		
		JButton modelessButton = new JButton("Modeless");
		modelessButton.addActionListener(new ModelessListener());
		add(modelessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
	}
	
	// this listener pops up a modal color chooser
	
	private class ModalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background", defaultColor);
			if (selected != null) setBackground(selected);
		}
	}
	
	private class ModelessListener implements ActionListener 
	{
		public ModelessListener()
		{
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color", false, chooser, new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							setBackground(chooser.getColor());
						}
					}, null /* no Cancel button listener */);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
		
	private JDialog dialog;
	private JColorChooser chooser;
	}
	
	// this listener pops up a modeless color chooser.
	//the panel color is changed immediately when the user picks a new color
	
	private class ImmediateListener implements ActionListener
	{
		public ImmediateListener()
		{
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(new ChangeListener()
					{
						public void stateChanged(ChangeEvent event)
						{
							setBackground(chooser.getColor());
						}
					});
			
			dialog = new JDialog((Frame) null, false); // not modal)
			dialog.add(chooser);
			dialog.pack();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
		
		private JDialog dialog;
		private JColorChooser chooser;
	}
	
}

