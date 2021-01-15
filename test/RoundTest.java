import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RoundTest {
    private final Round round;


    public RoundTest(){
        round = new Round();

    }
    @Test
    void onePlayerMode(){
        int betCounter = 0;
        int stopTheTimerCounter = 0;
        int rightAnswerCounter = 0;
        Type type;


        for(int i = 0; i<2000; i++){

            type = round.onePlayerMode();

            if(type instanceof Bet){
               betCounter++;
            }else if(type instanceof RightAnswer){
                rightAnswerCounter++;
            }else {
                stopTheTimerCounter++;
            }
        }

        assertTrue(betCounter >= 600 && betCounter <=700);
        assertTrue(rightAnswerCounter >= 600 && rightAnswerCounter <= 700);
        assertTrue(stopTheTimerCounter >= 600 && stopTheTimerCounter <= 700);

    }


    @Test //ok!
    void towPlayerMode() {

        int betCounter = 0;
        int stopTheTimerCounter = 0;
        int thermometerCounter = 0;
        int rightAnswerCounter = 0;
        int quickAnswerCounter = 0;
        Type type;

        for(int i = 0; i<2000; i++){

            type = round.towPlayerMode();

            if(type instanceof Bet) {
                betCounter++;
            }else if(type instanceof RightAnswer){
                rightAnswerCounter++;
            }else if(type instanceof StopTheTimer){
                stopTheTimerCounter++;
            }else if(type instanceof  Thermometer){
                thermometerCounter++;
            }else if(type instanceof QuickAnswer){
                quickAnswerCounter++;
            }

        }

        assertTrue(betCounter >= 350 && betCounter <= 450);
        assertTrue(stopTheTimerCounter >= 350 && stopTheTimerCounter <= 450);
        assertTrue(thermometerCounter >= 350 && thermometerCounter <= 450);
        assertTrue(rightAnswerCounter >= 350 && rightAnswerCounter <= 450);
        assertTrue(quickAnswerCounter >= 350 && quickAnswerCounter <= 450);

    }



}