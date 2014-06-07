/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Grafik
 */

package view;

import java.awt.*;
import javax.swing.*;


public class DrawFrame extends JFrame {
    // Få fram information om skärmen för att Centrera Jframen
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    public int screenHeight = screenSize.height;
    public int screenWidth = screenSize.width;


    public DrawFrame() {
        setSize(700, 700);
        // Centrera på skärmen
        setLocation(screenWidth / 4, screenHeight / 10);
        setResizable(false);
        setTitle("Schack Bräda");
        setUndecorated(false); // True om vi vill ta bort Titlebar + knapparna

        // Lägger till DrawPanel till Jframen
        DrawPanel panel = new DrawPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
     }
 }
