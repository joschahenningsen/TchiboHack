package CoffeRank;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class QuestionsTest {
    public static void main(String[]a){
        Question[] questions = new Question[]{
            new Question("Welches Produkt", new String[]{"Beans", "Powder"}, new int[][]{{5}, {3, 5}},
                    new BiConsumer<String, ArrayList<Coffee>>() {
                        @Override
                        public void accept(String s, ArrayList<Coffee> coffees) {
                                coffees.stream().filter(getWeight()!=-1).forEach(
                                        coffee -> {
                                            if (coffee.getKind() != s){
                                                coffee.setRank(-1);
                                            }});

                            }
                        })
                    };
        };
    }
}
