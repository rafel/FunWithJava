/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * ServerTwo
 */

package startup;
import java.sql.*;  // SQL + mysql uppkoppling
import java.io.*; //BufferedReader, InputStreamReader, DataOutputStream.
import java.net.*; //ServerSocket, Socket.


public class Main {


  // DB connection variabel
  static protected Connection con;

  // DB uppkopplingsvariabler
  private String URL = "jdbc:mysql:///labb";
  private String driver = "com.mysql.jdbc.Driver";
  private String userID = "rafel";
  private String password = "987654";

  // metod för uppkoppling till databasen
  public void connect(){
     try {
       // register the driver with DriverManager
       Class.forName(driver);
       //Kopplar upp sig till DB:n
       con = DriverManager.getConnection(URL, userID, password);
       // Set the auto commit of the connection to false.
       // An explicit commit will be required in order to accept
       // any changes done to the DB through this connection.
       con.setAutoCommit(false);
     }
     catch (Exception e)
     {
        e.printStackTrace();
     }
  }

  public String simpleselect(String reg) throws Exception {
      // Lokala variablar
      String query;
      ResultSet rs;
      Statement stmt;

      // SQL frågan
      query = "SELECT marke FROM bil WHERE regnr='"+reg+"'";

      // Create a statement associated to the connection con.
      // The new statement is placed in the variable stmt.
      stmt = con.createStatement();

      // Exikverar SQL frågan
      rs = stmt.executeQuery(query);

      // OM bil hittas ändras detta värde
      reg = "Ingen bil hittad";

      // Lopp tills den inte returnerar något
      while (rs.next())
      {
          System.out.println("Namn: " + rs.getString("marke"));
          reg = rs.getString("marke");
      }     

      //Stänger av statmenet
      stmt.close();
      return reg;
  }

  

  public static void main(String[] argv) throws Exception {
      //Initiera variabler.
        String klientMening, svar;

        //Skapa serversocket, vänta på annat program på port 2000.
        ServerSocket ss = new ServerSocket (2000);
        System.out.println("Server är online!");
	while (true) {
            // Skapa objekt av main.
            Main t = new Main();

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

            // koppling till DB.
            t.connect();
            // Söker efter bilen
            String bil = t.simpleselect(klientMening);
            // Stänger uppkopplingen.
            con.close();
            //Resultatet printas
            System.out.println(bil);
            //Retur värdet
            svar =  bil + "\n";
            //Returnera till klienten
            tillKlient.writeBytes (svar);
            
            
        }
    }
}


