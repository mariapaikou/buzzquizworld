import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HighScore {

    private ArrayList<Player> totalWins;
    private LinkedList<Player> highestScores;
    private final String onePlayerModeFile;
    private final String twoPlayerModeFile;

    public HighScore(String onePlayerModeFile, String towPlayerModeFile){
        totalWins = new ArrayList<>();
        highestScores = new LinkedList<>();
        this.onePlayerModeFile = onePlayerModeFile; //1 player
        this.twoPlayerModeFile = towPlayerModeFile; // 2 players

    }

    public void gameStarted(){
            loadHighestScoresFromFile(onePlayerModeFile);
            loadTotalWinsFromFile(twoPlayerModeFile);
//        if(players.size() > 1) {
//            loadTotalWinsFromFile(twoPlayerModeFile);
//        }else if(players.size() == 1){
//            loadHighestScoresFromFile(onePlayerModeFile);
//        }

    }


    public void gameEnded(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1) {
            //loadHighestScoresFromFile(onePlayerModeFile);
            //loadHighestScoresFromFile("highscores.dat");

            Player player = players.get(0);
            int highScoresNumber = 10;
            if(highestScores.size() == 0){// kalyptei thn periptosh poy to arxeio einai adeio!

                highestScores.add(players.get(0));
                added = true;
            }else if(highestScores.size() < highScoresNumber){
                int i = 0;
                while(i< highScoresNumber && !added && i<highestScores.size()){

                     if (player.getScore() >= highestScores.get(i).getScore() ){ //&& player.getScore()>= 0
                        highestScores.add(i, player);
                        added = true;
                     }
                 i++;
                }

            } else{
                int j = 0;
                while(j< highScoresNumber && !added) {
                    if (player.getScore() >= highestScores.get(j).getScore()){
                        highestScores.add(j, player);
                        highestScores.removeLast();
                        added = true;
                    }
                    j++;
                }
            }
            if(added){
                saveHighestScoresToFile(onePlayerModeFile);
                loadHighestScoresFromFile(onePlayerModeFile);
                System.out.println("list of highestscores is now :");
                for(Player player1 : highestScores){

                    System.out.println(player1.getNickname());
                }
                System.out.println(".............................");
            }
        }
        else{
            totalWins.addAll(players);
            saveTotalWinsToFile(twoPlayerModeFile);
        }


    }

    public void saveTotalWinsToFile(String file1){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1))){
            oos.writeObject(totalWins);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadTotalWinsFromFile(String file1) {

                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))){
                     totalWins = (ArrayList<Player>) ois.readObject();
                } catch(IOException | ClassNotFoundException e){
                      e.printStackTrace();
                }

    }

    public void saveHighestScoresToFile(String file2){
        if(highestScores.size() !=0){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))){
                oos.writeObject(highestScores);
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    public void loadHighestScoresFromFile(String file2)  {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2))) {
                        highestScores = (LinkedList<Player>) ois.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }


    }


//    public void roundOver(ArrayList<Player> players){
//        if(players.size() == 1){
//            //nothing
//        }
//        else{
//            for(Player player : players){
//                if(player.getStatus()){
//                    totalWins.replace(player.getNickname(), totalWins.get(player.getNickname()+1));
//                }
//            }
//
//        }
//
//    }


    /**
     *
     */
    public String[] getTotalWins() {
        String[] list;
        if (totalWins.size() == 0) {
            list = new String[]{"There are no total wins yet!"};
        } else {
            list = new String[(totalWins.size() - 1) / 2];
            for (int i = 0; i < list.length; i += 2) {
                list[i] = (totalWins.get(i).getNickname() + " " + totalWins.get(i).getScore() + " " + totalWins.get(i + 1).getNickname() + " " + totalWins.get(i + 1).getScore());
            }
        }
        System.out.println(list);
        return list;
    }


    public String [] getHighestScores(){
        String [] list;
        if(highestScores.size() == 0){
            list = new String[]{"There are no high scores yet!"};
        }else{
            list= new String[highestScores.size()-1];
            for(int i=0; i<highestScores.size();i++){
                list[i] = (highestScores.get(i).getNickname() + " " + highestScores.get(i).getScore());
            }
        }
        System.out.println(list);
        return list;
    }
//
//    public ArrayList<Player> getTotalWins(){
//        return totalWins;
//    }
//
//    public List<Player> getHighestScores(){
//        return highestScores;
//    }
////    public LinkedList<Player> getHighestScores(){
////        return highestScores;
////    }



}
