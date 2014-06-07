/******************************************************************************
 *
 *
 *
 *      FIFOPrinter - SRS
 *
 *      2011-04-15
 */

package controller;
import model.Document;
import model.ArrayQueue;

/**
 *
 * @author Rafel
 */
public class Controller {

    private ArrayQueue aq = new ArrayQueue(10);
    
    public boolean addDocument(String name,int pages){
        Document doc = new Document(name,pages);
        return aq.insert(doc);
    }

    public Document remove(){
        return aq.remove();
    }

    public boolean isEmpty(){
        return aq.isEmpty();
    }

    public boolean isFull(){
        return aq.isFull();
    }

    public String getPrinted(){
        return aq.print();
    }

}
