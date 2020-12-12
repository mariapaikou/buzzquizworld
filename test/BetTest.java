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
        bet.SetPlayersList(array);
    }


    @Test
    void changePoints() {
        int points = 1000;
        bet.setPoints(points);
        bet.changePoints();
        if(player1.getScore() == 1000){ // players status is false
            System.out.println("problem in first if");
        }else{
            System.out.println("all well in first if");
        }
        bet.changePoints();
        if(player1.getScore() == 2000){
            System.out.println("problem in second if");
        }else{
            System.out.println("all well in second if");
        }
    }

    @Test
    void changePoints1() {
        int points = 1000;
        bet.setPoints(points);

        player1.setStatus(true);
        player2.setStatus(true);
        bet.changePoints();
        if(player1.getScore() == 1000){ // players status is false
            System.out.println("all well in first if");
        }else{
            System.out.println("problem in second if");
        }
        bet.initializePositions();

        player1.setStatus(false);
        bet.changePoints();
        if(player1.getScore() == 0){
            System.out.println("all well in second if");
        }else{
            System.out.println("problem in second if");
        }
        bet.initializePositions();

        player1.setStatus(true);
        bet.changePoints();
        if(player1.getScore() == 1000){
            System.out.println("all well in third if");
        }else{
            System.out.println("problem in third if");
        }

    }



    @Test
    void setPoints() {
        int points = 550;
        bet.setPoints(points);
        bet.changePoints();
        if(player1.getScore() == 550){
            System.out.println("problem");
        }else if(player1.getScore() == 0){
            System.out.println("All well");
        }

    }

    @Test
    void setPoints1(){
        int points = -1020;
        bet.setPoints(points);
        if(player1.getScore() == -1020){
            System.out.println("problem");
        }else if(player1.getScore() == 0){
            System.out.println("All well");
        }
    }
    @Test////// den eimai sugourh ama auto einai to katalhlo test
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

    @Test
    void getName() {
       String name = bet.getName();
        if(name.equals("Bet")){
            System.out.println("all well");
        }else{
            System.out.println("problem");
        }
    }
}