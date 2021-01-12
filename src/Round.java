import java.util.Random;
/**
 * Class Round symbolizes a round of the game, which consists of a number of questions. It selects a type of game
 * for the round.
 */
public class Round {

    Random random;

    public Round() {
        random = new Random();
    }

    /**
     * Function getRandomType selects the type of game for the next round. Uses Random class to get randomly
     * 0 for RightAnswer and 1 for Bet.
     * Creates a Type object.
     *
     * @return Type object that contains the type chosen.
     */
    public Type towPlayerMode() {

        Type type;
        type = new Thermometer();
//        int r = random.nextInt(5);
//
//        if (r == 1) {
//            type = new RightAnswer();
//        } else if (r == 2) {
//            type = new Bet();
//        } else if (r == 3) {
//            type = new QuickAnswer();
//        } else if (r == 4) {
//            type = new StopTheTimer();
//        } else {
//            type = new Thermometer();
//        }
        return type;

    }

    public Type onePlayerMode() {
        Type type;
        int r = random.nextInt(3);

        if (r == 1) {
            type = new RightAnswer();
        } else if (r == 2) {
            type = new Bet();
        } else {
            type = new StopTheTimer();
        }

        return type;
    }
}