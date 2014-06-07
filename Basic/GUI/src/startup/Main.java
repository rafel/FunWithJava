/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Grafik
 */

package startup;

import javax.swing.JFrame;
import view.DrawFrame;

public class Main {

    //Main
    public static void main(String[] args) {

        //Skapar en Frame och visar den
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
