import java.util.ArrayList;
import java.util.Random;
/**
 * Class Round symbolizes a round of the game, which consists of 3 questions. It selects a type of game
 * for the round and the randomized questions.
 */
public class Round {
    //private static int numberOfQuestions = 3;
    private static int numberOfQuestions = 1;
    Random random;

    public Round() {

        random = new Random();
    }

    /**
     * Function getRandomType selects the type of game of the next round. Uses  Random class to get randomly
     * 0 for RightAnswer and 1 for Bet.
     * Creates a Type object.
     * @return Type
     */
    public Type getRandomType(){
        Type type;
        int r = random.nextInt(2);
        if(r == 1){
            type = new RightAnswer();
        }else{
            type = new Bet();
        }
        return type;
    }

    /**
     *
     * @return
     */

    public int  getRandomQuestion(ArrayList<String[]> questions){
        int randomQuestionSpot=0;
        //xreiazetai?

        return randomQuestionSpot;
    }




    /*
      if(type instanceof RightAnswer){
        //tha prepei na gurisei lista me tous paiktes kai na allazei to status twn nikhtwn
    }
        else if(type instanceof Bet){
        //tha prepei na rwtaei mesw ths UserInteractions to stoixhma, auto tha apothhkeuetai sthn bet
        //kai meta tha allazei to status twn nikhtwn kai tha epistrefei th lista me tous paiktes
    }
        for(int i = 0; i < numberOfQuestions; i++){

    }
    // questions.keySet() RandomQuestions[i] asto ligo etsi tha to dw aurio
    */

}
