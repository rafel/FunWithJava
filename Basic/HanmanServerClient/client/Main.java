/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package client;

/**
 *
 * @author Rafel
 */
public class Main {
    
    private static String host = "127.0.0.1";
    private static int port = 80;
    
    
    public static void main(String[] args) {
        // Om ingen adress eller port anges
        if(args.length == 0){
            // Ändrar inga värden
        }
        else {
            // Om bara adressen anges
            if(args.length == 1){
                host = args[0]; // Adressen till servern
            }
            // Om båda adressen och porten anges
            else {
                host = args[0]; // Adressen till servern
                port = Integer.parseInt(args[1]); // Porten till servern
            }
        }
        
        // Controller
        Controller cont = new Controller();
        Connection client =cont.newConnection(host, port);
        
        // Skapa Gui-object
        Gui gui = new Gui(cont);
        client.addObserver(gui);
        gui.setClient(client);

    }
}
