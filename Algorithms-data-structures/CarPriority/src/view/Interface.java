/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package view;
import controller.Controller;

/**
 *
 * @author Rafel
 */
public class Interface {

    private Controller cont;
    
    public Interface(Controller cont) {
            this.cont = cont;
            start();
    }

    private void start(){
        cont.addCar("Bmw","Red");
        cont.addCar("Volvo","Blue");
        cont.addCar("Saab","Blue");
        cont.addCar("Jeep","Red");
        cont.addCar("Audi","Red");
        cont.addCar("WV","Blue");
        cont.addCar("Merca","Red");
        cont.addCar("Mitsubishi","Blue");
        cont.addCar("Caab","Blue");
        cont.addCar("Smart","Red");
        cont.addCar("Honda","Blue");
        cont.addCar("Lancer","Red");
        cont.printCars();
    }

}
