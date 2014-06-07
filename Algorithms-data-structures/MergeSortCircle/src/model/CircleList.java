/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package model;

/**
 *
 * @author Rafel
 */
import java.util.Random;
import java.util.ArrayList;
public class CircleList {

    // Vars
    private int[] circleList;

    // Const.
    public CircleList(int n) {

        // Skapa random ciklar av antalet n
        Random rand = new Random();
        
        circleList = new int[n];
        for(int i = 0 ; i <n ;i++) {
            circleList[i]= (20 * (rand.nextInt(3)+1)) + (rand.nextInt(3)+1);
        }

    }

    // Returnerar listan
    public int[] getList() {
        int[] temp =  (int[])circleList.clone();
        return  temp;
    }

    // Returnerar arraylista
    public ArrayList<Circle> getCircleList() {
        ArrayList<Circle> circleArrayList  = new ArrayList<Circle>(circleList.length);
        
        for(int i : circleList) {
            circleArrayList.add(new Circle(i));
        }
        
        ArrayList<Circle> temp = (ArrayList<Circle>)circleArrayList.clone();
        return  temp;
    }

    // Sorterar listan
    public void sortList () {
        MergeSort.sort(circleList);
    }
}
