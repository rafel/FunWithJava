/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


/**
 *
 * @author Rafel
 */
public class ArrayQueue {

  // array in sorted order, from max at 0 to min at size-1
  private int maxSize;
  private Document[] queArray;
  private String resultinfo;
  private int topIndex = -1; //privat variabel med värdet -1/top värdet av stacken

  public ArrayQueue(int s) {
    maxSize = s;
    queArray = new Document[maxSize];
  }

  public boolean insert(Document doc) {
	//Kollar att den inte är full
    if(!isFull())
    {
      topIndex++; //Fyll på topIndex värdet med ett
      queArray[topIndex] = doc; //Stackens toppvärde tilldelas med värdet från item
    }
    //Annars är stacken full
    else
    {
      throw new QueueOverflowException("Push attempted on a full stack.");
    }
    return true;
  }

  public Document remove(){
  //Om stacken är inte tom så säger vi att toppen är null och räknar nedåt med vart toppen är.
        Document doc;
      if(!isEmpty()) {
           doc = queArray[0];
          queArray[0] = null; //Fult avsignera topvärdet
      for(int i =0;i<topIndex;i++)
      {
    	  queArray[i]=queArray[i+1];
      }
      queArray[topIndex]=null;
      topIndex--; //Gå ner ett steg och få ny topIndex

    }
    //Annars är stacken tom
    else
    {
      throw new QueueUnderflowException("Pop attempted on an empty stack.");
    }
      return doc;
  }

  //Metod från interfacet[StackInterface], kollar om stacken är tom
  public boolean isEmpty()
  {
	//Om toppen av stacken är -1 så är den tom
    if(topIndex == -1)
    {
    	return true;
    }
    //Annars är den inte tom
    else
    {
    	return false;
    }
  }

   //Metod från interfacet[StackInterface], kollar om stacken är full
  public boolean isFull()
  {
	//Om topIndex är lika stor som stackens storlek-1 är den full
    if(topIndex == (queArray.length - 1))
    {
    	return true;
    }
    //Annars är den inte full
    else
    {
    	return false;
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
