/******************************************************************************
 *
 *
 *
 *      PowerSet - Rafel Ridha
 *
 *      2011-05-20
 */

package model;

/**
 *
 * @author Rafel
 */
public class StringLinkedList {

    // Vars
    private Node top;
    
    // Const.
    public StringLinkedList(){
        top= null;
    }
    
    // För utprint
    @Override
    public String toString() {
        Node temp = top;
        String str ="";
        while(temp!=null){
            str= str +" {"+ temp.getElement()+ "},";
            temp = temp.getNext();
        }
        return str;
    }

    // Privat för att inte kunna manipuliera
    private static class Node<String> {

        private String element;
        private Node<String> next;

        public Node(String element, Node<String> next) {
            this.element = element;
            this.next = next;
        }
        public Node<String> getNext(){
            return this.next;
        }

        public void setNext(Node<String> nextN){
            next=nextN;
        }

        public String getElement(){
            return this.element;
        }

    }

    public Comparable top(){
        return (Comparable) top.getElement();
    }

    public void add(String e) {
        Node node = new Node(e, top);
        top = node;
    }
}
