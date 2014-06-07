/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Calculator
 */

package controller;

public class Handler{

    // Kontrollerar att Stringen endast består av siffror
    public static boolean isNumber(String s) {

        try {
            Double.parseDouble(s);
        }
        
    // Kollar om Stringen innehöll det som krävs för att konvertera till nummer
        catch (NumberFormatException x) {
            return false;
        }
            return true;
    }

    // Kontrollerar att Stringen innehåller en viss längd
    public static boolean isToLong(String xin, int yin){
        if (xin.length() >= yin){
            return true;
        }
        else{
            return false;
        }
    }
}