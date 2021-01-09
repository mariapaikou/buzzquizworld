
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

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
    String wins;
    String high;


    public HighScoreTest() {
        highScore = new HighScore("high.dat","wins.dat");

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

    @Test // ok?
    void gameStarted() {

        highScore.gameStarted(onePlayerMode);
        assertTrue(highScore.getTotalWins().isEmpty());
        assertTrue(highScore.getHighestScores().isEmpty());

        highScore.gameStarted(twoPlayersMode);
        assertTrue(highScore.getHighestScores().isEmpty());




    }

    @Test
    void gameEnded()  {

        //one Player Mode
        player.increaseScoreBy(50);
        highScore.gameEnded(onePlayerMode);
        boolean flag = false;
        for(Player wat : highScore.getHighestScores()){

            System.out.println("first assertEquals" + wat.getNickname() + wat.getScore());
            if(player.equals(wat)){
                flag = true;

            }
        }
        assertTrue(flag);


        playerA.increaseScoreBy(999000);
        onePlayerMode.remove(0);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);

        flag = false;
        for(Player wat : highScore.getHighestScores()){
            System.out.println("second assertEquals" + wat.getNickname() + wat.getScore());
            if(player.equals(wat)){
                flag = true;

            }
        }
        assertTrue(flag);
        try(PrintWriter writer = new PrintWriter("high.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }





    }

    @Test
    void gameEnded1(){
        // one player mode
        player.increaseScoreBy(5000);
        //add 10 times bob
        for(int i=0; i<10; i++){
            highScore.gameEnded(onePlayerMode);
           // assertEquals(player.getNickname(),highScore.getHighestScores().get(i).getNickname());
        }

        //add tom 1 time 1st place
        onePlayerMode.remove(0);
        playerA.increaseScoreBy(10000);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
       // highScore.loadHighestScoresFromFile("high.dat");
        for(int i = 0; i<10; i++){
            System.out.println(highScore.getHighestScores().get(i).getNickname());
        }

        assertEquals(playerA.getNickname(),highScore.getHighestScores().get(0).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(1).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(2).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(3).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(4).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(5).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(6).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(7).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(8).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(9).getNickname());


        //load correctly the list from file
        highScore.loadHighestScoresFromFile("high.dat");


        //add jerry 2 times 2nd and 3rd place
        onePlayerMode.remove(0);
        playerB.increaseScoreBy(7000);
        onePlayerMode.add(playerB);
        highScore.gameEnded(onePlayerMode);
        highScore.gameEnded(onePlayerMode);

        highScore.loadHighestScoresFromFile("high.dat");

        assertEquals(playerA.getNickname(),highScore.getHighestScores().get(0).getNickname());
        assertEquals(playerB.getNickname(),highScore.getHighestScores().get(1).getNickname());
        assertEquals(playerB.getNickname(),highScore.getHighestScores().get(2).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(3).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(4).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(5).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(6).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(7).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(8).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(9).getNickname());

        try(PrintWriter writer = new PrintWriter("high.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    @Test
    void gameEnded2(){

    }

    @Test
    void saveTotalWinsToFile() {
        highScore.gameStarted(twoPlayersMode);
        highScore.saveTotalWinsToFile(WINS.getAbsolutePath()); // empty file
        assertFalse(WINS.getAbsolutePath().isEmpty());
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

}