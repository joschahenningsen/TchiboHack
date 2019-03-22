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

    public void evaluate(ArrayList<Coffee> coffees, String answer){
        int answerindex = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(answer))
                answerindex=i;
        }
        int finalAnswerindex = answerindex;
        coffees.stream().filter(c->c.rank!=-1).forEach(c->{
            if (c.values[0]!=eval[finalAnswerindex][0]&&eval[finalAnswerindex][0]!=-2)//kind of coffee
                c.rank=-1;
            if (c.values[1]==eval[finalAnswerindex][1]&&eval[finalAnswerindex][1]!=-2)//Aroma
                c.rank+=1;
            if (eval[finalAnswerindex][2]!=-2){//espresso
                if (c.values[2]==0)//not espresso
                    c.rank+=(1.0-c.values[2])*2;
                if (c.values[2]==1)//espresso
                    c.rank+=(c.values[2])*2;
            }
            if (eval[finalAnswerindex][3]!=-2){//strength
                c.rank+=(5-Math.abs(c.values[3]-eval[finalAnswerindex][3]))*0.5;
            }
            if (eval[finalAnswerindex][4]!=-2){
                if (eval[finalAnswerindex][4]==c.values[4])
                    c.rank+=2;
            }

        });
    }
}
