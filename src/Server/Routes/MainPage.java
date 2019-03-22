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
                new int[][]{{1},{1},{8,9},{1,2,3,4,6,7,8,9},{1,2,3,4,5,6,8,9}},
                new int[][]{{0, -2, -2, -2, -2, -2, -2},{1, -2, -2, -2, -2, -2, -2},{2, -2, -2, -2, -2, -2, -2},{3, -2, -2, -2, -2, -2, -2},{4, -2, -2, -2, -2, -2, -2}}, "<div onclick=\"clicked('beans');\" class=\"item\">\n" +
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
                "Which machine do you use?",
                new String[]{"Dolce Gusto", "Nespresso", "Cafissimo", "QBO"},
                new int[][]{{},{},{},{}},
                new int[][]{{-2, -2, -2, -2, -2, -2, 1},{-2, -2, -2, -2, -2, -2, 2},{-2, -2, -2, -2, -2, -2, 3},{-2, -2, -2, -2, -2, -2, 4},},
                "            <div onclick=\"clicked('dg')\"class='item'> " +
                        "               <img class=\"icon\" src=\"img/capsule.png\">\n" +
                        "                Dolce Gusto\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('nespresso');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/capsule.png\">\n" +
                        "                Nespresso\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('cafissimo');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/capsule.png\">\n" +
                        "                Cafissimo\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('qbo');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/capsule.png\">\n" +
                        "                QBO\n" +
                        "            </div>"),
                new Question(
                        "How do you drink your Coffee?",
                        new String[]{"black", "milk"},
                        new int[][]{{4},{3}},
                        new int[][]{{-2, -2, -2, -2, -2, -2, -2},{-2, -2, -2, -2, -2, -2, -2}},
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('black')\"class='item2'> " +
                                "               <img class=\"icon\" src=\"img/black.png\">\n" +
                                "                Black\n" +
                                "            </div>\n" +
                                "            <div onclick=\"clicked('milk');\" class=\"item2\">\n" +
                                "                <img class=\"icon\" src=\"img/milk.png\">\n" +
                                "                With milk\n" +
                                "            </div>"),
                new Question(
                        "Which Coffee do you prefer?",
                        new String[]{"Espresso", "Americano", "Crema", "Filtercoffee"},
                        new int[][]{{},{},{},{}},
                        new int[][]{{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 0, -2, -2, -2, -2}},
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('espresso')\"class='item3'> " +
                                "               <img class=\"icon3\" src=\"img/espresso.png\">\n" +
                                "                Espresso\n" +
                                "            </div>\n" +
                                "<div onclick=\"clicked('americano');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/americano.png\">\n" +
                                "                Americano\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('crema');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/americano.png\">\n" +
                                "                Cafe Crema\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('filtercoffee');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/filter.png\">\n" +
                                "                Filtercoffee\n" +
                                "            </div>"),
                new Question(
                        "Which Coffee do you prefer?",
                        new String[]{"milkcoffee", "Late", "Cappuccino"},
                        new int[][]{{},{},{}},
                        new int[][]{{-2, -2, 0, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2}},
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('milkcoffee')\"class='item3'> " +
                                "               <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Café au Lait\n" +
                                "            </div>\n" +
                                "<div onclick=\"clicked('late');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Late Macchiato\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('cappuccino');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Cappuccino\n" +
                                "            </div>"),
                new Question(
                        "How strong do you like your coffee?",
                        new String[]{"1", "2", "3", "4", "5", "6"},
                        new int[][]{{},{},{},{},{},{}},
                        new int[][]{{-2, -2, 0, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2}},
                                        "<div class='beanmaincontainer'>" +
                                        "<img src='img/coffeIcon.png' class='coffeeIcon'>" +
                                                "<div class='beanContainer'>" +
                                                    "<img id='bean1' onmouseover='beanClicked(1)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean2' onmouseover='beanClicked(2)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean3' onmouseover='beanClicked(3)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean4' onmouseover='beanClicked(4)' class='bean' src='img/beanOff.png'>" +
                                                    "<img id='bean5' onmouseover='beanClicked(5)' class='bean' src='img/beanOff.png'>" +
                                                    "<img id='bean6' onmouseover='beanClicked(6)' class='bean' src='img/beanOff.png'>" +
                                "" +
                                "</div>" +
                                                "<div class='nextbtn'>Next</div>"+
                                "</div>"),
                new Question(
                        "Which flavor do you prefer?",
                        new String[]{"fruity", "nutty", "earthy"},
                        new int[][]{{},{},{}},
                        new int[][]{{-2, 1, -2, -2, -2, -2, -2},{-2, 0, -2, -2, -2, -2, -2},{-2, 2, -2, -2, -2, -2, -2}},
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('fruity')\"class='item3'> " +
                                "               <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Fruity\n" +
                                "            </div>\n" +
                                "<div onclick=\"clicked('nutty');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Nutty\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('earthy');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/milk.png\">\n" +
                                "                Earthy\n" +
                                "            </div>"),
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
                databases.get(0).query("Select id,name,url,price,image,description,type,aroma,espresso,strength,fairtrade,decaf,capsule Where '1'='1'").forEach(
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
                if (remainingQs[i]==currentQuestion){
                    remove++;
                    remainingQs[i]=-1;
                }
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
            remainingQuestions.put(ssid, newremaining);

            coffees.forEach(coffee -> System.out.println(coffee.getRank()));

            setBody(questions[newremaining[0]].getQuestionStr()+"---"+questions[newremaining[0]].getHtml());
        }
    }
}
