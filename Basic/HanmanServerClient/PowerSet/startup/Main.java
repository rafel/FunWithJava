/******************************************************************************
 *
 *
 *
 *      PowerSet - Rafel Ridha
 *
 *      2011-05-20
 */

package startup;

/**
 *
 * @author Rafel
 */
import controller.Controller;
import view.Interface;
public class Main {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        Controller cont = new Controller();
        Interface gui = new Interface(cont);
        gui.start();
    }
}
