/*mer info : http://www.programmera.net/java/synchronized.php
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Trådar
 */

package startup;

public class NewThread extends Thread {
    //Ett antal element i arrayen.
    private String[] meddelande = {"This", "thread", "is", "alive", "now."};

    public NewThread (String namn) {
	super (namn); //Anropar Thread's konstruktor.
    }

    //Metoden anropas när tråden startas.
    @Override
    public void run () {
        //Skydda statiska fält kräver ett statisk synkroniserat block.
        //I det här fallet System.out
        synchronized (System.out) {
            //For-loopen ligger i synchronized blocket för att vara låst
            //till enbart en tråd. Lägger vi For-loopen utanför så får en annan
            //tråd chans att exekvera mellan, vill ej i det här sammanhanget.
            for (int i = 0; i < meddelande.length; i++ ) {
                slumpVanta (); //Fördröj slumpmässigt antal sekunder.

                //Skriv ut trådens namn samt meddelandet.
                System.out.println(getName () + meddelande[i]);
            }
        }
    }

    //Den här metoden beräknar ett slumpmässigt tal för fördröjning av tråden.
    private void slumpVanta () {
        try {
            Thread.sleep((int)(2000*Math.random ())); //Random: 0,0 till 1,0.
        }

        catch (InterruptedException e) {
            System.out.println ("Aborted!");
        }
    }
}  