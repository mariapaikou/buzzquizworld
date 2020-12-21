import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuickAnswerTest {
    private Player player1;
    private Player player2;
    private ArrayList<Player> array;
    private RightAnswer rightAnswer;

    public QuickAnswerTest(){
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        rightAnswer = new RightAnswer();
    }

    @Test
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(true);

        array.add(player2);
        array.add(player1);

        rightAnswer.setPlayersList(array);
        rightAnswer.changePoints();

        assertEquals(1000,player2.getScore());
        assertEquals(500,player1.getScore());


    }

    @Test
    void setPoints() {
    }

    @Test
    void getName() {
    }
}