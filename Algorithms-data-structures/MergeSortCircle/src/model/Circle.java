/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package model;
import java.awt.Color;
/**
 *
 * @author Rafel
 */
public class Circle {

    // Vars
    Color colour;
    int size;

    public Circle(int sizeAndColour) {
        int sizetemp;
        sizetemp = (int)sizeAndColour/10;

        // Storleken
        this.size = sizetemp * 10;

        // Färgen
        int color = sizeAndColour-this.size;
        if (color ==1)
        {this.colour = Color.yellow;}
        else if(color==2){this.colour = Color.blue;}
        else if(color==3){this.colour = Color.red;}
    }

    // Return färg
    public Color getColor() {
        return colour;
    }

    // Return storlek
    public int getSize() {
        return size;
    }   

}
