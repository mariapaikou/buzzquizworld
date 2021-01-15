
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreTest {
    private final HighScore highScore;
    private final ArrayList<Player> onePlayerMode;
    private final ArrayList<Player> twoPlayersMode;
    private final Player player;
    private final Player playerA;
    private final Player playerB;
    private final File onePlayerModeTest;
    private final File twoPlayerModeTest;

    public HighScoreTest() {
        highScore = new HighScore("onePlayerModeTest.dat","twoPlayerModeTest.dat");

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

        onePlayerModeTest = new File("onePlayerModeTest.dat");
        twoPlayerModeTest = new File("twoPlayerModeTest.dat");
    }

    @Test // empty file!
    void gameStarted() {

        highScore.gameStarted();

    }

    @Test // empty file!
    void gameEnded()  {

        //one Player Mode
        player.increaseScoreBy(50);
        highScore.gameStarted();

        //add bob one time
        highScore.gameEnded(onePlayerMode);

        playerA.increaseScoreBy(100);
        playerB.increaseScoreBy(5000);

        highScore.gameEnded(twoPlayersMode);

        assertEquals(player.getNickname()+ " " + player.getScore(), highScore.getHighestScores()[0]);

        playerA.increaseScoreBy(999000);
        onePlayerMode.remove(0);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
        assertEquals(playerA.getNickname() + " " + playerA.getScore(), highScore.getHighestScores()[0]);
        assertEquals(player.getNickname()+ " " + player.getScore(), highScore.getHighestScores()[1]);

        try(PrintWriter writer = new PrintWriter("onePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Test //ok!
    void gameEnded1(){
        // one player mode
        player.increaseScoreBy(5000);
        highScore.gameStarted();

        //add 10 times bob
        for(int i=0; i<10; i++){
            highScore.gameEnded(onePlayerMode);
            assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[i]);
        }

        //add tom 1 time 1st place
        onePlayerMode.remove(0);
        playerA.increaseScoreBy(10000);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);

        assertEquals(playerA.getNickname() + " " + playerA.getScore(), highScore.getHighestScores()[0]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[1]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[2]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[3]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[4]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[5]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[6]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[7]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[8]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[9]);

        //load correctly the list from file
        highScore.gameStarted();

        //add jerry 2 times 2nd and 3rd place
        onePlayerMode.remove(0);
        playerB.increaseScoreBy(7000);
        onePlayerMode.add(playerB);
        highScore.gameEnded(onePlayerMode);
        highScore.gameEnded(onePlayerMode);

        highScore.gameStarted();

        assertEquals(playerA.getNickname() + " " + playerA.getScore(),highScore.getHighestScores()[0]);
        assertEquals(playerB.getNickname() + " " + playerB.getScore(),highScore.getHighestScores()[1]);
        assertEquals(playerB.getNickname() + " " + playerB.getScore(),highScore.getHighestScores()[2]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[3]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[4]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[5]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[6]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[7]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[8]);
        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[9]);

        try(PrintWriter writer = new PrintWriter("OnePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


    @Test
    void gameEnded2(){
        player.increaseScoreBy(5000);
        highScore.gameStarted();

        //add 10 times bob
        for(int i=0; i<10; i++){
            highScore.gameEnded(onePlayerMode);
            assertEquals(player.getNickname() + " " + player.getScore(), highScore.getHighestScores()[i]);
        }

        playerA.increaseScoreBy(50);
        onePlayerMode.remove(0);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
        for(int i=0; i<10; i++){
          assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[i]);
        }

        try(PrintWriter writer = new PrintWriter("onePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    @Test // ok!
    void saveTotalWinsToFile() {
        // when file is empty
        highScore.gameStarted();
        highScore.gameEnded(twoPlayersMode);
        assertFalse(twoPlayerModeTest.getAbsolutePath().isEmpty());

        try(PrintWriter writer = new PrintWriter("twoPlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test //ok!
    void saveTotalWinsToFile1(){
        //when file is not empty
        highScore.gameStarted();
        highScore.gameEnded(twoPlayersMode);
        highScore.gameStarted();
        assertFalse(twoPlayerModeTest.getAbsolutePath().isEmpty());

        highScore.gameStarted();
        highScore.gameEnded(twoPlayersMode);
        highScore.gameStarted();
        assertFalse(twoPlayerModeTest.getAbsolutePath().isEmpty());

        try(PrintWriter writer = new PrintWriter("twoPlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test //ok!
    void loadTotalWinsFromFile() {
        highScore.gameStarted();
        highScore.gameEnded(twoPlayersMode);
        highScore.gameStarted();

        assertEquals(playerA.getNickname() + " " + playerA.getScore() + " " + playerB.getNickname() + " " + playerA.getScore(), highScore.getTotalWins()[0]);

        highScore.gameStarted();
        highScore.gameEnded(twoPlayersMode);
        highScore.gameStarted();

        assertEquals("TOM" + " " + "0" + " JERRY" + " " + "0", highScore.getTotalWins()[0]);

        try(PrintWriter writer = new PrintWriter("twoPlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Test //ok!
    void saveHighestScoresToFile() {
        highScore.gameStarted();
        highScore.gameEnded(onePlayerMode);
        highScore.gameStarted();
        assertFalse(onePlayerModeTest.getAbsolutePath().isEmpty());

        highScore.gameStarted();
        highScore.gameEnded(onePlayerMode);
        highScore.gameStarted();
        assertFalse(onePlayerModeTest.getAbsolutePath().isEmpty());

        try(PrintWriter writer = new PrintWriter("onePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test //ok!
    void loadHighestScoresFromFile() {
        highScore.gameStarted();
        highScore.gameEnded(onePlayerMode);
        highScore.gameStarted();

        assertEquals(player.getNickname() + " " + player.getScore(),highScore.getHighestScores()[0]);

        player.setNickname("todooookiii!");
        player.increaseScoreBy(500);
        highScore.gameEnded(onePlayerMode);
        highScore.gameStarted();
        highScore.gameStarted();
        assertEquals("todooookiii!" + " " + player.getScore(),highScore.getHighestScores()[0]);

        assertEquals("BOB" + " 0",highScore.getHighestScores()[1]);

        try(PrintWriter writer = new PrintWriter("onePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}