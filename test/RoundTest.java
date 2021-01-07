import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RoundTest {
    private final Round round;


    public RoundTest(){
        round = new Round();

    }

    @Test //ok!
    void getRandomType() {

        int betCounter = 0;
        int timerCounter = 0;
        int thermometerCounter = 0;
        int rightAnswerCounter = 0;
        int quickAnswerCounter = 0;
        Type type;

        for(int i = 0; i<2000; i++){

            type = round.getRandomType();

            if(type instanceof Bet) {
                betCounter++;
            }else if(type instanceof RightAnswer){
                rightAnswerCounter++;
            }else if(type instanceof Timer){
                timerCounter++;
            }else if(type instanceof  Thermometer){
                thermometerCounter++;
            }else if(type instanceof QuickAnswer){
                quickAnswerCounter++;
            }

        }

        assertTrue(betCounter >= 350 && betCounter <= 450);
        assertTrue(timerCounter >= 350 && timerCounter <= 450);
        assertTrue(thermometerCounter >= 350 && thermometerCounter <= 450);
        assertTrue(rightAnswerCounter >= 350 && rightAnswerCounter <= 450);
        assertTrue(quickAnswerCounter >= 350 && quickAnswerCounter <= 450);

    }

}