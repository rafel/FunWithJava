/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Grafik
 */

package view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

// Panel med kvadrater
class DrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        
        int co_x = 25;  // Position x
        int co_y = 25;  // Position y
        int no =    8;  // Antal rader & kolumner
        int size = 80;  //Storlek per kvadrat

        boolean flag=false;
        setBackground(new Color(80,40,40));
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(int j=0;j<no;j++){
            // Om jämna tal Svartfärg i första raden
            if(j%2==0) {
                flag=false;
            }
            // Om udda tal Vitfärg i första raden
            else if(j%2==1) {
                flag=true;
            }
            //Start positionen
            co_x=25;

            // Vit eller svart box nästa
            for(int i=0;i<no;i++) {
                if(flag==true) {
                    g2.setPaint(Color.WHITE);
                    g2.fill(new Rectangle2D.Double(co_x,co_y,size,size));
                    flag=false;
                }
                else {
                    g2.setPaint(Color.BLACK);
                    g2.fill(new Rectangle2D.Double(co_x,co_y,size,size));
                    flag=true;
                }
                // Flyttar nästa box till rätt plats
                co_x+=size;
            }
            // Flyttar boxarna till rätt rad
            co_y+=size;
        }
    }
}
