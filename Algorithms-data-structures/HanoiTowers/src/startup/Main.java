/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package startup;

import controller.Controller;
import view.Interface;

/**
 *
 * @author Rafel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller cont = new Controller();
        Interface inter = new Interface(cont);
        inter.run();
    }
}
