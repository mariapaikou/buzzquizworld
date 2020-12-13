import org.junit.jupiter.api.Test;



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

        if( betCounter >= 450 && betCounter <= 550 ){
            System.out.println("all well " + betCounter);
        }

    }
}