/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Comparator;

/**
 *
 * @author Rafel
 */
public class PriorityQueue {

        private static class DefaultComparator implements Comparator
    {
        public int compare (Object o1, Object o2)
        {
            return ((Comparable) o1).compareTo(o2);
        }
    }

  // array in sorted order, from max at 0 to min at size-1
  private int maxSize;
  private Document[] queArray;
  private int nItems;
  private String resultinfo;

  public PriorityQueue(int s) {
    maxSize = s;
    queArray = new Document[maxSize];
    nItems = 0;
  }

  public boolean insert(Document doc) {
      if(!isFull()){
        int i;
        if (nItems == 0)
          queArray[nItems++] = doc; // insert at 0
        else
        {
          for (i = nItems - 1; i >= 0; i--) // start at end,
          {
            if (doc.getPages() > queArray[i].getPages()) // if new item larger,
              queArray[i + 1] = queArray[i]; // shift upward
            else
              // if smaller,
              break; // done shifting
          }
          queArray[i + 1] = doc; // insert it
          nItems++;
        } // end else (nItems > 0)
        return true;
      }
        else{
            return false;
        }
  }

  public Document remove(){
    return queArray[--nItems];
  }

  public Document peekMin(){
    return queArray[nItems - 1];
  }

  public boolean isEmpty(){
    return (nItems == 0);
  }

  public boolean isFull(){
    return (nItems == maxSize);
  }

    public void printPq() {
      while (!isEmpty()) {
        String name = remove().getName();
        System.out.println(name + " "); // 10, 20, 30, 40, 50
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        if(isEmpty()){
             sb.append("###Queue is Empty### \n");
        }
        else {
            sb.append("#########PRINTED######## \n");
            while (!isEmpty()) {
                Document doc = remove();
                sb.append("Name : ");
                sb.append(doc.getName());
                sb.append(" | Pages:");
                sb.append(doc.getPages());
                sb.append("\n");
            }
            sb.append("#########PRINTED######## \n");
        }
        resultinfo = sb.toString();
        return resultinfo;
    }
}
