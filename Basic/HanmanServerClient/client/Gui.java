/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 *                          2013-02-10
 */
package client;

import java.awt.Insets;
import java.util.Observable;
import javax.swing.*; //JPanel, JLabel, JButton
import java.awt.event.*; //ActionListener, ActionEvent.
import java.util.Observer;

/**
 *
 * @author Rafel
 */
public class Gui  extends JFrame implements Observer,Runnable{

    //Vars
    private JPanel helagui;
    private JTextField input;
    private JTextArea wrongLetters;
    private JTextArea maintexten;
    private JButton button;
    private JButton guessbutton;
    private JButton getScore;
    private String title = "Hangman";
    private Controller cont;
    private String result;
    private Connection client;
    private Thread thread = new Thread(this);

    // Const.
    public Gui (Controller cont) {
        this.cont = cont;
        this.setTitle(title);

        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setSize (250, 350); //Storleken på ramen.
        this.setLocationRelativeTo (null); //Ramen hamnar i centrum, default läge.
        this.setResizable (false); //Kan ej förstora ramen

        helagui = new JPanel();;
        //Storlek på input testarean
        input = new JTextField(20);
        button = new JButton("Nytt Ord");
        guessbutton = new JButton("Gissa");
        getScore = new JButton("ScoreList");
        
        //listener för knapptryckningar så att saker markeras undertiden man skriver
        button.addActionListener(al);
        guessbutton.addActionListener(al);
        getScore.addActionListener(al);


        maintexten = new JTextArea();
        maintexten.setText("Start new game!");
        maintexten.setMargin( new Insets(50, 90, 50, 90));
        maintexten.setSize(350, 100);
        maintexten.setLocation(0, 0);

        //Label som visar hur måsnga den har hittat
        wrongLetters = new JTextArea("Fel bokstäver: \n");
        wrongLetters.setSize(200, 200);
        wrongLetters.setLineWrap(true);
        
        //Lägger till allt i panelen
        helagui.add(input);
        helagui.add(guessbutton);
        helagui.add(maintexten);
        
        helagui.setLocation(0, 0);
        helagui.setSize(250, 350);
        
        //lägger till panelen i fönstret

        this.add(helagui);
        helagui.add(wrongLetters);
        helagui.add(button);
        helagui.add(getScore);
        thread.start();

    }

    // Visar meddelandet den får in
    public void setClient(Connection client){
        this.client = client;
    }

    // Lyssnar av vilken button klickas och skickar iväg rätt meddelande till clienten
    private ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String id = ((JButton) e.getSource()).getText();
        if(id.equalsIgnoreCase("Nytt Ord")){
            cont.sendMessage("CLIENT:NewGame");
        }
        if(id.equalsIgnoreCase("Gissa")){
            cont.sendMessage("CLIENT:" + input.getText());
        }
        if(id.equalsIgnoreCase("ScoreList")){
            cont.sendMessage("SCORE:get:");
        }

    };        
   };

    // Observerar från connection ifall något meddelandet kommer in
    @Override
    public void update(Observable o, Object arg) {
        this.result = this.client.getRespons();
       setMessage(this.result);
    }
    
    // Tolkning av olika meddelanden som är relevanta för oss som server kan skicka.
    private void setMessage(String message){
        if(message.startsWith("MESSAGE:")){
            JOptionPane.showMessageDialog(null, message.substring(8));
        }
        if(message.startsWith("DONE:")){
            JOptionPane.showMessageDialog(null, "Grattis! Du har gissat rätt!");
            this.maintexten.setText(message.substring(5));
        }
        if(message.startsWith("GAME:")){
            maintexten.setText(message.substring(5));
        }
        if(message.startsWith("ATTEMPTS:")){
            wrongLetters.setText(message.substring(9));
        }
        if(message.startsWith("SCORE:")){
            JOptionPane.showMessageDialog(null, message.substring(6).replaceAll(",", "\n"));
        }
        
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
