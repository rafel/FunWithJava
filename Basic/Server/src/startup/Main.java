/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Server
 */
package startup;

import java.io.*; //BufferedReader, InputStreamReader, DataOutputStream.
import java.net.*; //ServerSocket, Socket.
import java.util.Scanner;

class Main{
    public static void main (String argv[]) throws Exception {
        String pwd = "password";
        //Initiera variabler.
        String klientMening, svar;

        //Skapa serversocket, vänta på annat program på port 2000.
        ServerSocket ss = new ServerSocket (2000);
        System.out.println("Server är online!");
        while (true) {
            //Scanner s = new Scanner(System.in);
            //Vänta på annat program, acceptera uppkoppling.
            //Vid anslutning så returneras ett objekt av typen Socket.
            //Representerar den skapade förbindelsen.
            Socket anslutningSocket = ss.accept();

            //Skapa ström för att läsa från klienten.
            //Koppla InputStreamReader(Den läser bytes och avkodar dessa till tecken)
            //till BufferedReader(Buffrar tecken) för att kunna läsa en hel rad i taget.
            BufferedReader franKlient = new BufferedReader
                    (new InputStreamReader(anslutningSocket.getInputStream ()));

            // Skapa ström för att skriva till klienten
            //DataOutputStream: Binärdataström.
            //Överföra enkla datatyper + strängar.
            DataOutputStream tillKlient = new DataOutputStream
                    (anslutningSocket.getOutputStream ());

            //Läs in från klienten, omvandla och skicka tillbaka.
            klientMening = franKlient.readLine ();
            if(klientMening.equalsIgnoreCase(pwd)){
                svar = "true\n";
                tillKlient.writeBytes (svar);
            }
            else{
                svar = "false\n";
                tillKlient.writeBytes (svar);
            }
            
        }
    }
}