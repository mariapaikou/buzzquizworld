import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RoundTest {
    private final Round round;
    private  Type type;

    public RoundTest(){
        round = new Round();
    }

    @Test //ok!
    void getRandomType() {

        int betCounter = 0;

        for(int i = 0; i<1000; i++){

            type = round.getRandomType();

            if(type instanceof Bet) {
                betCounter++;
            }

        }

        assertEquals(true, betCounter >= 450 && betCounter <= 550);

    }
}