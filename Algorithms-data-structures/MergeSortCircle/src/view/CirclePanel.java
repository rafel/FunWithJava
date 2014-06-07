/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package view;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;
import model.Circle;


/**
 *
 * @author Rafel
 */

public class CirclePanel extends JPanel {

    // Vars
    private ArrayList<Circle> cirklarna;
    private int y;
    
    public CirclePanel(ArrayList<Circle> cirklarna,int y) {
        this.cirklarna = cirklarna;
        this.y = y;//
    }

    @Override
    public void paintComponent (Graphics gr)
    {
        super.paintComponent (gr); //Skickar med g som argument till metoden.
        this.setBackground (Color.darkGray); //Bakgrundsfärgen på panelen.

        //Castar om, Graphics2D erbjuder fler möjligheter.
        //Graphics2D saknar publika konstruktorer.
        Graphics2D g2d = (Graphics2D) gr;
        int cx = 0;
        for(int i =0;i<cirklarna.size();i++)
        {
           g2d.setColor(cirklarna.get(i).getColor());
           g2d.fill(new Ellipse2D.Double(cx, y, cirklarna.get(i).getSize(), cirklarna.get(i).getSize()));
           cx+=cirklarna.get(i).getSize()+10;
        }
       
    }
}
