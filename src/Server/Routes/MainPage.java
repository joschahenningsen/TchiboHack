package Server.Routes;

import Server.Database.Database;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sample Route, inspire yourself
 * @author Joscha Henningsen
 */
public class MainPage extends Route{

    /**
     * This is important! If you don't call setUrl in the constructor of your Routes, the page can't be accessed directly.
     */
    public MainPage(){
        setUrl("/");
    }


    /**
     * sets everything your page does
     */
    @Override
    public void setupPage() {
        String[][] question = {new String[]{"Beans","Powder", "Pads", "Capsules"}};
        setTemplateFile("html/index.html");

        vars.put("%title", "It Works!");
        vars.put("%page0", "It Works!");
        vars.put("%page0link", "/");
        vars.put("%page1link", "get-started");
        vars.put("%page1", "Get started");
        vars.put("%page2link", "https://github.com/joschahenningsen/Erie-Webserver");
        vars.put("%page2", "About");
        vars.put("%page0active", "active");
        String content = "";

        Database questions = databases.get(0);
        if (requestData.hasCookie("session")){
            ArrayList<String[]> res = questions.query("Select state Where id='"+requestData.getCookie("session")+"'");
            if (res.size()!=0){
                int status = Integer.parseInt(res.get(0)[0]);
                content+=Arrays.toString(question[status]);
            }
        }else {
            content += "jetzt starten!";
            String id = (Math.random()*100000)+"";
            setCookie("session", id);
            questions.query("Insert '"+id+"', 0");
        }


        vars.put("%content", content);
    }
}
