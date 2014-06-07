/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package controller;

import model.Algorithm;

/**
 *
 * @author Rafel
 */
public class Controller {

    public Algorithm solveHanoi(int rings){
        Algorithm algo = new Algorithm(rings);
        return(algo);        
    }

}
