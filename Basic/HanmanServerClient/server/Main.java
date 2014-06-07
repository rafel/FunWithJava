/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package server;

/**
 *
 * @author Rafel
 */
class Main{
    
    private static int port = 80;
    
    public static void main (String argv[]) throws Exception {
        // Om porten ska ändras
        if(argv.length == 1){
            port = Integer.parseInt(argv[0]);
        }
        
        // Skapar en ny server
       Server server = new Server(port);
       server.startServer();
    }
}