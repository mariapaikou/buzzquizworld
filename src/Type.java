
public class Type {
    int points;//xreiazetai;
    Player winner;

    protected  Type(){
        //να προστεθει κωδικας!!

    }


    private Type(String nameOfGame){
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
