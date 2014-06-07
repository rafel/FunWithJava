/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package model;

import java.util.Date;

/**
 *
 * @author Rafel
 */
public class Document {

    // Vars
    String name;
    long addedTime;

    // Const.
    public Document(String name){
        Date date= new Date();
        this.name = name;
        this.addedTime = date.getTime();
    }

    // Returns document name
    public String getName(){
        return(this.name);
    }
    // Returns document added time
    public long getAddedTime(){
        return(this.addedTime);
    }
}
