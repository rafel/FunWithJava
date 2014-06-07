/******************************************************************************
 *
 *
 *
 *      PrintQueue - SRS
 *
 *      2011-04-15
 */

package view;
import controller.Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Rafel
 */
public class Interface extends JFrame implements ActionListener{

     // Vars
    JPanel fullJPanel;
    private JTextField name,pages;
    private JTextArea result;
    private JButton addbutton,printbutton;
    private Controller cont;
    
    public Interface(Controller cont) {
        // Controller
        this.cont = cont;

        // Frame config
        this.setTitle("Priority Queue!");
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setSize (500, 300); //Storleken på ramen.
        this.setLocationRelativeTo (null); //Ramen hamnar i centrum, default läge.
        this.setResizable (true); //Kan ej förstora ramen.
        
        //start();

        // Panelen för sidan
        fullJPanel = new JPanel();

        // Textarea
        name = new JTextField(20);
        pages = new JTextField(3);
        result = new JTextArea();

        // Resultboxen
        result.setEditable(false);
        // Adds a scroll to the result box
        JScrollPane scrollResult = new JScrollPane(result);
        scrollResult.setPreferredSize(new Dimension(470, 200));

        // Buttons
        addbutton = new JButton("Add");
        addbutton.addActionListener(this);
        printbutton = new JButton("Print");
        printbutton.addActionListener(this);

        // Fylla panelen
        fullJPanel.add(addbutton);
        fullJPanel.add(printbutton);
        fullJPanel.add(name);
        fullJPanel.add(pages);
        fullJPanel.add(scrollResult);
        fullJPanel.setSize(490,300);
        fullJPanel.setBackground(Color.WHITE);
        this.add(fullJPanel);
        this.setVisible(true);
    }

    private void start(){
        cont.addDocumentPq("FirstDoc.pdf",4);
        cont.addDocumentPq("SecDoc.doc",10);
        cont.addDocumentPq("ThiDoc.xml",40);
        cont.addDocumentPq("FoDoc.java",100);
        cont.addDocumentPq("First2Doc.pdf",4);
        cont.addDocumentPq("SecDoc2.doc",10);
        cont.addDocumentPq("ThiDoc2.xml",40);
        cont.addDocumentPq("FoDoc2.java",100);
        cont.printPq();
    }

    public static void waiting(int n){

        long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while ((t1 - t0) < (n * 1000));
    }

    public void actionPerformed(ActionEvent e) {
        String id = ((JButton) e.getSource()).getText();

        // Om vi ska lägga till
        if(id.equalsIgnoreCase("Add")){
            String namev = name.getText();
            String pagen = pages.getText();
            int x = Integer.parseInt(pagen);
            if(cont.addDocumentPq(namev,x)){
                result.append("#####ADD###### \n");
                result.append(namev + " " + x + "\n");
                result.append("#####ADD###### \n");
            }
            else{
                JOptionPane.showMessageDialog(null, "Fail");
             }
            
        }
        // Annars ta bort
        else{
            result.append(cont.getPrinted());
        }
    }
}
