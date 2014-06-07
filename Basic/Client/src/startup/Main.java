/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Klient
 */

package startup;

import java.io.*; //BufferedReader, InputStreamReader, DataOutputStream.
import java.net.Socket;

class Main {
    public static void main (String argv[]) throws Exception {
        //Initiera variabler.
        String mening, andradMening;

        //Skapa socket, anslutning till annat aktivt program (Servern).
        Socket s = new Socket ("localhost", 2000);
        //Skapa ström för att läsa från tangentbordet. System.in läser bytes.
        //Koppla InputStreamReader(Den läser bytes och avkodar dessa till tecken)
        //till BufferedReader(Buffrar tecken) för att kunna läsa en hel rad i taget.
        BufferedReader inmatning = new BufferedReader
                (new InputStreamReader (System.in));

        //Skapa ström för att skriva till servern.
        //DataOutputStream: Binärdataström.
        //Överföra enkla datatyper + strängar.
        DataOutputStream tillServern = new DataOutputStream
                (s.getOutputStream ());

        // Skapa ström för att läsa från servern.
        BufferedReader franServer = new BufferedReader
                (new InputStreamReader (s.getInputStream ()));

        System.out.println ("Skriv till servern: ");

        //Läs in rad från tangentbordet och skriv till servern.
        mening = inmatning.readLine ();

        tillServern.writeBytes (mening + '\n');

        //Läs in från servern och skriv ut på skärmen.
        andradMening = franServer.readLine ();
        System.out.println("Svar från server: " + andradMening);

        //Stäng socketen/anslutningen.
        s.close ();
    }
}