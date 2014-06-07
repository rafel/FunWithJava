/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * MouseAction
 */
package startup;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main extends JPanel implements MouseListener {
    BlankArea blankArea;
    JTextArea textArea;
    static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    //Skapar och visar grafiska interfacet
    private static void createAndShowGUI() {
        //Skapar fönstret
        JFrame frame = new JFrame("MouseListner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Skapar innehållet till fönstret.
        JComponent newContentPane = new Main();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Visar fönstret
        frame.pack();
        frame.setVisible(true);
    }

    public Main() {
        super(new GridLayout(0,1)); // Positionering
        
        blankArea = new BlankArea(Color.GRAY); //Skapar en area
        add(blankArea);     // Lägger till Arean
        
        textArea = new JTextArea();     //Skapar en textarea
        textArea.setEditable(false);    //Ej tillåta ändring av textarea
        JScrollPane scrollPane = new JScrollPane(textArea); // Göra textArea "scrollbar"
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Inställningar om vertical scrollning
        scrollPane.setPreferredSize(new Dimension(200, 75));
        add(scrollPane);// Lägger till paneln

        //Lägger Mouselistner till arean och panelen
        blankArea.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(450, 450));  //Dimentioner
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    //Printar ut medelanden
    void eventOutput(String eventDescription, MouseEvent e) {
        textArea.append(eventDescription + " över "
                + e.getComponent().getClass().getName()
                + "." + NEWLINE);
        textArea.setCaretPosition(textArea.getDocument().getLength()); // Positionering
    }

    // När man trycker på musknappen
    public void mousePressed(MouseEvent e) {
        eventOutput("Musen tyckt (Antalet click: "
                + e.getClickCount() + ")", e);
    }

    //När man släpper musknappen
    public void mouseReleased(MouseEvent e) {
        eventOutput("Musen släppt (Antalet click: "
                + e.getClickCount() + ")", e);
    }

    //När musen är över
    public void mouseEntered(MouseEvent e) {
        eventOutput("Musen är ", e);
    }

    //När musen lämnar
    public void mouseExited(MouseEvent e) {
        eventOutput("Musen lämnade inte", e);
    }

    //Ett Click
    public void mouseClicked(MouseEvent e) {
        eventOutput("Mus klick (antalet click: "
                + e.getClickCount() + ")", e);
    }
}