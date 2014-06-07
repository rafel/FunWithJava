/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Klasshierarki
 */

package model;


import javax.swing.JOptionPane;

public class Bil extends Fordon{
    String outC,outM,outG,message;
    
    /*De generiska metoder som implementeras från förälder klassen fordon*/
    void setColor(){
        message = "Vilken Färg vill du använda, av dessa?";
        String color;
        
        color = (String)JOptionPane.showInputDialog(
                null,message,"Färger",JOptionPane.PLAIN_MESSAGE,null,super.farg,"Välj:"
                );
        if((color!=null) && (color.length()>0)){
            outC = color;
        }
        else{
            outC = "Ingen färg vald";
        }
    }
    //Hämtar bilens färg
    String getColor() {
        if(!outC.equals("Ingen färg vald")){
            return outC;
        }
        else{
            return "Ingen färg vald";
        }
    }
    /*De generiska metoder som implementeras från förälder klassen fordon*/
    void setMarke(){
        message = "Vilket märke ska bilen ha?";
        String market;

        market = (String)JOptionPane.showInputDialog(
                null,message,"Märken",JOptionPane.PLAIN_MESSAGE,null,super.marke,"Välj:"
                );
        if((market!=null) && (market.length()>0)){
            outM = market;
        }
        else{
            outM = "Inget märke valt";
        }
    }
    //Hämtar bilens Märke
    String getMarke() {
        if(!outM.equals("Inget märke valt")){
            return outM;
        }
        else{
            return "Inget märke valt";
        }
    }
    /*De generiska metoder som implementeras från förälder klassen fordon*/
    void setGear(){
        message = "Vilken växellåda ska bilen ha?";
        String gear;

        gear = (String)JOptionPane.showInputDialog(
                null,message,"Lådor",JOptionPane.PLAIN_MESSAGE,null,super.lada,"Välj:"
                );
        if((gear!=null) && (gear.length()>0)){
            outG = gear;
        }
        else{
            outG = "Inget växellåda vald";
        }
    }
    //Hämtar bilens Växellåda
    String getGear() {
        if(!outG.equals("Inget växellåda vald")){
            return outG;
        }
        else{
            return "Inget växellåda vald";
        }
    }

    //Överskuggar metoden
    @Override
    void setVikt(double vikt){
        super.vikt = vikt;
    }
    
    /*Metod som ger vikten av fordonet*/
    double getVikt() {
        return super.vikt;
    }
    
    /*Metod som ger bilar en vikt mellan 1200-2000*/
    double randomVikt() {
        super.vikt = (int) (2000 * Math.random() + 1200);
        return super.vikt;
    }
}