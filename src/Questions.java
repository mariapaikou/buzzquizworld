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
    private String answerD;
    private String correctAnswer;
    private boolean used;


    public Questions(String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        used = false;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD(){ return answerD; }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public boolean getUsed(){
        return getUsed();
    }

    public void setUsed(boolean used){
        if(used){
            this.used = used;
        }

    }

    public void initializeUsed(){
        used = false;
    }
}
