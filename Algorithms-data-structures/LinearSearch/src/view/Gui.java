/******************************************************************************
 *
 *
 *
 *      Searcher - Rafel Ridha , 900710
 *
 *      2011-04-28
 */

package view;

/**
 *
 * @author Rafel
 */

import controller.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; //JPanel, JLabel, JButton
import javax.swing.text.*;
import java.awt.*; //Color, Font.
import java.awt.event.*; //ActionListener, ActionEvent.

public class Gui  extends JFrame implements KeyListener { //implements ActionListener

    //Vars
    private JPanel helagui;
    private JTextField input,inputurl;
    private JLabel label;
    private JTextPane maintexten;
    private JButton button;
    private StyledDocument doc;
    private String title = "URL Word Search";
    private Controller cont;

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
        inputurl = new JTextField(20);
        inputurl.setText("http://www.isk.kth.se/~rafelr/");

        button = new JButton("GetUrl");
        
        //listener för knapptryckningar så att saker markeras undertiden man skriver
        input.addKeyListener(this);
        button.addActionListener(al);

        //maintexten, kan editeras och har standardtext
        maintexten = new JTextPane();
        maintexten.setText("Hämta text från URL");
        maintexten.setLocation(0, 0);

        //Scroll som är fast med textarean
        JScrollPane scroll = new JScrollPane(
                maintexten, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
                );

        scroll.setPreferredSize(new Dimension(220, 145));

        //Label som visar hur måsnga den har hittat

        label = new JLabel("Number of words found: ");
        //LÄgger till allt i panelen
        helagui.add(input);
        helagui.add(inputurl);
        helagui.add(button);
        helagui.add(scroll);
        helagui.setLocation(0, 0);
        helagui.setSize(250, 350);
        
        //lägger till panelen i fönstret

        this.add(helagui);
        helagui.add(label);

        //Stildokument som vi ska ändra stilen på beroende på vilket ord
        doc = maintexten.getStyledDocument();

    }


    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
       
    }

    public void keyReleased(KeyEvent e) {
        String[] currentText = maintexten.getText().split(" ");
        maintexten.setText("");
        int antal = cont.search(currentText,input.getText(),doc);

        label.setText("Number of words found: " + antal);
    }

    private ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String msg = cont.getUrl(inputurl.getText());
            maintexten.setText(msg);

        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }

    };        
   };
}
