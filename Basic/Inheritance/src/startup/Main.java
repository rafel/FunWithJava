/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Arv
 */

package startup;

import controller.Handler;
import model.Circle;
import model.Square;
import model.Triangle;


public class Main {
    //Main
    public static void main(String[] args) {
        Circle c = new Circle(); // Skapar en Cirkel
        Handler.askCircle(c);   // Frågar om personen vill ange egenskaper till den

        Square s = new Square(); // Skapar en Fyrkant
        Handler.askSquare(s);   // Frågar om personen vill ange egenskaper till den
        
        Triangle t = new Triangle(); // Skapar en Triangel
        Handler.askTriangle(t); // Frågar om personen vill ange egenskaper till den
    }
}
