/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Calculator
 */

package startup;
import view.DrawFrame;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        //Skapar en Frame och visar den
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
