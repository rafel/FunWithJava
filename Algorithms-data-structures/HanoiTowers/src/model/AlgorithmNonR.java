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
public class AlgorithmNonR {

    int x;

    private ArrayList<Step> steps = new ArrayList();

    public AlgorithmNonR(int numberOfRings){
        hanoi(numberOfRings, 'a', 'c', 'b');
    }

   private void hanoi(int height, char fromPole, char toPole, char withPole) {
          int[] HeightStack = new int[height];
          char[] fromStack  = new char[height],
                 toStack    = new char[height],
                 withStack  = new char[height];
          int[]  ReturnAddr = new int[height];
          int SP  = -1; // Stack Pointer
          int SUB = height - 1;
          int flag=1;
          boolean done=false;
          char tmp;
          do {
             switch (flag) {
	        case 1: while (height>0) {
                           SP++;
                           if (SP > SUB){
                              System.out.println("Stack overflow");
                              System.exit(1);
                           }
                           HeightStack[SP] = height;
                           fromStack[SP] = fromPole;
                           toStack[SP] = toPole;
                           withStack[SP] = withPole;
                           ReturnAddr[SP] = 2;
                           height--;
                           tmp = toPole;      // swap
                           toPole = withPole;
                           withPole = tmp;    
			}
                        flag=3;
                        break;
	        case 2: steps.add(new Step(fromPole,toPole));
                        SP++;
                        if (SP > SUB) {
                           System.out.println("Stack overflow");
                           System.exit(1);
                        }
                        HeightStack[SP] = height;
                        fromStack[SP] = fromPole;
                        toStack[SP] = toPole;
                        withStack[SP] = withPole;
                        ReturnAddr[SP] = 3;
                        height--;
                        tmp = fromPole;      // swap
                        fromPole = withPole; 
                        withPole = tmp;     
                        flag=1;
                        break;
	        case 3: if (SP >= 0){ //Stacken ej tom
                            while (SP >= 0 && flag == 3){
                              height = HeightStack[SP];
                              fromPole = fromStack[SP];
                              toPole = toStack[SP];
                              withPole = withStack[SP];
                              flag = ReturnAddr[SP];
                              SP--;
			   }
			}
                        else {
                           done = !done;
			}
                        break;
	     }
	  }
          while (!done);
       }
   
    // Returnerar stegen
    public ArrayList<Step> getSteps() {
        return steps;
    }
}