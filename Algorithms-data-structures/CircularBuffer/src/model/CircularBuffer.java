package model;

public class CircularBuffer
{
  private Integer data[]; //Här använder vi oss av en integer array, man kan såklart använda Object[]
  private int botten; //Botten elementet av kön
  private int toppen; //Toppen elementet av kön
  int N;
  //Konstruktor men antal platser som parameter
  public CircularBuffer(Integer number)
  {
    data = new Integer[number];
    botten = 0; //Både topp och botten börjar på 0
    toppen = 0;
    N=0;

  }
  //Metod får att lägga in ett värde i kön
  public boolean store(Integer value)
  {
    if (!isFull())
    {
      //Om toppen av kön överstiger slutet av arrayen, hoppa till början (Cirkulär)
      if (toppen == data.length)toppen = 0;
      data[toppen] = value;
      toppen++;
      N++;
      show();
      return true;
    } else {
         show();
      return false;
    }

  }
private boolean isEmpty(){return N==0;}
private boolean isFull(){return N == data.length;}

//Metod får att ta ut ett vÃ¤rde och läsa av värdet
  public Integer read()
  {
	  //Läs av värdet och plussa till botten
    if (!isEmpty())
    {

      int value = new Integer(data[botten]);
      data[botten]=null;
      botten++;
      N--;
      //Om botten elementet överstiger arrayens längd, lÃ¤gg botten pekaren till 0 (cirkulär)
      if (botten == data.length)
      {
        botten = 0;
      }
      show();
      return value;
    } else {
        show();
      return null;
    }
  }

//  //Metod som retunerar en vektor som sedan ska printas ut
  public Integer[] getList()
  {
      Integer[] temp =  (Integer[])data.clone();


      return  temp;
  }
  public void show()
    {
       System.out.println("----------------------");

      for(int i =0;i<data.length ;i++)
      {
          System.out.print(data[i]);
          if(i==botten)System.out.print("  <--botten");
          if(i==toppen)System.out.print("  <--nästa plats");
          System.out.println();

      }
       System.out.println("antal nummer "+N);
    }
}
