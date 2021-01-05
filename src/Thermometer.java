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

            if(super.setPlayersList(players)){
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
                j = (int) correctAnswers.get(nameOfPlayer) + 1;
                if(correctAnswers.containsKey(nameOfPlayer)){
                    correctAnswers.replace(players.get(i).getNickname(), j);
                }else{

                }



                if((int)correctAnswers.get(nameOfPlayer) == 5){
                    players.get(i).increaseScoreBy(points);
                }
                firstToAnswerCorrectly = false;


            }else if(players.get(i).getStatus()){

                j = (int) correctAnswers.get(players.get(i).getNickname()) + 1;
                correctAnswers.replace(players.get(i).getNickname(), j);


            }

        }



    }

    public String getName(){return "Thermometer";}
}
