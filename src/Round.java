import java.util.HashMap;
import java.util.List;

/**
 * Class Round symbolizes a round of the game, which consists of 3 questions. It selects a type of game
 * for the round and the randomized questions.
 */
public class Round {
    private static int numberOfQuestions = 3;
    HashMap<String, List<String>> questions;

    public Round(Type type) {
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
    }

}
