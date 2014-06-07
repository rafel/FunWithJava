/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package model;

/**
 *
 * @author Rafel
 */

public class Step {

    private int fromPole,toPole;

    public Step(int fromPole, int toPole) {
        if(fromPole=='a'){
            fromPole=1;
        }
        if(fromPole=='b'){
            fromPole=2;
        }
        if(fromPole=='c'){
            fromPole=3;
        }
        if(toPole=='a'){
            toPole=1;
        }
        if(toPole=='b'){
            toPole=2;
        }
       if(toPole=='c'){
            toPole=3;
        }
        this.fromPole = fromPole;
        this.toPole = toPole;
    }

    public int getFrom() {
        return new Integer(this.fromPole);
    }

    public int getTo() {
        return new Integer(this.toPole);
    }
}
