
import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;

public class Thermometer extends Type {

    private final int points;
    private final HashMap correctAnswers;
    private ArrayList<Player> nameOfWinner;

    public Thermometer(){

        super();
        points = 5000;
        correctAnswers = new HashMap();
        nameOfWinner = new ArrayList<>();

    }

    @Override
    public boolean setPlayersList(ArrayList<Player> players){
        boolean flag = super.setPlayersList(players);
        if(flag && players.size()>1){
            initializeCorrectAnswers();
        }else{
            flag = false;
        }

        return flag;
    }



    public void initializeCorrectAnswers(){
        correctAnswers.clear();
        for(Player player : players){

            correctAnswers.put(player.getNickname(),0);

        }
    }


    public void changePoints(){

        int sup;

        for(Player player : players){
            if(player.getStatus()){

                sup= (int) correctAnswers.get(player.getNickname());
                correctAnswers.replace(player.getNickname(),sup+1);

                if((int) correctAnswers.get(player.getNickname()) == 5){
                    nameOfWinner.add(player);
                }

            }

        }

        if(nameOfWinner.size() == 1){
            nameOfWinner.get(0).increaseScoreBy(points);
            initializeCorrectAnswers();
        }else if(nameOfWinner.size() > 1){
            long max = 999999999;
            sup = -1;
            for(int i = 0; i<nameOfWinner.size(); i++){
                if(nameOfWinner.get(i).getClickTime() < max){
                    max = nameOfWinner.get(i).getClickTime();
                    sup = i;
                }
            }
            nameOfWinner.get(sup).increaseScoreBy(points);
            initializeCorrectAnswers();
        }

        nameOfWinner.clear();

    }

    public String getName(){return "Thermometer";}

    public String getExplanation(){
        String explanation = "The first player to answer 5 questions correctly earns 5000 points.";
        return explanation;
    }
}
