import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HighScore {

    private HashMap totalWins;
    private LinkedList<Player> highestScores;
    private static int highScoresNumber = 10;
    private String onePlayerModeFile, twoPlayerModeFile;

    public HighScore(String onePlayerModeFile, String towPlayerModeFile){
        totalWins = new HashMap();
        highestScores = new LinkedList<>();
        this.onePlayerModeFile = onePlayerModeFile; //1 player
        this.twoPlayerModeFile = towPlayerModeFile; // 2 players

    }

    public void gameStarted(ArrayList<Player> players){
        if(players.size() > 1) {
            loadTotalWinsFromFile(twoPlayerModeFile);
           // loadTotalWinsFromFile("totalwins.dat");
//            for (Player player : players) {
//                totalWins.put(player.getNickname(), 0); // giati mhden?? den tha prepei na leei poio einai to skor toy paixth?
//            }
        }
    }


    public void gameEnded(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1) {
            loadHighestScoresFromFile(onePlayerModeFile);
            //loadHighestScoresFromFile("highscores.dat");

            Player player = players.get(0);
            if(highestScores.size() == 0){// kalyptei thn periptosh poy to arxeio einai adeio!

                highestScores.add(players.get(0));
                added = true;
            }else if(highestScores.size() < highScoresNumber){
                int i = 0;
                while(i<highScoresNumber && !added && i<highestScores.size()){

                     if (player.getScore() >= highestScores.get(i).getScore() ){ //&& player.getScore()>= 0
                        highestScores.add(i, player);
                        added = true;
                     }
                 i++;
                }

            } else{
                int j = 0;
                while(j<highScoresNumber && !added) {
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
                // saveHighestScoresToFile("highscores.dat");
            }
        }
        else{
            for(Player player : players){
                    totalWins.put(player.getNickname(), player.getScore());
                }
            saveTotalWinsToFile(twoPlayerModeFile);
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

    public void loadTotalWinsFromFile(String file1) {
        try(BufferedReader br = new BufferedReader(new FileReader(file1))){

            if(!(br.readLine() == null)){
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



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
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
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
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



    public HashMap getTotalWins(){
        return totalWins;
    }

    public List<Player> getHighestScores(){
        return highestScores;
    }
//    public LinkedList<Player> getHighestScores(){
//        return highestScores;
//    }



}
