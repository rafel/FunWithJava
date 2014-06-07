/******************************************************************************
 *
 *
 *
 *      Towers Of Hanoi - Rafel Ridha , 900710
 *
 *      2011-05-01
 */

package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author Rafel
 */
public class Interface extends JFrame implements ActionListener{

    // Vars
    private Integer[] vector;
    private Controller cont;
    JPanel fullJPanel;
    JTextArea label = new JTextArea (2, 10);
    private JTextField input;
    private Font font = new Font ("verdana", Font.BOLD, 13);
    private JButton addbutton,removebutton;
    VectorPanel vectorpanel;

    // Const
    public Interface(Controller cont) {
        this.cont = cont;

        // Frame config
        this.setTitle("Circular Buffer!");
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setSize (600, 500); //Storleken på ramen.
        this.setLocationRelativeTo (null); //Ramen hamnar i centrum, default läge.
        this.setResizable (true); //Kan ej förstora ramen.
        

        // Panelen för sidan
        fullJPanel = new JPanel();

        // Textarea
        input = new JTextField(20);

        // Buttons
        addbutton = new JButton("Add");
        addbutton.addActionListener(this);
        removebutton = new JButton("Remove");
        removebutton.addActionListener(this);

        // Text
        label.setLocation(0, 300);
        label.setFont(font);
        label.setText("");

        label.setEditable(false);


        // Fylla panelen
        fullJPanel.add(label);
        fullJPanel.add(input);
        fullJPanel.add(addbutton);
        fullJPanel.add(removebutton);
        //fullJPanel.add(vectorpanel);
        fullJPanel.setSize(600,200);
        fullJPanel.setBackground(Color.WHITE);
        vectorpanel = new VectorPanel(askSize());
        vectorpanel.setLocation(0, 200); 
        fullJPanel.add(vectorpanel);
        
        this.add(fullJPanel);
        this.setVisible(true);
    }

    public void showVector(){
        for(Integer i:vector){
            System.out.println(i+" ");
        }
    }
    // Kör igång programmet
    public void start(){
        //askSize();
        this.vector = cont.getList();
    }

    private Integer[] askSize(){
        String ans = JOptionPane.showInputDialog("Hur stor");
        int x = Integer.parseInt(ans);
        cont.setBuffer(x);
        return(cont.getList());
    }

    // Lysnar på alla event
    public void actionPerformed(ActionEvent e) {
        String id = ((JButton) e.getSource()).getText();

        // Om vi ska lägga till
        if(id.equalsIgnoreCase("Add")){
            String value = input.getText();
            System.out.println(value);
            if(!value.isEmpty()){
            int x = Integer.parseInt(value);
            if(!cont.store(x)){
                JOptionPane.showMessageDialog(null, "Full");
            }
            }
        }
        // Annars ta bort
        else{
            Integer s = cont.read();
                label.setText("Empty");
            if(s!=null){
                label.setText(s.toString() + " togs bort!");
            }
//            showVector();
        }

        vectorpanel.redraw(cont.getList());

    }
}
