package CoffeRank;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Question {
    int index;
    String questionStr;
    String[] answers;
    int [][]answerExclusions;
    Consumer<ArrayList<Coffee>> consumer;

    public Question(String questionStr, String[]answers, int[][] answerExclusions, BiConsumer<String, ArrayList<Coffee>> consumer){
        this.questionStr = questionStr;
        this.answers = answers;
        this.answerExclusions = answerExclusions;
    }

    public String getQuestionStr(){
        return questionStr;
    }
}
