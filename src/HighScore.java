import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HighScore {
    private ArrayList<Player> players;
    private HashMap totalWins;
    private String[] highestScores;

    public HighScore(){
        players = new ArrayList<>();
        totalWins = new HashMap();
        highestScores = new String[5];
    }

    public HighScore(ArrayList<Player> players){
        this.players = players;
        totalWins = new HashMap();
        highestScores = new String[5];
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
            highestScores = (String[]) ois.readObject();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }






}
