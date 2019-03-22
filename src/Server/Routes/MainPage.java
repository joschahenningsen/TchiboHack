package Server.Routes;

import CoffeRank.Coffee;
import CoffeRank.Question;
import Server.Database.Database;
import Server.Exceptions.InvalidRequestException;

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
                new String[]{"Beans", "Powder", "Capsules", "Pads", "Instant"},
                new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}},
                new int[][]{{0, -2, -2, -2, -2, -2},{1, -2, -2, -2, -2, -2},{2, -2, -2, -2, -2, -2},{3, -2, -2, -2, -2, -2},{4, -2, -2, -2, -2, -2}}, "<div onclick=\"clicked('beans');\" class=\"item\">\n" +
                "                <img class=\"icon\" src=\"img/beans.png\">\n" +
                "                Beans\n" +
                "            </div>\n" +
                "            <div onclick=\"clicked('powder');\" class=\"item\">\n" +
                "                <img class=\"icon\" src=\"img/powder.png\">\n" +
                "                Powder\n" +
                "            </div>\n" +
                "            <div onclick=\"clicked('capsules');\" class=\"item\">\n" +
                "                <img class=\"icon\" src=\"img/capsules.png\">\n" +
                "                Capsules\n" +
                "            </div>\n" +
                "            <div onclick=\"clicked('pads');\" class=\"item\">\n" +
                "                <img class=\"icon\" src=\"img/pads.png\">\n" +
                "                Pads\n" +
                "            </div>\n" +
                "            <div onclick=\"clicked('instant');\" class=\"item\">\n" +
                "                <img class=\"icon\" src=\"img/Instant.png\">\n" +
                "                Instant\n" +
                "            </div>"),new Question(
                "second question?",
                new String[]{"Pads", "Beans", "Powder", "Capsules", "Instant"},
                new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}},
                new int[][]{{1,0,0,1},{1,0,0,1}}, "Number two!")
        };
        ArrayList<Coffee> coffees=null;

        if (requestData.POST("answer")==null) {
            setTemplateFile("html/index.html");
            vars.put("%title", "Tchibo | Coffe For Everyone!");
            if (requestData.hasCookie("session") && userlists.containsKey(requestData.getCookie("session"))) {
                coffees = userlists.get(requestData.getCookie("session"));
                int qnum = remainingQuestions.get(requestData.getCookie("session"))[0];
                vars.put("%questiontitle", questions[qnum].getQuestionStr());
                vars.put("%options", questions[qnum].getHtml());
            } else {
                String id = ((Math.random() * 100000) + "").replaceAll("\\.", "");
                setCookie("session", id);
                coffees = new ArrayList<>();
                remainingQuestions.put(id, new int[]{0,1,2,3,4,5,6,7,8,9,10});
                ArrayList<Coffee> finalCoffees = coffees;
                databases.get(0).query("Select id,name,url,price,image,description,type,aroma,espresso,strength,fairtrade,decaf Where '1'='1'").forEach(
                        row -> finalCoffees.add(
                                new Coffee(row[0], row[1], row[2], row[3], row[4], row[5],
                                        Integer.parseInt(row[6]),
                                        Integer.parseInt(row[7]),
                                        Integer.parseInt(row[8]),
                                        Integer.parseInt(row[9]),
                                        Integer.parseInt(row[10]),
                                        Integer.parseInt(row[11]),
                                        Integer.parseInt(row[12]))));
                userlists.put(id, coffees);
                vars.put("%questiontitle", questions[0].getQuestionStr());
                vars.put("%options", questions[0].getHtml());
            }
        }else {
            int currentQuestion = remainingQuestions.get(requestData.getCookie("session"))[0];
            String answer = requestData.POST("answer");
            String ssid = requestData.getCookie("session");
            int[] remainingQs=remainingQuestions.get(ssid);

            coffees = userlists.get(ssid);
            questions[currentQuestion].evaluate(coffees, answer);

            int[] removeanswers=questions[currentQuestion].getExclusion();
            int remove = 0;
            for (int i = 0; i < remainingQs.length; i++) {
                for (int j = 0; j < removeanswers.length; j++) {
                    if (remainingQs[i]==removeanswers[j]){
                        remove++;
                        remainingQs[i]=-1;
                    }
                }
            }
            int[]newremaining=new int[remainingQs.length-remove];
            int index=0;
            for (int i = 0; i < remainingQs.length; i++) {
                if (remainingQs[i]!=-1)
                    newremaining[index++]=remainingQs[i];
            }

            coffees.forEach(coffee -> System.out.println(coffee.getRank()));
        }
    }
}
