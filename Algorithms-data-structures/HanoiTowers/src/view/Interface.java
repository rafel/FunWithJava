/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.Algorithm;
import model.AlgorithmNonR;
import model.Step;

/**
 *
 * @author Rafel
 */
public class Interface {
    private ArrayList<Step> steps = new ArrayList();
    private Controller cont;

    // Const
    public Interface(Controller cont) {
        this.cont = cont;
    }

    // Kör igång programmet
    public void run(){
        System.out.println("Ange antalet ringar");
        Scanner sc = new Scanner(System.in);
        int antal = sc.nextInt();
        Algorithm algo = cont.solveHanoi(antal);
       // AlgorithmNonR algoNon = new AlgorithmNonR(1);
        this.steps = algo.getSteps();
        showSteps();
        //this.steps = algoNon.getSteps();
        //showSteps();
    }

    // Visar alla stegen
    private void showSteps() {
        System.out.println("Antal Steg : "+steps.size());
        for(int i = 0; i<steps.size();i++) {
            System.out.print("Nuvarande steg:"+ (i+1));
            System.out.println(" Flytta en ring från " + steps.get(i).getFrom() + " till " + steps.get(i).getTo());
        }
    }
}
