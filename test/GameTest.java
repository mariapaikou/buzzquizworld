import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;




class GameTest{



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

   // @TestFactory
   // InputStream inputSteamTest(){
        


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
        /*
        InputOutput inputOutput = new InputOutput();
        String input = "maria";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        assertEquals("maria", inputOutput.getInput());
         */





    }

   // @Inject private Rule

    public void MyTest(){

    }
}