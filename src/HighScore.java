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

    public void gameStart(ArrayList<Player> players){
        if(players.size() > 1) {
//            loadTotalWinsToFile();
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

    public void gameOver(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1){

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
//            if(added){
//            saveHighestScoresToFile();
//            } //eleu8erwse otan ftiakseis to file
        }
        else{
            //save ta scores
//            saveTotalWinsToFile();
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

    public void loadTotalWinsToFile(String file1){
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

    public void loadHighestScoresToFile(String file2){
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
