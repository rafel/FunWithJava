/******************************************************************************
 *
 *
 *
 *      Euklides algoritm - Rafel Ridha , 900710
 *
 *      2011-03-23
 */

package startup;

/**
 *
 * @author Rafel
 */
public class Main {
    static int x = 0;
    public static void main(String[] args) {
        int a,b,commun,commun2;
        a = 2147449999;        // Första heltalet
        b = 1999999029;        // Andra heltalet
        
        commun  = recursiveEuklides(a, b);   // Största gemensamma delare
        commun2 = euklides(a, b);            // Största gemensamma delare

        // Utprint av resultaten
        System.out.println("-----Resultatet-----");
        System.out.println("recursiveEuklides(" + a + ", " + b + ") = " + commun);
        System.out.println("euklides(" + a + ", " + b + ") = " + commun2);
    }

    // Rekursiv implementation
    public static int recursiveEuklides(int a, int b) {        
        if(b==0){   // Basfallet.
            return a;
        }
        else{
            int c;
            c = a % b;      // Resten av a / b
            a = b; b = c;            
            a = recursiveEuklides(a, b);    //Rekursivt anrop
            return a;
        }
    }

    // Icke rekursiv implementation
    public static int euklides(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
