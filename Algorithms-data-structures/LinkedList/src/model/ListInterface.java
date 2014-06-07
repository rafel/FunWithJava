/******************************************************************************
 *
 *
 *
 *      LinkedList - Rafel Ridha
 *
 *      2011-05-15
 */
package model;

public interface ListInterface {
	public int size();
	public Comparable get(int index);
	public Comparable getNext();
	public boolean contains(Object o);
	public void remove();
	public void reset();
        @Override
	public String toString();
}
