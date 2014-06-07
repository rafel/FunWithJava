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
public class Cat implements Player {
    
    //Samma function som finns i Interfacet Player
    public void play() {

        System.out.println("Cat sound Mjau");
        
    }
}
