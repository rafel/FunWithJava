/******************************************************************************
 *
 *
 *
 *      Searcher - Rafel Ridha , 900710
 *
 *      2011-04-28
 */

package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


/**
 *
 * @author Rafel
 */
public class GetUrlText {

    public static String getUrlText(String urlreq) throws IOException{

    // Create a URL for the desired page
    URL url = new URL(urlreq);

    StringBuilder st = new StringBuilder();

    // Read all the text returned by the server
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"ISO-8859-1"));
    String str;
    boolean copy = false;
    while ((str = in.readLine()) != null) {

        if(str.equalsIgnoreCase("</body>")){
            copy = false;
        }
        if(copy){
                st.append(str).append("\n");
        }
        if(str.equalsIgnoreCase("<body>")){
            copy = true;
        }
    }
    in.close();

    // Return
    str = st.toString();
    return str;

    }

}
