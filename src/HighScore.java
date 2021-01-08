import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HighScore {

    private HashMap totalWins;
    private LinkedList<Player> highestScores;
    private static int highScoresNumber = 10;

    public HighScore(){
        totalWins = new HashMap();
        highestScores = new LinkedList<>();
    }

    public void gameStarted(ArrayList<Player> players){
        if(players.size() > 1) {
            loadTotalWinsFromFile("totalwins.dat");
            for (Player player : players) {
                totalWins.put(player.getNickname(), 0); // giati mhden?? den tha prepei na leei poio einai to skor toy paixth?
            }
        }
    }


    public void gameEnded(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1){
           loadHighestScoresFromFile("highscores.dat");

            Player player = players.get(0);

            if(highestScores.size() < highScoresNumber){
                int i = 0;
                while(i<highScoresNumber && !added){

                     if (player.getScore() >= highestScores.get(i).getScore()){
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
            saveHighestScoresToFile("highscores.dat");
            }
        }
        else{
            for(Player player : players){
                    totalWins.put(player.getNickname(), player.getScore()); // mhpws thelei replace?
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

    public void loadTotalWinsFromFile(String file1) {
        boolean empty = true;
        try(BufferedReader br = new BufferedReader(new FileReader(file1))){
            empty = br.readLine() == null;
            if(!empty){
                try{
                    FileInputStream fis = new FileInputStream(file1);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    if((HashMap) ois.readObject() != null){
                        totalWins = (HashMap) ois.readObject();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))){
//            totalWins = (HashMap) ois.readObject();
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
    }

    public void saveHighestScoresToFile(String file2){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))){
            oos.writeObject(highestScores);
        } catch(IOException e){
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
    }






}
