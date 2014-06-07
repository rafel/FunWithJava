/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Ritare
 */
package startup;

import java.awt.Container;
import view.Gui;
import javax.swing.JFrame;

public class Main{
    //Main
    public static void main(String[] args) {        
        JFrame frame = new JFrame();    //Skapar en Frame
        frame.setTitle("Painter");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);      //Centrera
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        Container contentPane = frame.getContentPane();
        Gui gui = new Gui();
        contentPane.add(gui); // Lägger GUI till framen
        frame.setVisible(true);     //Visar framen
    }
}