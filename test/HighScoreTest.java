/*
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreTest {
    private HighScore highScore;
    private ArrayList<Player> onePlayerMode;
    private ArrayList<Player> twoPlayersMode;
    private Player player;
    private Player playerA;
    private Player playerB;
    private File WINS;
    private File HIGH;

    public HighScoreTest(){
        highScore = new HighScore();

        onePlayerMode = new ArrayList<>();
        twoPlayersMode = new ArrayList<>();

        player = new Player();
        player.setNickname("BOB");

        playerA = new Player();
        playerA.setNickname("TOM");

        playerB = new Player();
        playerB.setNickname("JERRY");

        onePlayerMode.add(player);

        twoPlayersMode.add(playerA);
        twoPlayersMode.add(playerB);

        WINS = new File("wins.dat");
        HIGH = new File("high.dat");
    }

    @Test
    void gameStarted() {
        highScore.gameStarted(twoPlayersMode);

    }

    @Test
    void gameEnded() {
    }

    @Test
    void saveTotalWinsToFile() {
    }

    @Test
    void loadTotalWinsFromFile() {
    }

    @Test
    void saveHighestScoresToFile() {
    }

    @Test
    void loadHighestScoresFromFile() {
    }
}*/
