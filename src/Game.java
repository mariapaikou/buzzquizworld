import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class stores the list with the players, the questions and controls the whole game.
 * @author Theodora-Sofia Tsochataridou
 * @author Maria Paikou
 * @version 1.0
 * @since 05 - December - 2020
 */


public class Game {
    //    private ArrayList <Player> playerList;
    private ArrayList<Questions> allQuestions;
    private static int howManyRounds = 1;
    private int numberOfQuestions = 2; //edw tha prepei na problepoyme gia thn thermometer! mhpws na to baloyme mesa sthn type?
    // private final UserInteraction display;
    private Round round; // einai swsto to final???
    private ReadQuestionsFile readQuestionsFile;
    private HighScore scores;
    private int questionPosition = 0;




    /**
     * The constructor initializes the UserInteraction object and the two ArrayLists, one for the
     * players and one for the questions. For the players, it calls the God method from UserInteraction.
     *
     * @value playerList is an ArrayList that stores Player objects.
     * @value randomQuestions is an Arraylist that stores the (three) Questions objects that are
     * randomly selected by a Round method.
     * @value allQuestions is an ArrayList that contains all of the questions read from the file.
     * @value howManyRounds is a static int that indicates the preferable number of rounds.
     * @value numberOfQuestions is a static int that indicates the number of questions for each round.
     * @value display is a UserInteraction object that is used to display messages to the user and receive information from him.
     */

    public Game() {
        readQuestionsFile = new ReadQuestionsFile();
        allQuestions = readQuestionsFile.loadQuestions("questions.text.txt");
        scores = new HighScore("highscores.dat", "totalwins.dat");
        round = new Round();

    }

    public int getHowManyRounds() {
        return howManyRounds;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void readScores() {
        scores.gameStarted();
    }




    public String[] getHighScores() {
        return scores.getHighestScores();
    }

    public String[] getTotalWins() {
        return scores.getTotalWins();
    }
    /**
     * Method getRandomType returns a random type of game
     *
     * @return Type
     */

    public Type getRandomType(ArrayList<Player> playerList) {
        Type type;

        if (playerList.size() == 1) {
            type = round.onePlayerMode();
        } else {
            type = round.towPlayerMode();
        }

        type.setPlayersList(playerList);
        return type;
    }

    /**
     * Method getNewQuestion returns the question located at the questionPosition position of the allQuestions array
     *
     * @return Question
     */
    public Questions getNewQuestion() {
        questionPosition++;
        return allQuestions.get(questionPosition);
    }

    /**
     * @param answers
     * @param correctAnswer
     * @param playerList
     * @return
     */

    public ArrayList<Player> setStatuses(ArrayList<String> answers, String correctAnswer, ArrayList<Player> playerList) {
        if (playerList.size() == 1) {
            if (answers.get(0).equals(correctAnswer)) {
                playerList.get(0).setStatus(true);
            }
        } else {
            for (int i = 0; i < playerList.size(); i++) {
                if (answers.get(i).equals(correctAnswer)) {
                    playerList.get(i).setStatus(true);
                }
            }
        }
        return playerList;
    }

    /**
     * @param clickTimes
     * @param startTime
     * @param type
     */

    public void setTime(long[] clickTimes, long startTime, Type type, ArrayList<Player> playerList) {
        if (playerList.size() > 1) {
            if (type instanceof StopTheTimer) {
                for (int i = 0; i < playerList.size(); i++) {
                    long timeLeft = 5000 - clickTimes[i];
                    playerList.get(i).setClickTime(timeLeft);
                }


            } else if (type instanceof QuickAnswer || type instanceof Thermometer) {
                for (int i = 0; i < playerList.size(); i++) {
                    playerList.get(i).setClickTime(startTime - clickTimes[i]);
                }
            }

        }

    }

    /**
     * Method changePoints calls the right changePoints method in order to change Players points after every question
     *
     * @param type is te type that the changePoints is going to use
     */
    public void changePoints(Type type) {
        type.changePoints();
    }

    /**
     *
     * @param playerList
     * @param type
     */
    public void defaultifyPlayers(ArrayList<Player> playerList, Type type){
        for (Player player: playerList){
            player.setStatus(false);
            if(type instanceof Bet){
                player.defaultifyBet();
            }
        }
    }

    /**
     *
     * @param playerList
     * @return
     */
    public boolean checkStreak(ArrayList<Player> playerList){
        boolean someoneWon = false;
        for(Player player : playerList){
            if(player.getStreak() == 5){
                someoneWon = true;
                break;
            }
        }
        return someoneWon;
    }


    /**
     * Function initializePlayersScore is a void function that sets every players score back to 0 by calling Player's
     * method initializePlayersScore.
     */
    public void initializePlayersScore(ArrayList<Player> playerList) {

        for (Player player : playerList) {
            player.initializeScore();
        }

    }


    /**
     * Method randomizeQuestions  shuffles the allQuestions ArrayList.
     *
     * @value allQuestions is the ArrayList that contains all the Questions objects available.
     */
    public void randomizeQuestions() {
        Collections.shuffle(allQuestions);
    }


    public void gameEnd(ArrayList<Player> playerList){
        scores.gameEnded(playerList);
    }

}