/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package server;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafel
 */
class ClientHandler extends Thread {
    // Vars
    private Server server;
    private Socket socket;
    private Hangman hangman;

    // Konstrukturn 
    public ClientHandler(Socket paramSocket, Server paramServer) {
        this.socket = paramSocket;
        this.server = paramServer;  
        this.hangman = new Hangman();
        start();        
    }

    public void run() {
        BufferedReader localBufferedReader = null;
        // Avlyssna inkommande meddelande
        try {
            localBufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } 
        catch (IOException localIOException1) {
            System.out.println("FAILED: GET INPUTSTREAM FROM CLIENT SOCKET");
            this.server.removeClient(this.socket);
            return;
        }
        try {
            String str;
            // Läsa av och tolka meddelandet från clienten
            while ((str = localBufferedReader.readLine()) != null) {
                if(str.startsWith("CLIENT:")){
                    this.server.sendToOne(socket, this.hangman.guessWord(str.substring(7).toLowerCase()));
                    this.server.sendToOne(socket, this.hangman.getWrongWords()); continue;
                }
                if(str.startsWith("SCORE:get")){
                    StringBuilder sb = new StringBuilder();
                    sb.append("SCORE:");
                    for (int i = 0; i < this.server.clientVector.size(); i++) {
                        sb.append(this.server.getClient(i).socket.getInetAddress().getHostAddress()).append(" : ").append(this.server.getClient(i).hangman.getScore()).append(",");
                    }
                    this.server.sendToOne(socket, sb.toString());
                    
                }
                System.out.println(str);
                
            }
            localBufferedReader.close();
            this.socket.close();
            System.out.println("CLIENT DISCONNECTED NICELY");
        } 
        // Om klienten dissconnectar
        catch (IOException localIOException2) {
            System.out.println("CLIENT DISCONNECTED BRUTALLY");
        }
        this.server.removeClient(this.socket);
    }
    
    // Returnera sig själv
    public Socket getSocket(){
        return this.socket;
    }
}