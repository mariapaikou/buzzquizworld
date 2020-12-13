import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {
    private final Bet bet;
    private final RightAnswer rightAnswer;
    private final Timer timer;
    private final QuickAnswer quickAnswer;
    private final Thermometer thermometer;
    private Player player1;
    private Player player2;
    private ArrayList<Player> array;


     public TypeTest() {
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);

        bet = new Bet();
        rightAnswer = new RightAnswer();
        timer = new Timer();
        quickAnswer = new QuickAnswer();
        thermometer = new Thermometer();

    }

    @Test
    void changePoints() {
         //aythn thn tsekaroume ksexvrista gia kathe upoklash!

    }

    @Test
    void setPlayersList() {
        ArrayList<Player> players = new ArrayList<>();

        if(bet.setPlayersList(array)){
            System.out.println("all well in bet!");
        }else{
            System.out.println("problem in bet!");
        }


        if( rightAnswer.setPlayersList(array)){
            System.out.println("all well in rightAnswer!");
        }else{
            System.out.println("problem in rightAnswer!");
        }

        if(timer.setPlayersList(players)){
            System.out.println("all well in timer!");
        }else{
            System.out.println("problem in timer!");
        }

        if(thermometer.setPlayersList(players)){
            System.out.println("all well in thermometer!");
        }else{
            System.out.println("problem in thermometer!");
        }

        if(quickAnswer.setPlayersList(players)){
            System.out.println("all well in quickAnswer!");
        }else{
            System.out.println("problem in quickAnswer!");
        }
    }



    @Test //ok!
    void getName() {
         if (bet.getName().equals("Bet")){
            System.out.println("all well for bet!");
        }
        if(rightAnswer.getName().equals("RightAnswer")){
            System.out.println("all well for rightAnswer!");
        }
        if(timer.getName().equals("Timer")) {
            System.out.println("all well for timer!");
        }
        if(thermometer.getName().equals("Thermometer")){
            System.out.println("all well for thermometer!");
        }
        if (quickAnswer.getName().equals("QuickAnswer")){
            System.out.println("all well for quickAnser!");
        }
    }

}