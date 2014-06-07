/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Rafel
 */
public class FIFO {

    ArrayList<Document> myArr = new ArrayList<Document>();

    public void addToList(Document doc){
        myArr.add(doc);
    }

    public void printList(){
        for (int i = 0;i<myArr.size();i++) {
            System.out.print("Namn : " + myArr.get(i).getName());
            System.out.println(" Tid : " + myArr.get(i).addedTime);
        }
    }
}
