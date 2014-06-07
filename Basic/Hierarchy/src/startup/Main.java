/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Klasshierarki
 */

package startup;
import model.*;

public class Main {

    public static void main(String[] args) {
        Bil b = new Bil(); //Skapar en bil
        Motorcykel mc = new Motorcykel(); //Skapar en motorcyckel
        model.Actions.MyBil(b); //Kör metoden MyBil som skall utföra sammanfoggning av bilen.
        model.Actions.MyMC(mc); //Kör metoden MyMC som skall utföra sammanfoggning av mc:n
    }
}
