import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class HighScore is the manager of the totalwins.dat and highscores.dat files which store the info for the total scores
 * of every game in the two player mode game and the 10 best scores in the one player mode game.
 */
public class HighScore {

    private ArrayList<Player> totalWins;
    private LinkedList<Player> highestScores;
    private final String onePlayerModeFile;
    private final String twoPlayerModeFile;

    /**
     * Constructor
     * @param onePlayerModeFile file for the 10 best scores
     * @param towPlayerModeFile file for the total plays
     */
    public HighScore(String onePlayerModeFile, String towPlayerModeFile){
        totalWins = new ArrayList<>();
        highestScores = new LinkedList<>();
        this.onePlayerModeFile = onePlayerModeFile;
        this.twoPlayerModeFile = towPlayerModeFile;

    }

    /**
     * Method gameStarted loads the data from the onePlayerModeFile and the towPlayerModeFile
     */
    public void gameStarted(){
            loadHighestScoresFromFile(onePlayerModeFile);
            loadTotalWinsFromFile(twoPlayerModeFile);
    }

    /**
     * Method gameEnded accepts an arrayList of players. If we are at the one player mode it changes the
     * onePlayerModeFile accordingly. If we are at the tow player mode it stores the players to the towPlayerModeFile.
     * @param players ArrayList<Players>
     */
    public void gameEnded(ArrayList<Player> players){
        boolean added = false;
        if(players.size() == 1) {

            Player player = players.get(0);
            int highScoresNumber = 10;
            if(highestScores.size() == 0){

                highestScores.add(players.get(0));
                added = true;
            }else if(highestScores.size() < highScoresNumber){
                int i = 0;
                while(i< highScoresNumber && !added && i<highestScores.size()){

                     if (player.getScore() >= highestScores.get(i).getScore() ){
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
            }
        }
        else{
            totalWins.addAll(players);
            saveTotalWinsToFile(twoPlayerModeFile);
        }

    }


    /**
     * Method saveTotalWinsToFile accepts a string that represents the name of a file and stores the data form the total
     * wins of the tow player mode game to that file.
     * @param file1 String
     */
    private void saveTotalWinsToFile(String file1){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1))){
            oos.writeObject(totalWins);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method loadTotalWinsFromFile accepts a string that represents the name of a file and loads the data of the total
     * wins to the tow player mode game to, form the file to the correct data structure.
     * @param file1 String
     */
    private void loadTotalWinsFromFile(String file1) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))){
            totalWins = (ArrayList<Player>) ois.readObject();
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method saveHighestScoresToFile accepts a string that represents the name of a file and saves the data of the
     * highest scores in the one player mode game to that file.
     * @param file2 String
     */
    private void saveHighestScoresToFile(String file2){
        if(highestScores.size() !=0){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2))){
                oos.writeObject(highestScores);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Method leadHighestScoresFromFile accepts a string that represents the name of a file and loads the data of the
     * tow player mode game, from the file to the correct data structure.
     * @param file2 String
     */
    private void loadHighestScoresFromFile(String file2)  {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2))) {
            highestScores = (LinkedList<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
        }


    }


    /**
     * Method getTotalWins returns a String array that contains the total wins data in the tow player mode game.
     * @return String[]
     */
    public String[] getTotalWins() {
        String[] list;

        if (totalWins.size() == 0) {
            list = new String[]{"There are no total wins yet!"};
        } else {
            list = new String[(totalWins.size())];
            for (int i = 0; i < list.length; i += 2) {
                list[i] = (totalWins.get(i).getNickname() + " " + totalWins.get(i).getScore() + " " + totalWins.get(i + 1).getNickname() + " " + totalWins.get(i + 1).getScore());
            }
        }
        return list;
    }

    /**
     * Method getHighestScore returns a String array that contains the data of the highest scores in the one player mode
     * game.
     * @return String[]
     */
    public String [] getHighestScores(){
        String [] list;
        if(highestScores.size() == 0){
            list = new String[]{"There are no high scores yet!"};
        }else{
            list= new String[highestScores.size()];
            for(int i=0; i<highestScores.size();i++){
                list[i] = (highestScores.get(i).getNickname() + " " + highestScores.get(i).getScore());
            }
        }
        return list;
    }


}
