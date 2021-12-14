import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class GridBagLayoutTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               FontFrame frame = new FontFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * A frame that uses a grid bag layout to arrange font selection components.
 */
class FontFrame extends JFrame
{
   public FontFrame()
   {
      setTitle("GridBagLayoutTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);

      ActionListener listener = new FontAction();

      // construct components

      JLabel faceLabel = new JLabel("Face: ");

      face = new JComboBox(new String[] { "Serif", "SansSerif", "Monospaced", "Dialog",
            "DialogInput" });

      face.addActionListener(listener);

      JLabel sizeLabel = new JLabel("Size: ");

      size = new JComboBox(new String[] { "8", "10", "12", "15", "18", "24", "36", "48" });

      size.addActionListener(listener);

      bold = new JCheckBox("Bold");
      bold.addActionListener(listener);

      italic = new JCheckBox("Italic");
      italic.addActionListener(listener);

      sample = new JTextArea();
      sample.setText("The quick brown fox jumps over the lazy dog");
      sample.setEditable(false);
      sample.setLineWrap(true);
      sample.setBorder(BorderFactory.createEtchedBorder());

      // add components to grid, using GBC convenience class

      add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
      add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
      add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
      add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
      add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
      add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
      add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;

   private JComboBox face;
   private JComboBox size;
   private JCheckBox bold;
   private JCheckBox italic;
   private JTextArea sample;

   /**
    * An action listener that changes the font of the sample text.
    */
   private class FontAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String fontFace = (String) face.getSelectedItem();
         int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
               + (italic.isSelected() ? Font.ITALIC : 0);
         int fontSize = Integer.parseInt((String) size.getSelectedItem());
         Font font = new Font(fontFace, fontStyle, fontSize);
         sample.setFont(font);
         sample.repaint();
      }
   }
}

class GBC extends GridBagConstraints
{
/**
 * Constructs a GBC with a given gridx and gridy position and all other grid
 * bag constraint values set to the default.
 * @param gridx the gridx position
 * @param gridy the gridy position
 */
public GBC(int gridx, int gridy)
{
   this.gridx = gridx;
   this.gridy = gridy;
}

/**
 * Constructs a GBC with given gridx, gridy, gridwidth, gridheight and all
 * other grid bag constraint values set to the default.
 * @param gridx the gridx position
 * @param gridy the gridy position
 * @param gridwidth the cell span in x-direction
 * @param gridheight the cell span in y-direction
 */
public GBC(int gridx, int gridy, int gridwidth, int gridheight)
{
   this.gridx = gridx;
   this.gridy = gridy;
   this.gridwidth = gridwidth;
   this.gridheight = gridheight;
}

/**
 * Sets the anchor.
 * @param anchor the anchor value
 * @return this object for further modification
 */
public GBC setAnchor(int anchor)
{
   this.anchor = anchor;
   return this;
}

/**
 * Sets the fill direction.
 * @param fill the fill direction
 * @return this object for further modification
 */
public GBC setFill(int fill)
{
   this.fill = fill;
   return this;
}

/**
 * Sets the cell weights.
 * @param weightx the cell weight in x-direction
 * @param weighty the cell weight in y-direction
 * @return this object for further modification
 */
public GBC setWeight(double weightx, double weighty)
{
   this.weightx = weightx;
   this.weighty = weighty;
   return this;
}

/**
 * Sets the insets of this cell.
 * @param distance the spacing to use in all directions
 * @return this object for further modification
 */
public GBC setInsets(int distance)
{
   this.insets = new Insets(distance, distance, distance, distance);
   return this;
}

/**
 * Sets the insets of this cell.
 * @param top the spacing to use on top
 * @param left the spacing to use to the left
 * @param bottom the spacing to use on the bottom
 * @param right the spacing to use to the right
 * @return this object for further modification
 */
public GBC setInsets(int top, int left, int bottom, int right)
{
   this.insets = new Insets(top, left, bottom, right);
   return this;
}

/**
 * Sets the internal padding
 * @param ipadx the internal padding in x-direction
 * @param ipady the internal padding in y-direction
 * @return this object for further modification
 */
public GBC setIpad(int ipadx, int ipady)
{
   this.ipadx = ipadx;
   this.ipady = ipady;
   return this;
}
}