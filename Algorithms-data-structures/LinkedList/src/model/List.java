/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Rafel
 */
public class List {

    private Object list[];
    private int top;
    private int size;

    public List(int size) {
        this.size = size;
        list= new Object[size];
        top = 0;
    }

    public void add(Object o){
        if(!isFull()){
            list[top] = o;
            top++;
        }
     else {
        //System.out.println("Listan är full!");
        }
    }

    public boolean isFull(){
        return top==size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = list.length-1; i >= 0 ; i--) {
            sb.append(list[i].getName()).append("\n");
        }
        return sb.toString();
    }




}
