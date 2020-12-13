import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BetTest {
    private final Bet bet;
    private final Player player1;
    private final Player player2;
    private final ArrayList<Player> array;

    public BetTest(){
        bet = new Bet();
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);
        bet.setPlayersList(array);
    }

    @Test //ok!
    void changePoints() {
        int points = 1000;
        bet.setPoints(points);
        bet.setPoints(points);
        player1.setStatus(true);
        player2.setStatus(true);
        bet.changePoints();


        if(player1.getScore() == 1000){ // players status is false
            System.out.println("all well with player1 in first if");
        }else{
            System.out.println("problem with player2 in second if");
        }

        if(player2.getScore() == 1000){
            System.out.println("all well for player2 in first if");
        }else{
            System.out.println("problem with player2 in first if");
        }


        player1.setStatus(false);
        bet.changePoints();

        if(player1.getScore() == 0){
            System.out.println("all well in second if");
        }else{
            System.out.println("problem in second if");
        }

        if(player2.getScore() == 2000){
            System.out.println("all well in second if for player2!");
        }else{
            System.out.println("problem in second if for player2!");
        }


        player1.setStatus(true);
        player2.setStatus((false));
        bet.changePoints();

        if(player1.getScore() == 1000){
            System.out.println("all well in third if");
        }else{
            System.out.println("problem in third if");
        }
        if(player2.getScore() == 1000){
            System.out.println("all well in third if for player2");
        }else{
            System.out.println("problem in third if for player2");
        }

    }


    @Test //ok!
    void setPoints(){
        int points = -1020;
        bet.setPoints(points); // error message
        bet.setPoints(1000);
        bet.setPoints(1000);
        bet.setPoints(1000); // error message

    }
    @Test//TODO den eimai sugourh ama auto einai to katalhlo test na to ksanadoume
    void initializePositions() {
       int points = 500;
       bet.setPoints(points);
       player1.setStatus(true);
       bet.changePoints();
       bet.initializePositions();
       bet.setPoints(points);
       player1.setStatus(true);
       bet.changePoints();
       if(player1.getScore() == 1000){
           System.out.println("all well");
       }else{
           System.out.println("problem");
       }

    }

    @Test // ok!
    void getName() {
       String name = bet.getName();
        if(name.equals("Bet")){
            System.out.println("all well");
        }else{
            System.out.println("problem");
        }
    }
}