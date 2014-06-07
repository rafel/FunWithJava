/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Interface
 */
package startup;

import model.*;
import controller.Handler;
import controller.Player;


public class Main {
    //Main
    public static void main(String[] args) {

        //Spela upp ljud med samma metod via ändrad implementation
        System.out.println("Genom ändrad implementation:");

        Handler h = new Handler(new Cat());
        //Spelar upp kattens ljud
        h.play();

        //Byter till hund
        h.byt(new Dog());
        //Spelar upp kattens ljud(Använder samma metod)
        h.play();

        //Byt till Monkey
        h.byt(new Monkey());
        //Spelar upp apans ljud(Använder samma metod)
        h.play();

        //Spela upp ljud med samma metod via en vektor
        System.out.println("\nGenom en interface vektor:");
        Player[] i = new Player[3];
        i[0] = new Cat();
        i[1] = new Dog();
        i[2] = new Monkey();
        
        //Presentera genom att ropa på samma funktion för alla element
        for(Player b:i){
            b.play();
        }
    }
}