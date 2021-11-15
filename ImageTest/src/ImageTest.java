import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               ImageFrame frame = new ImageFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame
{
   public ImageFrame()
   {
      setTitle("ImageTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add component to frame

      ImageComponent component = new ImageComponent();
      add(component);
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent
{
   public ImageComponent()
   {
      // acquire the image
	   // the image is saved in the Eclipse subfolder for this project
      try
      {
         image = ImageIO.read(new File("ImageFolder/smileyfacesmall.png"));
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   public void paintComponent(Graphics g)
   {
      if (image == null) return;

      int imageWidth = image.getWidth(this);
      int imageHeight = image.getHeight(this);

      // draw the image in the upper-left corner
      g.drawImage(image, 0, 0, null);
      
      // tile the image across the component
      // this adds the same image all through the window on a loop
      for (int i = 0; i * imageWidth <= getWidth(); i++)
         for (int j = 0; j * imageHeight <= getHeight(); j++)
            if (i + j > 0) g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j
                  * imageHeight);
   }

   private Image image;
}
