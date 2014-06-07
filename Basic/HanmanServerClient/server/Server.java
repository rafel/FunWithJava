/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Rafel
 */
public class Server implements Runnable {
    private Thread thread = new Thread(this);
    private ServerSocket ss;
    public Vector clientVector = new Vector();
    private int port;
    private Gui gui;
    private ArrayList<ClientHandler> clientList;
    
    // Konstrukturn
    public Server(int port) {
        this.port = port;
        this.gui = new Gui();
        //this.gui.setVisible(true);
        clientList = new ArrayList<ClientHandler>();
        // Försöker skapa en server socket bunden till en viss port
        try {
            this.ss = new ServerSocket(port);
            setTitle(0);
        } 
        catch (IOException localIOException) {
            System.out.println("FAILED: COULD NOT LISTEN ON PORT: " + port);
            System.exit(1);
        }
        
    }
    // Startar igång tråden för servern
    public void startServer(){
        thread.start();
    }
    
    public void run() {
        while (true) {
            Socket localSocket = null;
            // Lyssnar ifall en uppkoppling försöker göras
            try {
                localSocket = this.ss.accept();
            } 
            catch (IOException localIOException) {
                System.out.println("FAILED: ACCEPTING CLIENT");
            }
            addClient(localSocket);     // Lägger till clienten
        }
    }

    // Lägger till en client
    private synchronized void addClient(Socket paramSocket) {
        this.clientVector.addElement(paramSocket);
        setTitle(this.clientVector.size());
        ClientHandler c = new ClientHandler(paramSocket, this);
        clientList.add(c);
        this.gui.setMessage("CLIENT: " + getHost(paramSocket) + " JOINED THE GAME!" + "\n");
    }

    // Tar bort en client
    public synchronized void removeClient(Socket paramSocket) {
        this.gui.setMessage("CLIENT: " + getHost(paramSocket) + " LEFT THE GAME!" + "\n");
        this.clientVector.removeElement(paramSocket);
        setTitle(this.clientVector.size());        
    }
    
    // Returnerar en client från clientlistan
    public synchronized ClientHandler getClient(int index){
        return  clientList.get(index);
    }

    // Skickar meddelande till en viss client
    public synchronized void sendToOne(Socket paramSocket, String paramString) {
        try {
            PrintWriter localPrintWriter = new PrintWriter(paramSocket.getOutputStream(), true);
            localPrintWriter.println(paramString);
        } 
        catch (IOException localIOException) {
            System.out.println("FAILED: SEND TO ONE");
        }
    }

    
    // returnerar namn på client
    private String getHost(Socket paramSocket) {
        return paramSocket.getInetAddress().getHostName();
    }

    // Returnerar namn på host
    private String getHost(ServerSocket paramServerSocket) {
        try {
            paramServerSocket.getInetAddress(); 
            return InetAddress.getLocalHost().getHostName(); 
        } 
        catch (UnknownHostException localUnknownHostException) {
        }
        return "FAILED: GET SERVER HOST";
    }

    // Titel på gui:n
    private void setTitle(int paramInt) {
        this.gui.setTitle("SERVER ON: " + getHost(this.ss) + " - PORT: " + port + " - N CLIENTS: " + paramInt);
    }
}