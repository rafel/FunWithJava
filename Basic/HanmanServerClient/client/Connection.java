/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author Rafel
 */
public class Connection extends Observable implements Runnable{
    
    // Definerar vars
    private String host;
    private int port;
    private Thread thread = new Thread(this);
    private boolean alive;
    
    private Socket socket = null;
    private PrintWriter writer = null;
    private BufferedReader reader = null;
    
    private String respons;

    // Konstruktorn
    public Connection(String host, int port) {
        this.host = host;
        this.port = port; 
    }
    
    // Uppkoppling till server
    public void connect(){
        // Försök att ...
        try {
            this.socket = new Socket(this.host,this.port); //.. Koppla upp
            this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); // ...Skapa läsare
            this.writer = new PrintWriter(this.socket.getOutputStream(),true); // .. Skapa skrivare
            
        } 
        // Fånga om något går fel och avsluta programmet
        catch (IOException e) {
            System.out.println("Could not connect: " + e);
            System.exit(1);
        }
        // Kör igång
        alive = true;
        thread.start();
    }

    @Override
    public void run() {
        String str = "";
        // Så länge prorgammet är igång
        while(alive){
            // Försök läsa inkommande meddelanden
            try {
                str = this.reader.readLine();
                setMessage(str);
            } catch (IOException e) {
                System.out.println("IOException: " + e);
                die();
            }
        
        }
        
    }

    // För avslutning av programmet
    public void die() {
        this.alive = false;
        try {
            socket.close();
            reader.close();
            writer.close();
        }
        catch (IOException e){
            System.out.println("IOException: " + e);
        }
        System.exit(1);
    }

    // För att skicka meddelande till servern
    public void getMessage(String text) {
        this.writer.println(text);
    }
    
    // Ändrar meddelandet
    public void setMessage(String message){
        if(message.length()>0){
            this.respons = message;
            setChanged();
            notifyObservers();
        }
    }
    
    // Returnerar meddelandet
    public String getRespons(){
        return this.respons;
    }
}
