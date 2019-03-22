package CoffeRank;

import java.util.ArrayList;

public class Question {
    int index;
    String questionStr;
    String[] answers;
    int [][]answerExclusions;
    int [][] eval;
    private String html;
    private int answerindex;

    public Question(String questionStr, String[]answers, int[][] answerExclusions, int[][] eval, String html){
        this.questionStr = questionStr;
        this.answers = answers;
        this.answerExclusions = answerExclusions;
        this.eval = eval;
        this.html = html;
    }

    public int getAnswerindex(){
        return answerindex;
    }

    public int[] getExclusion(){
        return answerExclusions[answerindex];
    }

    public String getQuestionStr(){
        return questionStr;
    }

    public void evaluate(ArrayList<Coffee> coffees, String answer){
        int answerindex = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].toUpperCase().equals(answer.toUpperCase()))
                answerindex=i;
        }
        this.answerindex=answerindex;
        int finalAnswerindex = answerindex;
        coffees.stream().filter(c->c.rank!=-1).forEach(c->{
            if (c.values[0]!=eval[finalAnswerindex][0]&&eval[finalAnswerindex][0]!=-2)//kind of coffee
                c.rank=-1;
            if (c.values[1]==eval[finalAnswerindex][1]&&eval[finalAnswerindex][1]!=-2)//Aroma
                c.rank+=1;
            if (eval[finalAnswerindex][2]!=-2){//espresso
                if (c.values[2]==eval[finalAnswerindex][2])
                    c.rank+=2;
            }
            if (eval[finalAnswerindex][3]!=-2){//strength
                c.rank+=(5-Math.abs(c.values[3]-eval[finalAnswerindex][3]))*0.5;
            }
            if (eval[finalAnswerindex][4]!=-2){
                if (eval[finalAnswerindex][4]==c.values[4])
                    c.rank+=2;
            }
            if (eval[finalAnswerindex][5]!=-2){
                if (eval[finalAnswerindex][5]!=c.values[5])
                    c.rank=-1;
            }
            if (eval[finalAnswerindex][6]!=-2){
                if (eval[finalAnswerindex][6]!=c.values[6])
                    c.rank-=1;
            }

        });
    }

    public String getHtml() {
        return html;
    }
}
