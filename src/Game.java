import java.util.ArrayList;
import java.util.Collections;

/**
 * Game is the class that controls the logical aspects of the game.
 */

public class Game {

    private final ArrayList<Questions> allQuestions;
    private final static int howManyRounds = 3;
    private final static int numberOfQuestions = 3;
    private final Round round;
    private final HighScore scores;
    private int questionPosition = 0;

    /**
     * The constructor initializes the variables for the two files that store the scores and reads the file that
     * contains the questions.
     * @param onePlayerMode name of file for the one player mode
     * @param towPlayerMode name of file for the tow player mode
     */
    public Game(String onePlayerMode, String towPlayerMode) {
        ReadQuestionsFile readQuestionsFile = new ReadQuestionsFile();
        allQuestions = readQuestionsFile.loadQuestions("questions.text.txt");
        scores = new HighScore(onePlayerMode, towPlayerMode);
        round = new Round();
    }

    /**
     * The information from the files that store the scores get loaded and ready to be accessed.
     */
    public void readScores() {
        scores.gameStarted();
    }

    /**
     * @return a String array with all the saved high scores from the file.
     */
    public String[] getHighScores() {
        return scores.getHighestScores();
    }

    /**
     * @return a String array with all of the two-player game scores.
     */
    public String[] getTotalWins() {
        return scores.getTotalWins();
    }

    /**
     * Method createPlayer accepts a String that represents the name of the player, creates a new Player object and
     * returns it.
     * @param name String
     * @return Player
     */
    public Player createPlayer(String name){
        Player player = new Player();
        player.setNickname(name);
        return player;
    }
    /**
     * The questions are rearranged in a random order.
     */
    public void randomizeQuestions() {
        Collections.shuffle(allQuestions);
    }

    /**
     * @return the fixed number of questions for each round.
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * @return the fixed number of rounds for the game.
     */
    public int getHowManyRounds() {
        return howManyRounds;
    }

    /**
     * @return selects an acceptable random type, depending on the game mode (1-player, 2-player), for the round
     * creates and returns the analogue object.
     * @param playerList an array list of players
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
     * @return the next question from the arrayList of random questions
     */
    public Questions getNewQuestion() {
        questionPosition++;
        return allQuestions.get(questionPosition);
    }

    /**
     * This method accepts a question and if it is too long, splits it in two parts and adds a break point.
     * @param question is the current question.
     * @return String with the new split.
     */
    public String splitTheQuestion(Questions question){
        StringBuilder tooLong;
        String q = question.getQuestion();
        if(q.length() > 60){
            tooLong = new StringBuilder("<html>");
            for (String part: q.split("\\* ",2))
            {
                tooLong.append(part).append("<br/>");
            }
            tooLong.append("<html>");
            q = tooLong.toString();
        }
        return q;
    }

    /**
     * This method accepts the list of the playing users, the list with their answers and the correct answer for the
     * question that was asked and set the status of the players that answered correctly to true.
     * @param answers an arrayList of Strings which are the answers that were clicked by the players.
     * @param correctAnswer the String with the right answer for the question that was asked.
     * @param playerList the list of the players that are currently playing.
     * @return the list of the players with the updated statuses.
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
     * This method sets the clickTime for the players depending on the type of game they are playing. StopTheTimer
     * needs to save the time that was left after the player's click and QuickAnswer and Thermometer need to save the
     * milliseconds that passed until the player's click in order to gather the needed information for updating the
     * scores later.
     * @param clickTimes an array of long variables that stores the system time in milliseconds of the moment that the
     *                   player answered the question.
     * @param startTime is the moment that the question appeared on the screen in milliseconds.
     * @param type the type of round that the players are currently playing.
     * @param playerList the list of the players.
     */
    public void setTime(long[] clickTimes, long startTime, Type type, ArrayList<Player> playerList) {
        if(type  instanceof StopTheTimer){
            for (int i = 0; i < playerList.size(); i++) {
                long timeLeft = startTime+10000 - clickTimes[i] ;
                playerList.get(i).getWallet().setClickTime(timeLeft);
            }

        }
        if (playerList.size() > 1) {
            if (type instanceof QuickAnswer || type instanceof Thermometer) {
                for (int i = 0; i < playerList.size(); i++) {
                    playerList.get(i).getWallet().setClickTime(clickTimes[i] - startTime );
                }
            }
        }
    }

    /**
     * Changes the score of all the players depending on the type of round they are currently playing.
     * @param type the type of the round for the last question.
     */
    public void changePoints(Type type) {
        type.changePoints();
    }

    /**
     * Returns all the variables in a player that were changed after each question temporarily to their default state.
     * @param playerList the list of all the players
     * @param type the type of round the question the players just answered belonged to
     */
    public void defaultifyPlayers(ArrayList<Player> playerList, Type type){
        for (Player player: playerList){
            player.setStatus(false);
            if(type instanceof Bet){
                player.getWallet().defaultifyBet();
            }
        }
    }

    /**
     * When the game ends, this method gets the list of the players and saves their scores in the file if needed.
     * @param playerList the list of the players that played the game.
     */
    public void gameEnd(ArrayList<Player> playerList){
        scores.gameEnded(playerList);
    }

}