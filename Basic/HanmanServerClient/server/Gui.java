/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */

package server;
import javax.swing.*; //JPanel, JLabel, JButton

/**
 *
 * @author Rafel
 */
public class Gui  extends JFrame implements Runnable {

    //Vars
    private String title = "HangmanServer";
    private JTextArea textArea = new JTextArea();
    private Thread thread = new Thread(this);

    // Const.
    public Gui () {
        this.setTitle(title);

        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setSize (250, 350); //Storleken på ramen.
        this.setLocationRelativeTo (null); //Ramen hamnar i centrum, default läge.
        this.setResizable (false); //Kan ej förstora ramen

        getContentPane().add(new JScrollPane(this.textArea));
        setLocation(0, 0);
        setSize(400, 200);
        this.thread.start();
    }

    // Visar meddelandet den får in
    public void setMessage(String message){
        textArea.append(message);
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
        
}
