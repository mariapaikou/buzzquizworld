import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Questions contains a question, the answers for the question and the right answer.
 * It also contains a boolean variable that stores either the question has already been asked or not.
 * this class will be used to create Questions objects with the data from the file that then will be stored
 * in an ArrayList, so that they can be randomly asked.
 */

public class Questions {

    private final String question;
   /* private String answerA;
    private String answerB;
    private String answerC;
    private String answerD; //sto mellon aftin tha thn svisoyme kai apla tha exoume thn correctAnswer
    */
    private final String correctAnswer;
    private final String category;
    private final ArrayList<String> answers;
  //  private boolean used;

  //  public Questions(){ }

    public Questions(String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer, String category) {

        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;
        answers = new ArrayList<>();
        answers.add(answerA);
        answers.add(answerB);
        answers.add(answerC);
        answers.add(answerD);
      //  used = false;

    }

    public String getQuestion(){
        return question;
    }

   // public void setQuestion(String question) { this.question = question; }
/*
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

 */

    public String getCorrectAnswer(){
        return correctAnswer;
    }
   // public void setCorrectAnswer(String correctAnswer){ this.correctAnswer = correctAnswer; }

    public String getCategory(){ return category;}
  //  public void setCategory(String category) { this.category = category; }
/*
    public boolean getUsed(){
        return used;
    }
    public void setUsed(boolean used){ if(used){ this.used = used; } }
    public void initializeUsed(){
     used = false;
    }

 */

    public boolean acceptableAnswer(String givenAnswer){

        return givenAnswer.equals(answers.get(0)) || givenAnswer.equals(answers.get(1)) || givenAnswer.equals(answers.get(2)) || givenAnswer.equals(answers.get(3));

    }

    public ArrayList<String> getAnswers(){

        Collections.shuffle(answers);
        return answers;

    }
}
