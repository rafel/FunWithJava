/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Arv
 */

package controller;

import javax.swing.JOptionPane; // För att visa Dialoger
import model.Circle;
import model.Square;
import model.Triangle;


public class Handler {

    //Metoden visar en dialog som frågar efter ifall man vill skapa en cirkel
    public static void askCircle(Circle c){
        String message = "Vill du skapa en cirkel?";
        String message2 = "Ingen Cirkel skapad!";
        int val;
        
        val = JOptionPane.showConfirmDialog(
                        null,message,"Val",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                                            );
	if(val==0) {
            Creator.createCircle(c);
        }
        else{
            System.out.println(message2);
        }
    }
    
    //Metoden visar en dialog som frågar efter ifall man vill skapa en Kvadrat
    public static void askSquare(Square s){
        String message = "Vill du skapa en kvadrat?";
        String message2 = "Ingen Kvadrat skapad!";
        int val;

        val = JOptionPane.showConfirmDialog(
                        null,message,"Val",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                                            );
	if(val==0) {
            Creator.createSquare(s);
        }
        else{
            System.out.println(message2);
        }
    }
    
    //Metoden visar en dialog som frågar efter ifall man vill skapa en Triangel
    public static void askTriangle(Triangle t){
        String message = "Vill du skapa en triangel?";
        String message2 = "Ingen Triangel skapad!";
        int val;

        val = JOptionPane.showConfirmDialog(
                        null,message,"Val",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                                            );
	if(val==0) {
            Creator.createTriangle(t);
        }
        else{
            System.out.println(message2);
        }
    }
}
