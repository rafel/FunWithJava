/******************************************************************************
 *
 *
 *
 *      Searcher - Rafel Ridha , 900710
 *
 *      2011-04-28
 */
package startup;

import controller.Controller;
import java.io.IOException;
import view.Gui;

/**
 *
 * @author Rafel
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Controller
        Controller cont = new Controller();
        
        //Skapa ett Gui objekt
        Gui grafiska = new Gui(cont);
        //Gör objektet visuellt
        grafiska.setVisible(true);
    }

}
