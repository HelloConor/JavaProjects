import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFrame {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				TextFrameField frame = new TextFrameField();
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
			}
		});

	}

}

class TextFrameField extends JFrame {
	public TextFrameField() {
		
		setTitle("TextFrame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		
		// this is adding the text fields on to the window
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		// this is the label with text formatted in a direction
		northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
		// this is adding a text field below the label
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		
		// adding the labels and fields on to the panel window
		add(northPanel, BorderLayout.NORTH);
		
		// this adds the textarea field on the window formatted
		// in the center of the window
		// 8 rows across, 40 collumns 
		final JTextArea textArea = new JTextArea(8, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);		
		add(scrollPane, BorderLayout.CENTER);
		
		// add button to append text into the text area
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				// this action gets the text inputted from user and pastes it in the textArea field
				textArea.append("User name: " + textField.getText() + "\n" + "Password: "
				+ new String(passwordField.getPassword()) + "\n");
			}
		});
		
		// adds to 
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
}