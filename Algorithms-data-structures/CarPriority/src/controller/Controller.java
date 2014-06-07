/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package controller;
import model.BinaryHeap;
import model.Car;
import model.FIFO;

/**
 *
 * @author Rafel
 */
public class Controller {

    private FIFO fiso = new FIFO();
    private BinaryHeap heap = new BinaryHeap();
    public void addCar(String name, String color){
        Car car = new Car(name,color);
        //fiso.addToList(doc);
        heap.insert(4);

    }

    public void printCars(){
        fiso.printList();
        System.out.println("s");
        System.out.println(heap.isEmpty());
    }

}
