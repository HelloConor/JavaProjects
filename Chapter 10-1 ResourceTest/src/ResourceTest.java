import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ResourceTest {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() 
				{
					public void run()
					{
						ResourceTestFrame frame = new ResourceTestFrame();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
	}
}

class ResourceTestFrame extends JFrame 
{
	public ResourceTestFrame()
	{
		setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
		setTitle("ResourceTest");
		URL aboutURL = getClass().getResource("about.gif");
		Image img = Toolkit.getDefaultToolkit().getImage(aboutURL);
		setIconImage(img);
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		Scanner in = new Scanner(stream);
		while (in.hasNext())
			textArea.append(in.nextLine() + "\n");
		add(textArea);
	}
	
	public static final int DEFAULT_HEIGHT = 300;
	public static final int DEFAULT_WIDTH = 300;
}
