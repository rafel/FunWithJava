/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package client;

import client.Connection;

/**
 *
 * @author Rafel
 */
public class Controller {
    
    Connection con;
    
    public Controller(){
        
    }
    
    public Connection newConnection(String adress,int port){
        this.con = new Connection(adress, port);
        this.con.connect();
        return con;
    }
    
    public void sendMessage(String message){
        con.getMessage(message);
    }

}
