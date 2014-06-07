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
public class PowerSet {
    // Vars
    char st[];

    // Const
    public PowerSet(String str) {
        st=str.toCharArray();
    }

    // Beräknar och printar ut alla delmängder
    public void print() {

        StringLinkedList list[] = new StringLinkedList[st.length];

        for (int i = 0; i < list.length; i++) {
            list[i] = new StringLinkedList();
        }


        int len = st.length;
        int elements = (int) Math.pow(2, len);
        
        for (int i = 0; i < elements; i++) {
            String str = Integer.toBinaryString(i);


            int value = str.length();
            String pset = str;
            for (int k = value; k < len; k++) {
                pset = "0" + pset;
            }
            String set ="";

            for (int j = 0; j < pset.length(); j++) {
                if (pset.charAt(j) == '1') {
                    set = set + (st[j]);
                }
            }
            if(set.length()!=0){
                list[set.length()-1].add(set);
            }
        }
        for (StringLinkedList s : list){
            System.out.println(s);
        }
    }
}

