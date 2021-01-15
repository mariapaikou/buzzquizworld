import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GameTest{
    private final Game game;
    private final Bet bet;
    private final RightAnswer rightAnswer;
    private final StopTheTimer stopTheTimer;
    private final Thermometer thermometer;
    private final QuickAnswer quickAnswer;
    private final Player player1;
    private final Player player2;
    private final ArrayList<Player> array;

    public GameTest(){
        game = new Game("onePlayerModeTest.dat", "towPlayerModeTest.dat");
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
        bet.setPlayersList(array);
        thermometer.setPlayersList(array);
        rightAnswer.setPlayersList(array);
        stopTheTimer.setPlayersList(array);
        quickAnswer.setPlayersList(array);
    }

    @Test
    void readScore(){
        game.readScores();
        assertEquals("There are no high scores yet!",game.getHighScores()[0]);
        assertEquals("There are no total wins yet!",game.getTotalWins()[0]);
    }

    @Test
    void getHighScores(){
        game.readScores();
        assertEquals("There are no high scores yet!",game.getHighScores()[0]);
    }

    @Test
    void getTotalWins(){
        game.readScores();
        assertEquals("There are no total wins yet!",game.getTotalWins()[0]);
    }


    @Test
    void randomizeQuestions(){
        Questions question = game.getNewQuestion();
        game.randomizeQuestions();
        assertNotSame(question, game.getNewQuestion());
    }


    @Test
    void getNumberOfQuestions(){
        assertEquals(3, game.getNumberOfQuestions());
    }

    @Test
    void getHowManyRound(){
        assertEquals(3,game.getHowManyRounds());
    }

    @Test
    void getRandomType(){
        Type type = game.getRandomType(array);
        int betCounter = 0;
        int stopTheTimerCounter = 0;
        int thermometerCounter = 0;
        int rightAnswerCounter = 0;
        int quickAnswerCounter = 0;

        if(type instanceof StopTheTimer){
            stopTheTimerCounter++;
        }else if(type instanceof QuickAnswer){
            quickAnswerCounter++;
        }else if(type instanceof RightAnswer){
            rightAnswerCounter++;
        }else if(type instanceof Bet){
            betCounter++;
        }else if(type instanceof Thermometer){
            thermometerCounter++;
        }

        if(betCounter == 1){
            assertTrue(true);
        }else if(stopTheTimerCounter == 1){
            assertTrue(true);
        }else if(thermometerCounter == 1){
            assertTrue(true);
        }else if(rightAnswerCounter == 1){
            assertTrue(true);
        }else if(quickAnswerCounter == 1){
            assertTrue(true);
        }
    }

    @Test
    void getNewQuestion(){
        Questions question1 = game.getNewQuestion();
        Questions question2 = game.getNewQuestion();
        assertNotSame(question1, question2);
    }

    @Test
    void setStatuses(){
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Peanuts");
        answers.add("kati allo");
        game.setStatuses(answers,"Peanuts",array);

        assertTrue(player1.getStatus());
        assertFalse(player2.getStatus());
    }

    @Test
    void setTime(){
        long [] times = new long[2];
        times[0] = 9000;
        times[1] = 7000;
        game.setTime(times,0,rightAnswer, array);
        assertEquals(0,player1.getWallet().getClickTime());
        assertEquals(0,player2.getWallet().getClickTime());

        game.setTime(times, 0, bet, array);
        assertEquals(0, player1.getWallet().getClickTime());
        assertEquals(0,player2.getWallet().getClickTime());

        game.setTime(times,0,stopTheTimer, array);
        assertEquals(1000, player1.getWallet().getClickTime());
        assertEquals(3000,player2.getWallet().getClickTime());

        game.setTime(times,0,thermometer, array);
        assertEquals(9000, player1.getWallet().getClickTime());
        assertEquals(7000,player2.getWallet().getClickTime());

        game.setTime(times,0,quickAnswer, array);
        assertEquals(9000, player1.getWallet().getClickTime());
        assertEquals(7000,player2.getWallet().getClickTime());
    }

    @Test
    void changePoints1(){
        int score = player1.getScore();
        player1.setStatus(true);
        player1.getWallet().setBet(500);
        game.changePoints(bet);
        assertTrue(score != player1.getScore());
    }

    @Test
    void changePoints2(){
        int score = player1.getScore();
        player1.setStatus(true);
        game.changePoints(rightAnswer);
        assertTrue(score != player1.getScore());
    }

    @Test
    void changePoints3(){
        int score = player1.getScore();
        player1.setStatus(true);
        player1.getWallet().setClickTime(90);
        game.changePoints(quickAnswer);
        assertTrue(score != player1.getScore());
    }

    @Test
    void changePoints4(){
        int score = player1.getScore();
        player1.setStatus(true);
        player1.getWallet().setClickTime(650);
        game.changePoints(stopTheTimer);
        assertTrue(score != player1.getScore());
    }

    @Test
    void changePoints5(){
        int score = player1.getScore();
        player1.setStatus(true);
        for(int i=0; i<4; i++){
            player1.getWallet().increaseStreak();
        }
        game.changePoints(thermometer);
        assertTrue(score != player1.getScore());
    }

    @Test
    void defaultifyPlayers(){
        player1.setStatus(true);
        player2.setStatus(true);
        player2.getWallet().setBet(500);

        game.defaultifyPlayers(array,bet);
        assertFalse(player1.getStatus());
        assertFalse(player2.getStatus());
        assertEquals(0,player2.getWallet().getBet());
    }

    @Test
    void gameEnd(){
        String[] highScores = game.getHighScores();
        String[] totalWins = game.getTotalWins();

        game.gameEnd(array);
        assertNotSame(highScores, game.getHighScores());
        assertNotSame(totalWins, game.getTotalWins());
    }
}