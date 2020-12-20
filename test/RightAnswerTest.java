import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class RightAnswerTest {
    private final RightAnswer rightAnswer;
    private Player A;
    private Player B;
    private ArrayList<Player> players;

    public RightAnswerTest(){
        players = new ArrayList<>();
        Player A = new Player();
        Player B = new Player();
        Player C = new Player();
        players.add(A);
        players.add(B);
        players.add(C);
        rightAnswer = new RightAnswer();
        rightAnswer.setPlayersList(players);
    }



    @Test
    void changePoints() {
        players.get(0).setStatus(true);
        players.get(1).setStatus(false);
        players.get(2).setStatus(true);
        rightAnswer.changePoints();
        assertEquals(1000, players.get(0).getScore());
        assertEquals(0, players.get(1).getScore());
        assertEquals(1000, players.get(2).getScore());

    }

    @Test
    void getName() {
        String name = rightAnswer.getName();
        assertEquals("RightAnswer", name);
    }
}