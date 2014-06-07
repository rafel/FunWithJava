/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package view;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import model.Circle;

/**
 *
 * @author Rafel
 */
public class Gui extends JFrame {

    // Vars
    private Controller cont;
    private String title = "MergeSort Circles";

    // Const.
    public Gui(Controller cont,ArrayList<Circle> osorterad,ArrayList<Circle> sorterad) {

        // Inställningar
        this.setTitle(title);
        Font font = new Font ("verdana", Font.BOLD, 24);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //this.setLayout(null);
        
        this.setSize (800, 600); //Storleken på ramen.
        this.setLocationRelativeTo (null); //Ramen hamnar i centrum, default läge.
        this.setResizable (true); //Kan ej förstora ramen

        // Nya paneler
        JPanel label1Panel = new JPanel();
        JPanel label2Panel = new JPanel();
        JPanel osorteradPanel = new CirclePanel(osorterad,0);
        JPanel sorteradPanel = new CirclePanel(sorterad,400);

        // Nya Labels
        JLabel osorteradLabel = new JLabel();
        JLabel sorteradLabel = new JLabel();

        /* Storlek anpassning*/
        //label1Panel.setSize(200, 50);
        //label2Panel.setSize(200, 50);

        //sorteradPanel.setSize(800, 50);
        //osorteradPanel.setSize(800, 50);

       // label1Panel.setLocation(0, 0);
        label1Panel.setBounds(0,0,800,50);
        label2Panel.setBounds(0,280,800,50);
       // label2Panel.setLocation(0, 50);

        osorteradPanel.setBounds(0,50,800,100);
        //osorteradPanel.setLocation(0, 50);
        //sorteradPanel.setLocation(0, 50);
        sorteradPanel.setBounds(0,0,800,100);

        // Texten
        osorteradLabel.setText("Unsorted");
        sorteradLabel.setText("Sorted");
        osorteradLabel.setFont(font);
        sorteradLabel.setFont(font);

        // Adda till panelerna till framen
        label1Panel.add(osorteradLabel);
        label2Panel.add(sorteradLabel);
        this.add(label1Panel);
        this.add(osorteradPanel);
        this.add(label2Panel);
        this.add(sorteradPanel);
    }

}
