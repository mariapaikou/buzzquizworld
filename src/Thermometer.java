import java.util.HashMap;

public class Thermometer extends Type {

    int points;
    HashMap correctAnswers;

    public Thermometer(){

        super();
        points = 5000;
        correctAnswers = new HashMap();
        for(Player player:players){
            correctAnswers.put(player.getNickname(),0);
        }

    }

    public void changePoints(){

        boolean firstToAnswerCorrectly = true;
        String nameOfPlayer = "";
        int j;

        for(int i=0; i < players.size(); i++){

            if(players.get(i).getStatus() && firstToAnswerCorrectly){

                j = (int) correctAnswers.get(players.get(i).getNickname());
                correctAnswers.replace(players.get(i).getNickname(), j+1);

                nameOfPlayer = players.get(i).getNickname();
                if((int)correctAnswers.get(nameOfPlayer) == 5){
                    players.get(i).increaseScoreBy(points);
                }

            }if(players.get(i).getStatus()){

                j = (int) correctAnswers.get(players.get(i).getNickname());
                correctAnswers.replace(players.get(i).getNickname(), j+1);


            }

        }



    }

    public String getName(){return "Thermometer";}
}
