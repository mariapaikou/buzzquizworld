import java.util.HashMap;
import java.util.List;

/**
 * Class Round symbolizes a round of the game, which consists of 3 questions. It selects a type of game
 * for the round and the randomized questions.
 */
public class Round {
    private static int numberOfQuestions = 3;
    HashMap<String, List<String>> questions;

    public Round() {
        for(int i = 0; i < numberOfQuestions; i++)
            questions.keySet() RandomQuestions[i]
    }

}
