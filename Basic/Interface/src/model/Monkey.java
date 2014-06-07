/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Interface
 */

package model;

import controller.Player;


// Class som implimenterar interfacet Player
public class Monkey implements Player {

    public void play() {

        //Samma function som finns i Interfacet Player
        System.out.println("Monkey sound OoOaaA");
        
    }
}
