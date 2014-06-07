/******************************************************************************
 *
 *
 *
 *      LinkedList - Rafel Ridha
 *
 *      2011-05-15
 */

package controller;

import model.LinkedList;
import model.List;

/**
 *
 * @author Rafel
 */
public class Controller {
    LinkedList ll;
    List l;

    public LinkedList createLinkedList(){
        ll = new LinkedList();
        return ll;
    }

    public List createList(int size){
        l = new List(size);
        return l;
    }

}
