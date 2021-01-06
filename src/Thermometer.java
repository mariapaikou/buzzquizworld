
import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;

public class Thermometer extends Type {

    private final int points;
    private final HashMap correctAnswers;


    public Thermometer(){

        super();
        points = 5000;
        correctAnswers = new HashMap();

    }

    @Override
    public boolean setPlayersList(ArrayList<Player> players){
        boolean flag = super.setPlayersList(players);
        for(Player player : players){

            correctAnswers.put(player.getNickname(),0);

        }
        return flag;
    }



    public void changePoints(){

        boolean firstToAnswerCorrectly = true;







        defaultfyPlayers();
    }

    public String getName(){return "Thermometer";}
}
