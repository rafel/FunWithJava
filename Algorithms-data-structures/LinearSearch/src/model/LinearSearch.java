/******************************************************************************
 *
 *
 *
 *      Searcher - Rafel Ridha , 900710
 *
 *      2011-04-28
 */

package model;

import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Rafel
 */
public class LinearSearch {
    // Vars
    SimpleAttributeSet wordFound,wordNormal;

    public  int search ( String[] text, String keyword,StyledDocument doc) {

        //Hittade ord
        wordFound = new SimpleAttributeSet();
        StyleConstants.setForeground(wordFound, Color.BLACK);
        StyleConstants.setBackground(wordFound, Color.RED);

        //Normala ord
        wordNormal = new SimpleAttributeSet();
        StyleConstants.setForeground(wordNormal, Color.BLACK);
        StyleConstants.setBackground(wordNormal, Color.WHITE);

        //lägga keyword i lowercase för en bättre sökning
        keyword = keyword.toLowerCase();
        int n=0;

        for(int i = 0; i<text.length;i++) {
            try {
                if(text[i].toLowerCase().equals(keyword)) {
                    //Lägga in ordet i slutet med röd bakgrund
                    doc.insertString(doc.getLength(), text[i], wordFound );
                    n++;
                }
                else{
                    //lägga till ordet i slutet med vit bakgrund
                    doc.insertString(doc.getLength(), text[i],wordNormal);
                }
                //avsluta varje ord med mellanslag
                doc.insertString(doc.getLength(), " ",wordNormal);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        
        // Antalet hittade ord
        return n;
    }
    
}