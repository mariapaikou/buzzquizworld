import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HighScore {
    private HashMap totalWins;
    private LinkedList<Player> highestScores;

    public HighScore(){
        totalWins = new HashMap();
        highestScores = new LinkedList<>();
    }

    public void gameStarted(ArrayList<Player> players){
        if(players.size() > 1) {
            loadTotalWinsFromFile("totalwins.dat");
            for (Player player : players) {
                totalWins.put(player.getNickname(), 0);
            }
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

    public void gameEnded(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1){
           loadHighestScoresFromFile("highscores.dat");

            Player player = players.get(0);

            if(highestScores.size() < 5){
                int i = 0;
                while(i<5 && !added){

                     if (player.getScore() >= highestScores.get(i).getScore()){
                        highestScores.add(i, player);
                        added = true;
                     }
                 i++;
                }

            } else{
                int j = 0;
                while(j<5 && !added) {
                    if (player.getScore() >= highestScores.get(j).getScore()){
                        highestScores.add(j, player);
                        highestScores.removeLast();
                        added = true;
                    }
                    j++;
                }
            }
            if(added){
            saveHighestScoresToFile("highscores.dat");
            }
        }
        else{
            for(Player player : players){
                    totalWins.put(player.getNickname(), player.getScore());
                }
            saveTotalWinsToFile("totalwins.dat");
        }


    }

    public void saveTotalWinsToFile(String file1){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1))){
            oos.writeObject(totalWins);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadTotalWinsFromFile(String file1){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))){
            totalWins = (HashMap) ois.readObject();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveHighestScoresToFile(String file2){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))){
            oos.writeObject(highestScores);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadHighestScoresFromFile(String file2){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2))){
            highestScores = (LinkedList<Player>) ois.readObject();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }






}
