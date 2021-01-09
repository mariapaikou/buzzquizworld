
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreTest {
    private HighScore highScore;
    private ArrayList<Player> onePlayerMode;
    private ArrayList<Player> twoPlayersMode;
    private Player player;
    private Player playerA;
    private Player playerB;
    private File onePlayerModeTest;
    private File twoPlayerModeTest;



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

    @Test // ok?
    void gameStarted() {

        highScore.gameStarted(onePlayerMode);
        assertTrue(highScore.getTotalWins().isEmpty());
        assertTrue(highScore.getHighestScores().isEmpty());

        highScore.gameStarted(twoPlayersMode);
        assertTrue(highScore.getHighestScores().isEmpty());




    }

    @Test //ok!
    void gameEnded()  {

        //one Player Mode
        player.increaseScoreBy(50);
        //add bob one time
        highScore.gameEnded(onePlayerMode);
        assertEquals(player.getNickname(),highScore.getHighestScores().get(0).getNickname());


        playerA.increaseScoreBy(999000);
        onePlayerMode.remove(0);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
        assertEquals(playerA.getNickname(),highScore.getHighestScores().get(0).getNickname());
        assertEquals(player.getNickname(),highScore.getHighestScores().get(1).getNickname());

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

        //add 10 times bob
        for(int i=0; i<10; i++){
            highScore.gameEnded(onePlayerMode);
            assertEquals(player.getNickname(),highScore.getHighestScores().get(i).getNickname());
        }

        //add tom 1 time 1st place
        onePlayerMode.remove(0);
        playerA.increaseScoreBy(10000);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
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
        highScore.loadHighestScoresFromFile("onePlayerModeTest.dat");


        //add jerry 2 times 2nd and 3rd place
        onePlayerMode.remove(0);
        playerB.increaseScoreBy(7000);
        onePlayerMode.add(playerB);
        highScore.gameEnded(onePlayerMode);
        highScore.gameEnded(onePlayerMode);

        highScore.loadHighestScoresFromFile("onePlayerModeTest.dat");

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

        try(PrintWriter writer = new PrintWriter("OnePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    @Test
    void gameEnded2(){
        player.increaseScoreBy(5000);

        //add 10 times bob
        for(int i=0; i<10; i++){
            highScore.gameEnded(onePlayerMode);
            assertEquals(player.getNickname(),highScore.getHighestScores().get(i).getNickname());
        }
        playerA.increaseScoreBy(50);
        onePlayerMode.remove(0);
        onePlayerMode.add(playerA);
        highScore.gameEnded(onePlayerMode);
        for(int i=0; i<10; i++){
            assertEquals(player.getNickname(),highScore.getHighestScores().get(i).getNickname());
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
        highScore.gameStarted(twoPlayersMode);
        highScore.saveTotalWinsToFile(twoPlayerModeTest.getAbsolutePath()); // empty file
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
        highScore.gameStarted(twoPlayersMode);
        highScore.gameEnded(twoPlayersMode);
        highScore.saveTotalWinsToFile("twoPlayerModeTest.dat");
        assertFalse(twoPlayerModeTest.getAbsolutePath().isEmpty());

        highScore.gameStarted(twoPlayersMode);
        highScore.gameEnded(twoPlayersMode);
        highScore.saveTotalWinsToFile("twoPlayerModeTest.dat");
        assertFalse(twoPlayerModeTest.getAbsolutePath().isEmpty());

        try(PrintWriter writer = new PrintWriter("twoPlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test //ok!
    void loadTotalWinsFromFile() {
        highScore.gameStarted(twoPlayersMode);
        highScore.gameEnded(twoPlayersMode);
        highScore.loadTotalWinsFromFile("twoPlayerModeTest.dat");

        assertEquals(playerA.getNickname(),highScore.getTotalWins().get(0).getNickname());
        assertEquals(playerB.getNickname(),highScore.getTotalWins().get(1).getNickname());


        playerA.setNickname("maria");
        playerB.setNickname("todorikooo!!");
        playerA.increaseScoreBy(50);
        playerB.increaseScoreBy(600);

        highScore.gameStarted(twoPlayersMode);
        highScore.gameEnded(twoPlayersMode);
        highScore.loadTotalWinsFromFile("twoPlayerModeTest.dat");


        assertEquals("TOM",highScore.getTotalWins().get(0).getNickname());
        assertEquals("JERRY",highScore.getTotalWins().get(1).getNickname());
        assertEquals(playerA.getNickname(),highScore.getTotalWins().get(2).getNickname());
        assertEquals(playerB.getNickname(),highScore.getTotalWins().get(3).getNickname());
        System.out.println(highScore.getTotalWins().size());
        assertTrue(4 == highScore.getTotalWins().size());

        try(PrintWriter writer = new PrintWriter("twoPlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Test
    void saveHighestScoresToFile() {
        highScore.gameStarted(onePlayerMode);
        highScore.gameEnded(onePlayerMode);
        highScore.saveHighestScoresToFile("onePlayerModeTest.dat");
        assertFalse(onePlayerModeTest.getAbsolutePath().isEmpty());

        highScore.gameStarted(onePlayerMode);
        highScore.gameEnded(onePlayerMode);
        highScore.saveHighestScoresToFile("onePlayerModeTest.dat");
        assertFalse(onePlayerModeTest.getAbsolutePath().isEmpty());

        try(PrintWriter writer = new PrintWriter("onePlayerModeTest.dat")){
            writer.println("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    void loadHighestScoresFromFile() {
    }

}