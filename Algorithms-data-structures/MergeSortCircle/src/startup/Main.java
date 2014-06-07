/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package startup;
import controller.Controller;
import java.util.ArrayList;
import model.Circle;
import model.CircleList;
import view.Gui;
/**
 *
 * @author Rafel
 */

public class Main {

    public static void main(String[] args) {

        // Ny lista
        Controller cont = new Controller();
        CircleList listan = cont.createList(10);

        // Listor
        ArrayList<Circle> osorterad  = new ArrayList<Circle>();
        ArrayList<Circle> sorterad  = new ArrayList<Circle>();
        osorterad =   listan.getCircleList();

        // Sortera
        listan.sortList();
        sorterad = listan.getCircleList();

        // Starta interface
        Gui grafiska = new Gui(cont,osorterad,sorterad);
        grafiska.setVisible(true);


    }

}
