import java.util.ArrayList;
import java.util.HashMap;

public class Thermometer extends Type {

    int points;
    HashMap correctAnswers;


    public Thermometer(){

        super();
        points = 5000;
        correctAnswers = new HashMap();


    }



    @Override
    public boolean setPlayersList(ArrayList<Player> players) {

        if(players != null){
            this.players = players;
        }

        if(this.players == players){

            for(Player player:players){
                correctAnswers.put(player.getNickname(),0);
            }
            return true;

        }else{

            return false;

        }

    }


    public void changePoints(){

        boolean firstToAnswerCorrectly = true;
        String nameOfPlayer = "";
        int j;

        for(int i=0; i < players.size(); i++){

            if(players.get(i).getStatus() && firstToAnswerCorrectly){

                nameOfPlayer = players.get(i).getNickname();
               //j = (int) ;
                if(correctAnswers.containsKey(nameOfPlayer)){
                    correctAnswers.replace(players.get(i).getNickname(), (int)correctAnswers.get(nameOfPlayer)+1);
                }else{

                }



                if((int)correctAnswers.get(nameOfPlayer) == 5){
                    players.get(i).increaseScoreBy(points);
                }
                firstToAnswerCorrectly = false;


            }else if(players.get(i).getStatus()){

                j = (int) correctAnswers.get(players.get(i).getNickname());
                correctAnswers.replace(players.get(i).getNickname(), j+1);


            }

        }



    }

    public String getName(){return "Thermometer";}
}
