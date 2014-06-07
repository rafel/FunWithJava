/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package controller;
import model.Document;
import model.FIFO;

/**
 *
 * @author Rafel
 */
public class Controller {

    private FIFO fiso = new FIFO();
    public void addDocument(String name){
        Document doc = new Document(name);
        fiso.addToList(doc);

    }

    public void printDocuments(){
        fiso.printList();
    }

}
