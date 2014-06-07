/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package view;
import javax.swing.*; //JPanel, JLabel, JButton
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*; //Color, Font.
/**
 *
 * @author Sam Sam
 */
public class VectorPanel extends JPanel
{
    private Integer[] vector;
    private JLabel[] rectangles;
 private Font font = new Font ("verdana", Font.BOLD, 40);
    public VectorPanel(Integer[] vector)
    {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(0, 0);
        //this.setSize(400, 400);
        this.vector = vector;
        addLabels(vector);

    }
    public void redraw(Integer[] vector) {
        for (int i =0;i< rectangles.length;i++)
        {
            if(vector[i]!=null)
                rectangles[i].setText(vector[i].toString());
            else
                rectangles[i].setText("  ");
        }

    }

    private void addLabels(Integer[] vector)
    {
        this.rectangles = new JLabel[vector.length];

        Border border = LineBorder.createGrayLineBorder();

        for (int i =0;i< rectangles.length;i++)
        {
            rectangles[i]=new JLabel();
            rectangles[i].setFont(font);

            if(vector[i]!=null)
                rectangles[i].setText(vector[i].toString());

            else
                rectangles[i].setText("  ");

            rectangles[i].setLocation(i*100, 0);
            rectangles[i].setBackground(Color.LIGHT_GRAY);
            
        rectangles[i].setBorder(border);

        this.add(rectangles[i]);
        }
    }
    @Override
    public void paintComponent (Graphics gr)
    {
        super.paintComponent (gr); //Skickar med g som argument till metoden.


        //Castar om, Graphics2D erbjuder fler möjligheter.
        //Graphics2D saknar publika konstruktorer.
        Graphics2D g2d = (Graphics2D) gr;

    }
}
