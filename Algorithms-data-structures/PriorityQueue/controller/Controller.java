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
import model.PriorityQueue;

/**
 *
 * @author Rafel
 */
public class Controller {

    private FIFO fiso = new FIFO();
    private PriorityQueue pq = new PriorityQueue(10);
    
    public void addDocument(String name,int pages){
        Document doc = new Document(name,pages);
        fiso.addToList(doc);

    }
    public boolean addDocumentPq(String name,int pages){
        Document doc = new Document(name,pages);
        return pq.insert(doc);
    }

    public Document remove(){
        return pq.remove();
    }

    public Document peekMin(){
        return  pq.peekMin();
    }

    public boolean isEmpty(){
        return pq.isEmpty();
    }

    public boolean isFull(){
        return pq.isFull();
    }

    public void printPq(){
        pq.printPq();
    }

    public String getPrinted(){
        return pq.print();
    }

    public void printDocuments(){
        fiso.printList();
    }

}
