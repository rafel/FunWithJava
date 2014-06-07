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
    int pages;

    // Const.
    public Document(String name, int pages){
        Date date= new Date();
        this.name = name;
        this.addedTime = date.getTime();
        this.pages = pages;
    }

    // Returns document name
    public String getName(){
        return(this.name);
    }
    // Returns document added time
    public long getAddedTime(){
        return(this.addedTime);
    }

    //Returns numbers of pages
    public int getPages(){
        return(this.pages);
    }
}
