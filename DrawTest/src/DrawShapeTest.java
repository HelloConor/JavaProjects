import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawShapeTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               DrawFrame frame = new DrawFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

class DrawFrame extends JFrame
{
   public DrawFrame()
   {
      setTitle("DrawTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add panel to frame

      DrawComponent component = new DrawComponent();
      add(component);
   }
   // this is the size of the frame window 
   public static final int DEFAULT_WIDTH = 400;
   public static final int DEFAULT_HEIGHT = 400;
}

class DrawComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      // this is the rectangle size
      double leftX = 100;
      double topY = 100;
      double width = 200;
      double height = 150;      
      // this draws the rectangle using the above pixel coordinates 
      // X = 0 & Y = 0 means top left. 
      Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
      g2.draw(rect);
      
      // this added a second rectangle which surrounds the first rectangle
      Rectangle2D rectTwo = new Rectangle2D.Double(leftX + -20, topY - 10, width + 40, height + 20);
      g2.draw(rectTwo);

      // This draws the inner circle/ellipse within the frame of the rectangle
      Ellipse2D ellipse = new Ellipse2D.Double();
      ellipse.setFrame(rect);
      g2.draw(ellipse);

      // draw a diagonal line
      // this line draws diagonal top left to bottom right
      g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));
      // this line draws diagonal bottom left to top right
      g2.draw(new Line2D.Double(leftX, topY + height, leftX + width, topY));
      
      // this draws the outer circle using the center of the rectangle as the starting point for radius
      double centerX = rect.getCenterX();
      double centerY = rect.getCenterY();
      double radius = 150;
      // this now draws the outer large circle using the above as references
      Ellipse2D circle = new Ellipse2D.Double();
      circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
      g2.draw(circle);
   }
}