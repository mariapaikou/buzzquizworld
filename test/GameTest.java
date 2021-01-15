import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


class GameTest{
    private Game game;
    private Bet bet;
    private RightAnswer rightAnswer;
    private StopTheTimer stopTheTimer;
    private Thermometer thermometer;
    private QuickAnswer quickAnswer;
    private Player player1;
    private Player player2;
    private ArrayList<Player> array;


    public GameTest(){

        game = new Game("onePlayerModeTest", "towPlayerModeTest");
        bet = new Bet();
        stopTheTimer = new StopTheTimer();
        rightAnswer = new RightAnswer();
        thermometer = new Thermometer();
        quickAnswer = new QuickAnswer();
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);

    }

    @Test
    void readScore(){
        game.readScores();
        assertEquals("There are no high scores yet!",game.getHighScores()[0]);
        assertEquals("There are no total wins yet!",game.getTotalWins()[0]);

    }
}