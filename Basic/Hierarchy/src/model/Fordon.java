/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Klasshierarki
 */

package model;

public abstract class Fordon {
    double vikt;
    Object[] marke = {"BMW","Mercedes","Volvo","Audi","Volkswagen"}; //Listar ut valbara märken
    Object[] farg = {"Blå","Röd","Grön","Orange","Vit","Svart"}; //Listar ut valbara färger
    Object[] lada = {"Automat","Manuell"}; //Listar ut valbara växlar
    abstract void setColor();  //Abstract metod som måste finnas med vid ärvning
    abstract void setMarke();  //Abstract metod som måste finnas med vid ärvning
    abstract void setGear();   //Abstract metod som måste finnas med vid ärvning
    void setVikt(double vikt){
        
    }

}
