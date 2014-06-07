/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rafel
 */
public class Algorithm {

    int x;
    
    private ArrayList<Step> steps = new ArrayList();

    public Algorithm(int numberOfRings){
        hanoi(numberOfRings, 3, 1, 2);
    }
    
    private void hanoi(int n, int toPole, int fromPole, int helpPole) {
       x++;
       System.out.println(x + ": " + " " + n + " " + toPole + " " + fromPole + " " + helpPole);
        // Basfallet
        if (n==0){
           System.out.println("Basfallet");
            return;           
	}
        
        hanoi(n-1,helpPole,fromPole,toPole);
        steps.add(new Step(fromPole,toPole));
        System.out.println("Logga");
        hanoi(n-1,toPole,helpPole, fromPole);
    }

    // Returnerar stegen
    public ArrayList<Step> getSteps() {
        return steps;
    }
}