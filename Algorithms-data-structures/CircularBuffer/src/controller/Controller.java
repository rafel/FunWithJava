/******************************************************************************
 *
 *
 *
 *      CircularBuffer - Rafel Ridha , 900710
 *
 *      2011-05-10
 */
package controller;

import model.CircularBuffer;


/**
 *
 * @author Rafel
 */
public class Controller {

   CircularBuffer buffer;



   public void setBuffer(Integer size){
       this.buffer = new CircularBuffer(size);
   }

   public boolean store(Integer value){
       boolean result = buffer.store(value);
       return result;
   }

   public Integer read(){
       Integer result = buffer.read();
       return result;
   }

    //Metod som retunerar en vektor som sedan ska printas ut
    public Integer[] getList() {
      Integer[] temp =  buffer.getList();
      return  temp;
    }

}
