package Server.Routes;

import CoffeRank.Coffee;
import CoffeRank.Question;
import Server.Database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        Question[] questions = {new Question(
                "Which kind of coffee?",
                new String[]{"Pads", "Beans", "Powder", "Capsules", "Instant"},
                new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}},
                new int[][]{};
                )
        };
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

        if (requestData.hasCookie("session")&&userlists.containsKey(requestData.getCookie("session"))){
            ArrayList<Coffee>coffees=userlists.get(requestData.getCookie("session"));
        }else {
            String id = (Math.random()*100000)+"";
            setCookie("session", id);

            ArrayList<Coffee> coffees = new ArrayList<>();
            coffees.add(new Coffee());
            userlists.put(id, coffees);
        }


        vars.put("%content", content);
    }
}
