/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Klasshierarki
 */

package model;
import javax.swing.JOptionPane;

public class Actions {    
    /*Metoden myBil*/
    public static void MyBil(Bil b) {
        String message;
        int val;
        message = "Vill du producera en bil?";
        val = JOptionPane.showConfirmDialog(
                        null,message,"Val",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                                            );
        if(val==0) { //Om Ja, då körs nedan.
            b.setColor();
            b.setMarke();
            b.setGear();
            b.setVikt(b.randomVikt());

            if(b.getColor().equals("Ingen färg vald") ||
               b.getMarke().equals("Inget märke valt") ||
               b.getGear().equals("Ingen växellåda vald")){

                System.out.println("Ingen bil kommer bli producerad, inga val valda eller ett felaktigt val skett");
            }
            else{
                System.out.println("Bil: Din "+ b.getColor() + "a "+ b.getMarke()+" är " + b.getGear() +
                        " Och väger " + b.getVikt() + "KG"
                        );
            }
        }
        else { //Annars ingen bil produceras
            System.out.println("Ingen bil kommer att produceras");
        }
    }
    /*Metoden myBil*/
    public static void MyMC(Motorcykel c) {
        String message;
        int val;
        message = "Vill du producera en motorcykel?";
        val = JOptionPane.showConfirmDialog(
                        null,message,"Val",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                                            );
        if(val==0) { //Om Ja, då körs nedan.
            c.setColor();
            c.setMarke();
            c.setGear();
            c.setVikt(c.randomVikt());

            if(c.getColor().equals("Ingen färg vald") ||
               c.getMarke().equals("Inget märke valt") ||
               c.getGear().equals("Ingen växellåda vald")){

                System.out.println("Ingen motorcykel kommer bli producerad, inga val valda eller ett felaktigt val skett");
            }
            else{
                System.out.println("Motocykel: Din "+ c.getColor() + "a "+ c.getMarke()+" är " + c.getGear() +
                        " Och väger " + c.getVikt() + "KG"
                        );
            }
        }
        else { //Annars ingen bil produceras
            System.out.println("Ingen motocykel kommer att produceras");
        }
    }
}