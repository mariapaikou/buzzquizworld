import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 * This contains a small sample of questions for testing purposes
 */
public class Questions {
    String question;
    String answerA;
    String answerB;
    String answerC;
    String answerD;
    String correctAnswer;
    boolean used;


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

    public String getAnswerD(){
        return answerD;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public boolean getUsed(){
        return getUsed();
    }

    public void setUsed(boolean used){
        if(used){
            this.used=used;
        }

    }

    public void initializeUsed(){
        used = false;
    }
}
