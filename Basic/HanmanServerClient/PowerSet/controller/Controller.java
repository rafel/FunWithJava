/******************************************************************************
 *
 *
 *
 *      PowerSet - Rafel Ridha
 *
 *      2011-05-20
 */
package controller;

import model.PowerSet;

/**
 *
 * @author Rafel
 */
public class Controller {

    public PowerSet newPowerSet(String str){
        PowerSet ps = new PowerSet(str);
        return ps;
    }
}
