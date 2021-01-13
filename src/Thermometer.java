import java.util.ArrayList;


public class Thermometer extends Type {

    private final int points;
//    private ArrayList<Player> nameOfWinner;

    /**
     *
     */
    public Thermometer(){

        super();
        points = 5000;
//        nameOfWinner = new ArrayList<>();

    }



    /**
     *
     */
    public void changePoints(){

        ArrayList<Player> reachedFive = new ArrayList<>();

        for(int i=0; i<players.size(); i++){
            if (players.get(i).getStatus()){
                players.get(i).increaseStreak();
                System.out.println("streak " + players.get(i). getNickname() + " " + players.get(i).getStreak());
            }
            if (players.get(i).getStreak() == 5){
                reachedFive.add(players.get(i));
                System.out.println("add player to reachedFive");
            }
        }

        if (reachedFive.size() == 1){
            reachedFive.get(0).increaseScoreBy(points);
        }else if(reachedFive.size() == 2){
            if (reachedFive.get(0).getClickTime() > reachedFive.get(1).getClickTime()){
                reachedFive.get(0).increaseScoreBy(points);
            }else{
                reachedFive.get(1).increaseScoreBy(points);
            }
        }else{
        }

//        ArrayList pos = new ArrayList();
//
//        for(int i=0; i<players.size(); i++){
//            if((players.get(i).getStreak() == 5) && players.get(i).getStatus()){
//                System.out.println("players streak " + players.get(i).getStreak());
//                System.out.println("elegxos ths thermometer");
//                pos.add(i);
//            }
//        }
//
//
//        if(pos.size() == 1){
//            players.get((int) pos.get(0)).increaseScoreBy(points);
//        }else if(pos.size() > 1){
//            int max = (int) pos.get(0);
//            for(int i=1; i<pos.size();i++){
//                if(players.get((int)pos.get(i)).getClickTime() > max){
//                    max = i;
//                }
//            }
//            players.get(max).increaseScoreBy(points);
//        }

    }

    /**
     *
     * @return
     */
    public String getName(){return "Thermometer";}

    /**
     *
     * @return
     */
    public String getExplanation(){
        String explanation = "The first player to answer 5 questions correctly earns 5000 points.";
        return explanation;
    }
}
