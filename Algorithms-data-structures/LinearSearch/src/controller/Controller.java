/******************************************************************************
 *
 *
 *
 *      Searcher - Rafel Ridha , 900710
 *
 *      2011-04-28
 */

package controller;
import java.io.IOException;
import javax.swing.text.StyledDocument;
import model.GetUrlText;
import model.LinearSearch;

/**
 *
 * @author Rafel
 */
public class Controller {

    LinearSearch lin = new LinearSearch();
    public static void search(){
        
    }

    public String getUrl(String url) throws IOException{
        String ret;
        ret = GetUrlText.getUrlText(url);
        return ret;
    }

    public int search ( String[] text, String keyword,StyledDocument doc){
        return lin.search(text,keyword,doc);
    }

}
