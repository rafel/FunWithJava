/**
 *
 *
 *                      Merge Sort Circle , Rafel Ridha
 *
 *  1/4-11
 **/

package model;

/**
 *
 * @author Rafel
 */
public class MergeSort {

    private static int[] a, b;    // Hjälp array

    public static void sort(int[] a0) {
        // Vars
        a=a0;
        int n=a.length;
        
        // according to variant either/or:
        b=new int[n];    b=new int[(n+1)/2];

        // Merge Sort
        mergesort(0, n-1);
    }

    private static void mergesort(int lo, int hi) {

        // Om lika mkt antal element eller mindre
        if (lo<hi) {
            
            // Mitten
            int m=(lo+hi)/2;

            // Uppdelning
            mergesort(lo, m);
            mergesort(m+1, hi);

            // Sortering
            merge(lo, m, hi);
        }
    }

    private static void merge(int lo, int m, int hi) {

        int i, j, k;
        i=0; j=lo;
        // Kopiera första havlan av array a till hjälparrayen b
        while (j<=m)
            b[i++]=a[j++];

        i=0; k=lo;
        // Kopiera tillbaks näst-störst elemant åt gången
        while (k<j && j<=hi)
            if (b[i]<=a[j])
                a[k++]=b[i++];
            else
                a[k++]=a[j++];

        // Kopierar tillbaka kvarstående elemnt av första havlan (om det nu finns)
        while (k<j)
            a[k++]=b[i++];

    }

}