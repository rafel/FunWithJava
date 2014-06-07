/******************************************************************************
 *
 *
 *
 *      LinkedList - Rafel Ridha
 *
 *      2011-05-15
 * get is O(n)
 * add is O(1)
 * remove is O(n)
 * Iterator.remove is O(1)
 */
package model;

import java.util.NoSuchElementException;

public class LinkedList implements SortedListInterface {

    // Vars
    private Node top;
    private int n;
    // Const.
    public LinkedList(){
        top= null;
    }

    private boolean isEmpty() {
        return top==null;
    }

    @Override
    public String toString() {
        Node temp = top;
        StringBuilder sb = new StringBuilder();
        while(temp!=null){
            sb.append(temp.toString()).append("\n");
            temp = temp.getNext();
        }
        return sb.toString();
    }
    
    // Privat för att inte kunna manipuliera 
    private static class Node<Comparable> {

        public Comparable element;
        public Node<Comparable> next;

        public Node(Comparable element, Node<Comparable> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.element.toString();
        }

        public Node<Comparable> getNext(){
            return this.next;
        }

        public void setNext(Node<Comparable> nextN){
            next=nextN;
        }

        public Comparable getElement(){
            return this.element;
        }

    }

    public Comparable top(){
        return (Comparable) top.getElement();
    }

    public void add(Comparable e) {
        Node node = new Node(e, top);
        top = node;
        n++;
    }

    public int size() {
        return this.n;
    }

    // Gets the Node on the specified index
    private Node getNodeOn(int index) {
            if (index < 0 || index >= this.n) {
                    throw new IndexOutOfBoundsException("Index " + index + ", Size: "
                                    + this.n);
            }
            Node runner = this.top;
                    for (int i = 1; i <= index; i++) {
                            runner = runner.next;
            }
            return runner;
    }

    public Comparable get(int index) {
        return (Comparable) getNodeOn(index).getElement();
    }

    public Comparable getNext() {
        if(n==0){
            throw new NoSuchElementException();
        }
        return (Comparable) top.getNext().getElement();
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove() {
        if(!isEmpty()) {
            top = top.getNext();
            n--;
        }
        else {
            throw new IndexOutOfBoundsException("Tom");
        }
    }

    public void reset() {
       Node runner = top.next;
       while (runner.getNext() != null) {
                runner.element = null;
                runner = runner.getNext();
        }
        n = 0;
        top = null;
    }    
}