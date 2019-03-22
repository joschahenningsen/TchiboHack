package CoffeRank;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Question {
    int index;
    String questionStr;
    String[] answers;
    int [][]answerExclusions;
    int [][] eval;

    public Question(String questionStr, String[]answers, int[][] answerExclusions, int[][] eval){
        this.questionStr = questionStr;
        this.answers = answers;
        this.answerExclusions = answerExclusions;
        this.eval = eval;
    }

    public String getQuestionStr(){
        return questionStr;
    }

    public void evaluate(){

    }
}
