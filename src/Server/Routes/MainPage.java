package Server.Routes;

import CoffeRank.Coffee;
import CoffeRank.Question;
import java.util.ArrayList;
import java.util.Collections;

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
                new int[][]{{1,7,8},{1,7,8},{8,9},{1,2,3,4,6,8,9},{1,2,3,4,5,6,8,9}},
                new int[][]{{0, -2, -2, -2, -2, -2, -2},{1, -2, -2, -2, -2, -2, -2},{2, -2, -2, -2, -2, -2, -2},{3, -2, -2, -2, -2, -2, -2},{4, -2, -2, -2, -2, -2, -2}}, "<div onclick=\"clicked('beans');\" class=\"item\">\n" +
                "<style>.questionHeader {\n" +
                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg1.png\");" +
                "</style>" +
                "<script>setImg(0);</script>" +
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
                new String[]{"dg", "Nespresso", "Cafissimo", "qbo"},
                new int[][]{{},{},{},{}},
                new int[][]{{-2, -2, -2, -2, -2, -2, 1},{-2, -2, -2, -2, -2, -2, 2},{-2, -2, -2, -2, -2, -2, 3},{-2, -2, -2, -2, -2, -2, 4},},
                "<style>.questionHeader {\n" +
                        "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg1.png\");" +
                        "</style>" +
                        "<script>setImg(1);</script>"+
                        "            <div onclick=\"clicked('dg')\"class='item'> " +
                        "               <img class=\"icon\" src=\"img/dg.png\">\n" +
                        "                D. Gusto\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('nespresso');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/np.png\">\n" +
                        "                Nespresso\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('cafissimo');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/cm.png\">\n" +
                        "                Cafissimo\n" +
                        "            </div>\n" +
                        "            <div onclick=\"clicked('qbo');\" class=\"item\">\n" +
                        "                <img class=\"icon\" src=\"img/qbo.png\">\n" +
                        "                QBO\n" +
                        "            </div>"),
                new Question(
                        "How do you drink your Coffee?",
                        new String[]{"black", "milk"},
                        new int[][]{{4},{3}},
                        new int[][]{{-2, -2, -2, -2, -2, -2, -2},{-2, -2, -2, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg1.png\");" +
                                "</style>" +
                                "<script>setImg(2);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('black')\"class='item2'> " +
                                "               <img class=\"iconbig\" src=\"img/black.png\">\n" +
                                "                Black\n" +
                                "            </div>\n" +
                                "            <div onclick=\"clicked('milk');\" class=\"item2\">\n" +
                                "                <img class=\"iconbig\" src=\"img/milk.png\">\n" +
                                "                With milk\n" +
                                "            </div>"),
                new Question(
                        "Which Coffee do you prefer?",
                        new String[]{"Espresso", "Americano", "Crema", "Filtercoffee"},
                        new int[][]{{},{},{},{}},
                        new int[][]{{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 0, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg3.png\");" +
                                "</style>" +
                                "<script>setImg(2);</script>"+
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
                        new String[]{"milkcoffee", "Latte", "Cappuccino", "Flat"},
                        new int[][]{{},{},{},{}},
                        new int[][]{{-2, -2, 0, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg3.png\");" +
                                "</style>" +
                                "<script>setImg(2);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('milkcoffee')\"class='item3'> " +
                                "               <img class=\"icon3\" src=\"img/milkS.png\">\n" +
                                "                Café au Lait\n" +
                                "            </div>\n" +
                                "<div onclick=\"clicked('latte');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/latte.png\">\n" +
                                "                Latte Macchiato\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('cappuccino');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/milkS.png\">\n" +
                                "                Cappuccino\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('flat');\" class=\"item3\">\n" +
                                "                <img class=\"icon3\" src=\"img/flat.png\">\n" +
                                "                Flat White\n" +
                                "            </div>"),
                new Question(
                        "How strong do you like your coffee?",
                        new String[]{"1", "2", "3", "4", "5", "6"},
                        new int[][]{{},{},{},{},{},{}},
                        new int[][]{{-2, -2, 0, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2},{-2, -2, 1, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg4.png\");" +
                                "</style>" +
                                "<script>setImg(3);</script>"+
                                        "<div class='beanmaincontainer'>" +
                                        "<img src='img/coffeIcon.png' class='coffeeIcon'>" +
                                                "<div class='beanContainer'>" +
                                                    "<img id='bean1' onmouseover='beanClicked(1)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean2' onmouseover='beanClicked(2)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean3' onmouseover='beanClicked(3)' class='bean' src='img/beanOn.png'>" +
                                                    "<img id='bean4' onmouseover='beanClicked(4)' class='bean' src='img/beanOff.png'>" +
                                                    "<img id='bean5' onmouseover='beanClicked(5)' class='bean' src='img/beanOff.png'>" +
                                                    "<img id='bean6' onmouseover='beanClicked(6)' class='bean' src='img/beanOff.png'>" +
                                "</div>" +
                                "</div>"+
                                                "<input id='strength' type='hidden' value='3'>"+
                        "<div onclick='sendStrength()' class='nextbtn'>Next</div>"),
                new Question(

                        "Which flavor do you prefer?",

                        new String[]{"fruity", "nutty", "earthy"},

                        new int[][]{{},{},{}},

                        new int[][]{{-2, 1, -2, -2, -2, -2, -2},{-2, 0, -2, -2, -2, -2, -2},{-2, 2, -2, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg5.png\");" +
                                "</style>" +
                                "<script>setImg(4);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"clicked('fruity')\"class='item3'> " +
                                "               <img class=\"icon3 mr\" src=\"img/fruity.png\">\n" +
                                "                Fruity\n" +
                                "            </div>\n" +
                                "<div onclick=\"clicked('nutty');\" class=\"item3\">\n" +
                                "                <img class=\"icon3 mr\" src=\"img/nutty.png\">\n" +
                                "                Nutty\n" +
                                "            </div>" +
                                "<div onclick=\"clicked('earthy');\" class=\"item3\">\n" +
                                "                <img class=\"icon3 mr\" src=\"img/earthy.png\">\n" +
                                "                Earthy\n" +
                                "            </div>"),
                new Question(
                        "Do you want decaffeinated coffee?",
                        new String[]{"yes", "no"},
                        new int[][]{{},{}},
                        new int[][]{{-2, -2, -2, -2, -2, 1, -2},{-2, -2, -2, -2, -2, 0, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg6.png\");" +
                                "</style>" +
                                "<script>setImg(5);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"selected('decaf')\"class='item2 no' id='decaf' value='no'> " +
                                "               <img class=\"iconbig\" src=\"img/decaf.png\">\n" +
                                "                Decaffeinated\n" +
                                "            </div>\n" +
                                "<div onclick='send(\"decaf\")' class='nextbtn'>Next</div>"),
                new Question(
                        "Do you want your Coffee to be Fair Trade?",
                        new String[]{"yes", "no"},
                        new int[][]{{},{}},
                        new int[][]{{-2, -2, -2, -2, 1, -2, -2},{-2, -2, -2, -2, 0, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg6.png\");" +
                                "</style>" +
                                "<script>setImg(5);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"selected('fairtrade')\"class='item2 no' id='fairtrade' value='no'>" +
                                "               <img class=\"iconbig\" src=\"img/fairtrade.png\">\n" +
                                "                Fairtrade\n" +
                                "            </div>\n" +
                                "<div onclick='send(\"fairtrade\")' class='nextbtn'>Next</div>"),
                new Question(
                        "Would you like any extras?",
                        new String[]{"decaf", "fairtrade", "decaffairtrade", ""},
                        new int[][]{{},{},{},{}},
                        new int[][]{{-2, -2, -2, -2, -2, 1, -2},{-2, -2, -2, -2, 1, -2, -2},{-2, -2, -2, -2, 1, 1, -2},{-2, -2, -2, -2, -2, -2, -2}},
                        "<style>.questionHeader {\n" +
                                "    background-image: linear-gradient(to bottom, #ffffff, rgba(0,0,0,0.5)),url(\"/img/bg6.png\");" +
                                "</style>" +
                                "<script>setImg(5);</script>"+
                        "<style>.questionMain {grid-template-columns: auto;}</style>" +
                                "<div onclick=\"selected('decaf')\" class=\"item2 no\" id=\"decaf\" value=\"no\">" +
                                "<img class=\"iconbig\" src=\"img/decaf.png\">\n" +
                                "                Decaffeinated\n" +
                                "            </div>"+
                                "<div onclick=\"selected('fairtrade')\" class=\"item2 no\" id=\"fairtrade\" value=\"no\">" +
                                        "<img class=\"iconbig\" src=\"img/fairtrade.png\">\n" +
                                "                Fairtrade\n" +
                                "            </div>"+
                                "<div onclick='checkandsend()' class='nextbtn'>Next</div>"
                        )
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
                vars.put("%options", questions[0].getHtml().replaceAll("\\$","\\\\\\$"));
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

            if (newremaining.length>1)
                setBody(questions[newremaining[0]].getQuestionStr() + "---" + questions[newremaining[0]].getHtml());
            else{
                Collections.sort(coffees, (c1, c2)->{
                    if(c1.getRank()>c2.getRank())
                        return -1;
                    if(c1.getRank()<c2.getRank())
                        return 1;
                    return 0;
                });

                System.out.println("Top 5:");
                coffees.stream().limit(5).forEach(c->System.out.println(c));

                setTemplateFile("html/resultpage.html");
                setBody(null);

                StringBuilder content=new StringBuilder();

                coffees.stream().filter(c->c.getRank()>=0).limit(3).forEach(c->content.append(
                        "<a href='"+c.getUrl()+"'><div class=\"result\"><img class='productimage' src=\""+c.getImage()+"\">" +
                                "<h2 class='imageCapture'>"+c.getName()+"</h2>" +
                                "<h4 class='description'>"+c.getDescription()+"</h4>" +
                                "<h3 class='price'>"+c.getPrice()+" €</h3>" +
                                "</div></a>\n"));
                StringBuilder buttons=new StringBuilder();
                buttons.append("<div class='freeSample'>Get your free samples</div>");
                buttons.append("<a href='https://www.tchibo.de/filialfinder'><div class='finder'>Try in the store <i class=\"fas fa-map-marker-alt\"></i></div></a>");
                vars.put("%result", content.toString());
                vars.put("%buttons", buttons.toString());


                userlists.remove(requestData.getCookie("session"));
            }
        }
    }
}
