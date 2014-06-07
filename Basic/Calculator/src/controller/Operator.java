/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Calculator
 */

package controller;


public class Operator {
    //Utför en viss matmatisk operation
    public static String calculate(String xin, String yin, char oin){
        double mResult = 0;
        double xx1 = Double.parseDouble(xin);
        double xx2 = Double.parseDouble(yin);
        switch (oin)
        {

            case '*': mResult = xx1 * xx2; break;
            case '/': if(xx2 == 0){
                         mResult = 0;
                      }
                      else {
                         mResult = xx1 / xx2;
                      }
                         break;
            case '+': mResult = xx1 + xx2; break;
            case '-': mResult = xx1 - xx2; break;

        }
        String sum = Double.toString(mResult);
        return (sum);

    }
}
