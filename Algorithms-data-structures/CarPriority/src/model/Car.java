/******************************************************************************
 *
 *
 *
 *      CarPriority - SRS
 *
 *      2011-04-20
 */

package model;


/**
 *
 * @author Rafel
 */
public class Car {

    // Vars
    String name;
    String color;

    // Const.
    public Car(String name, String color){
        this.name = name;
        this.color = color;
    }

    // Returns Car name
    public String getName(){
        return(this.name);
    }
    // Returns Car color
    public String Color(){
        return(this.color);
    }
}
