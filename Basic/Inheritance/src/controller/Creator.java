/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Arv
 */

package controller;

import model.Circle;
import model.Square;
import model.Triangle;


public class Creator {
    
    //Metod som skapar en cirkel och skriver ut dess egenskaper
    public static void createCircle(Circle c){
        c.setColor();
        String color = c.getColor();
        c.setWidth();
        String width = c.getWidth();
        c.setHeight();
        String height = c.getHeight();
        System.out.print("En " + color + " Cirkel har Skapats med ");
        System.out.println("Höjd: " + height + " och Bredden: " + width);
    }

    //Metod som skapar en kvadrat och skriver ut dess egenskaper
    public static void createSquare(Square s){
        s.setColor();
        String color = s.getColor();
        s.setWidth();
        String width = s.getWidth();
        s.setHeight();
        String height = s.getHeight();
        System.out.print("En " + color + " Kvadrat har Skapats med ");
        System.out.println("Höjd: " + height + " och Bredden: " + width);
    }

    //Metod som skapar en triangel och skriver ut dess egenskaper
    public static void createTriangle(Triangle t){
        t.setColor();
        String color = t.getColor();
        t.setWidth();
        String width = t.getWidth();
        t.setHeight();
        String height = t.getHeight();
        System.out.print("En " + color + " Triangel har Skapats med ");
        System.out.println("Höjd: " + height + " och Bredden: " + width);

    }
}
