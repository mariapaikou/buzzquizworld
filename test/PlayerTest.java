import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private final Player player;

    public PlayerTest(){
        player = new Player();
    }

    @Test //ok!
    void setNickname() {

        String nickname = "";
        player.setNickname(nickname);

        assertEquals("Randall Stephens!",player.getNickname());

        nickname = "kalhmaera!";
        player.setNickname(nickname);

        assertEquals(nickname,player.getNickname());

    }

    @Test //ok!
    void getNickname() {

        String nickname = "someone";
        player.setNickname(nickname);

        assertEquals(nickname,player.getNickname());

    }


    @Test //ok!
    void getScore() {

        assertEquals(0,player.getScore());

        int score = 1000;
        player.increaseScoreBy(score);

        assertEquals(score,player.getScore());

    }

    @Test //ok!
    void setStatus() {

        player.setStatus(true);
        assertEquals(true,player.getStatus());

        player.setStatus(false);
        assertEquals(false,player.getStatus());

    }

    @Test //ok!
    void getStatus() {

        assertEquals(false,player.getStatus());

    }

    @Test //ok!
    void increaseScoreBy() {

        int score = -600;
        player.increaseScoreBy(score);
        assertEquals(-600,player.getScore());

    }

    @Test //ok!
    void initializeScore() {

        int score = 600;
        player.increaseScoreBy(score);
        player.initializeScore();
        assertEquals(0,player.getScore());


    }

    @Test //ok!
    void defaultfyStatus() {

        player.setStatus(true);
        player.defaultifyStatus();
        assertEquals(false,player.getStatus());

    }
}