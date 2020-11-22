/**
 * This class is the parent of the game types that are available.
 * It has an int that refers to the points that need to be added to the winner and it also has
 * a variable to save the winner of the round.
 */

public class Type {
    int points;//xreiazetai;
    Player winner;

    public  Type(){
        //να προστεθει κωδικας!!

    }


    public Type(String nameOfGame){
        points=0;
        if(nameOfGame=="Right Answer"){
            RightAnswer rightAnswer = new RightAnswer();
        }else if(nameOfGame=="Timer"){
            Timer timer= new Timer();
        }else if(nameOfGame=="Bet"){
            Bet bet = new Bet();
        }else if(nameOfGame == "Quick Answer"){
            QuickAnswer quickAnswer = new QuickAnswer();
        }else if(nameOfGame == "Thermometer"){
            Thermometer thermometer = new Thermometer();
        }else{
            runTimeError();
        }
    }

    private void runTimeError(){
        //κλαση που δεν φτιαχνει αντικείμενο???
        //void?
    }

}
