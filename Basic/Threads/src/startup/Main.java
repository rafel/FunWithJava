/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Trådar
 */
package startup;

/**
 *
 * @author Rafel
 */
public class Main {
    public static void main (String[] args) throws InterruptedException {
        //Objekt av typen NyTrad skapas.
	NewThread threadOne = new NewThread ("Thread 1: ");
	NewThread threadTwo = new NewThread ("Thread 2: ");

        //Startar trådarna, run-metoden körs.
	threadOne.start ();
	threadTwo.start ();

        //Boolska värden initieras.
        boolean threadOneAlive = true;
        boolean threadTwoAlive = true;

        do {
            //Om tråd 1 är död, skriv ut ett meddelande.
            if(threadOneAlive && !threadOne.isAlive ()) {
                threadOneAlive = false;
                System.out.println("\nThread 1 is dead.");
            }

            //Om tråd 2 är död, skriv ut ett meddelande.
            if(threadTwoAlive && !threadTwo.isAlive ()) {
                threadTwoAlive = false;
                System.out.println ("Thread 2 is dead.");
            }
        }
        while (threadOneAlive || threadTwoAlive); //Loopa tills trådarna är döda.
    }
}