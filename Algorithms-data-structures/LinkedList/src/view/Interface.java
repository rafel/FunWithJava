/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.LinkedList;
import model.List;
import model.Object;

/**
 *
 * @author Rafel
 */
public class Interface {

    public static void start(){
        LinkedList ll = new LinkedList();
        List l = new List(4);
        l.add(new Object("Object1"));
        l.add(new Object("Object2"));
        l.add(new Object("Object3"));
        l.add(new Object("Object4"));
        l.add(new Object("Object5"));
        ll.add(new Object("Object1"));
        ll.add(new Object("Object2"));
        ll.add(new Object("Object3"));
        ll.add(new Object("Object4"));
        ll.add(new Object("Object5"));
        System.out.println("Tredje elmentet från toppen : "+ll.get(2));
        System.out.println(ll);
        System.out.println(ll.size());
        ll.reset();
        ll.add(new Object("Object1"));
        ll.add(new Object("Object2"));
        System.out.println(ll);
        System.out.println(ll.size());
    }

}
