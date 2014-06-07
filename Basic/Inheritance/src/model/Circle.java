/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Arv
 */

package model;

import javax.swing.JOptionPane; // För att visa Dialoger


public class Circle extends Shape{
    
    private String outC,outH,outW; //Privata strängar som används vid denna klass

    //Metod som frågar efter färgen
    public void setColor() {
        String colorMessage = "Vilken Färg vill du använda, av dessa? Färger";
        String col = (String)JOptionPane.showInputDialog(
                                                            null,
                                                            colorMessage,
                                                            "Färger",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            super.color,
                                                            "Välj Färg:");
        if((col!=null) && (col.length()>0)){
                    outC = col;
        }
        else{
            outC = "Ingen färg vald";
        }
    }

    // Metod som frågar efter höjden
    public void setHeight() {
        String heightMessage = "Vilken höjd skall figuren ha?";
        String hei = (String)JOptionPane.showInputDialog(
                                                            null,
                                                            heightMessage,
                                                            "Höjder",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            super.height,
                                                            "Välj Höjd:");
        if((hei!=null) && (hei.length()>0)){
                    outH = hei;
        }
        else{
            outH = "Ingen Höjd vald";
        }
    }

    // Metod som frågar efter bredden
    public void setWidth() {
        String widthMessage = "Vilken bredd skall figuren ha?";
        String wid = (String)JOptionPane.showInputDialog(
                                                            null,
                                                            widthMessage,
                                                            "Bredd",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            super.width,
                                                            "Välj Bredd:");
        if((wid!=null) && (wid.length()>0)){
                    outW = wid;
        }
        else{
            outW = "Ingen Bredd vald";
        }
    }

    /*Metod som ger ut färgen*/
    public String getColor() {
        if(!outC.equals("Ingen färg vald"))
                return outC;
        else
                return "Ingen färg vald";
    }

    /*Metod som ger ut Höjden*/
    public String getHeight() {
        if(!outH.equals("Ingen Höjd vald"))
                return outH;
        else
                return "Ingen Höjd vald";
    }

    /*Metod som ger ut Bredden*/
    public String getWidth() {
        if(!outW.equals("Ingen Bredd vald"))
                return outW;
        else
                return "Ingen Bredd vald";
    }
}
