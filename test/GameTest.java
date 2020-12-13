import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class GameTest {

    private Game game;
    private Bet bet;
    private RightAnswer rightAnswer;
    private Timer timer;
    private Thermometer thermometer;
    private QuickAnswer quickAnswer;
    private Player player1;
    private Player player2;
    private ArrayList<Player> array;


    public GameTest(){

        game = new Game();
        bet = new Bet();
        timer = new Timer();
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
    void getPlayersAnswer(){

    }

    @Test
    void setTypesInitialBehaviour(){


    }

    @Test
    void setTypeInitialStatus(){

    }

    @Test
    void initializePlayersScore(){

    }

    @Test
    void defaultfyPlayersStatus(){

    }

    @Test
    void randomizeQuestions(){

    }

    @Test
    void playTheGame() {
    }
}