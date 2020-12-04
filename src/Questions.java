import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 * Class Questions contains a question, the answers for the question and the right answer.
 * It also contains a boolean variable that stores either the question has already been asked or not.
 * this class will be used to create Questions objects with the data from the file that then will be stored
 * in an ArrayList, so that they can be randomly asked.
 */

public class Questions {
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD; //sto mellon aftin tha thn svisoyme kai apla tha exoume thn correctAnswer
    private String correctAnswer;
    private String category;
    private boolean used;

    public Questions(){ }

    public Questions(String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer, String category) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.category = category;
        used = false;
    }

    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswerA() {
        return answerA;
    }
    public void setAnswerA(String answerA) { this.answerA = answerA; }

    public String getAnswerB() {
        return answerB;
    }
    public void setAnswerB(String answerB) { this.answerB = answerB; }

    public String getAnswerC() {
        return answerC;
    }
    public void setAnswerC(String answerC) { this.answerC = answerC; }

    public String getAnswerD(){ return answerD; }
    public void setAnswerD(String answerD) { this.answerD = answerD; }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer){ this.correctAnswer = correctAnswer; }

    public String getCategory(){ return category;}
    public void setCategory(String category) { this.category = category; }

    public boolean getUsed(){
        return used;
    }
    public void setUsed(boolean used){ if(used){ this.used = used; } }
    public void initializeUsed(){
        used = false;
    }

    public boolean acceptableAnswer(String givenAnswer){
        if(givenAnswer == answerA || givenAnswer == answerB || givenAnswer == answerC || givenAnswer == answerD){
            return true;
        }
        else
            return false;
    }
}
