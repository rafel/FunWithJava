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
        cont.addDocument("FirstDoc.pdf");
        waiting(1);
        cont.addDocument("SecDoc.doc");
        waiting(2);
        cont.addDocument("ThiDoc.xml");
        waiting(1);
        cont.addDocument("FoDoc.java");
        cont.printDocuments();
    }

    public static void waiting(int n){

        long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while ((t1 - t0) < (n * 1000));
    }
}
