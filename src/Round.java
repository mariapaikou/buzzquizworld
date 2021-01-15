import java.util.Random;
/**
 * Round class selects Randomly one type of game from the following available choices (Thermometer, StopTheTimer
 * RightAnswer, Bet, QuickAnswer)
 */
public class Round {

    Random random;

    /**
     * Constructor
     */
    public Round() {
        random = new Random();
    }

    /**
     * Method onePlayerMode selects randomly and creates a type of game from the following list( StopTheTimer,
     * RightAnswer, Bet).
     * @return Type
     */
    public Type onePlayerMode() {
        Type type ;
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

    /**
     * Method towPlayerMode selects randomly and creates a type of game from the following list(Thermometer, StopTheTimer
     * RightAnswer, Bet, QuickAnswer).
     * @return Type
     */
    public Type towPlayerMode() {

        Type type;

        int r = random.nextInt(5);

        if (r == 1) {
            type = new RightAnswer();
        } else if (r == 2) {
            type = new Bet();
        } else if (r == 3) {
            type = new QuickAnswer();
        } else if (r == 4) {
            type = new StopTheTimer();
        } else {
            type = new Thermometer();
        }
        return type;

    }


}