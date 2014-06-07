/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Interface
 */

package controller;


//Hanterare som håller koll så att vi använder samma metod fastän vi byter
//Djuret
public class Handler {
    
    Player inter;

    public Handler(Player inter){
        this.inter = inter;
    }

    //Byter djuret för spelaren
    public void byt(Player inter){
        this.inter = inter;
    }

    // Spelaren
    public void play(){
        inter.play();
    }
}
