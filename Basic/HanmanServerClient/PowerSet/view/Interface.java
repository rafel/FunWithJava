/******************************************************************************
 *
 *
 *
 *      PowerSet - Rafel Ridha
 *
 *      2011-05-20
 */

package view;

import controller.Controller;
import javax.swing.JOptionPane;
import model.PowerSet;

/**
 *
 * @author Rafel
 */
public class Interface {

    private Controller cont;
    public Interface(Controller cont) {
        this.cont = cont;
    }

    public void start() {
        String st = JOptionPane.showInputDialog("Mata in ett ord!");
        PowerSet ps = cont.newPowerSet(st);
        ps.print();
    }
}
