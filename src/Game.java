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
    private ArrayList <Player> playerList;
    private ArrayList<Questions> allQuestions;
    private static int howManyRounds = 3;
    private  int numberOfQuestions = 5; //edw tha prepei na problepoyme gia thn thermometer! mhpws na to baloyme mesa sthn type?
   // private final UserInteraction display;
    private Round round; // einai swsto to final???
    private ReadQuestionsFile readQuestionsFile;
    private  HighScore scores;
    private int questionPosition = 0;


    /**
     * Method setPlayerList sets the playerList and loads the files by calling the gameStarted method
     * @param playerList the arrayList that contains the players for this game
     */
    public void setPlayerList(ArrayList<Player> playerList){
        this.playerList = playerList;
        scores.gameStarted();
    }
    public ArrayList <Player> getPlayerList(){
        return playerList;
    }
    public int getHowManyRounds(){
        return howManyRounds;
    }
    public int getNumberOfQuestions(){
        return numberOfQuestions;
    }
    public void setHowManyRounds(int howManyRounds){this.howManyRounds = howManyRounds;}
    public void setNumberOfQuestions(int numberOfQuestions){this.numberOfQuestions = numberOfQuestions;}
    public List<Player> getHighScores(){
        return scores.getHighestScores();
    }
    public ArrayList<Player> getTotalWins(){
        return scores.getTotalWins();
    }

/**
 * The constructor initializes the UserInteraction object and the two ArrayLists, one for the
 * players and one for the questions. For the players, it calls the God method from UserInteraction.
 * @value playerList is an ArrayList that stores Player objects.
 * @value randomQuestions is an Arraylist that stores the (three) Questions objects that are
 * randomly selected by a Round method.
 * @value allQuestions is an ArrayList that contains all of the questions read from the file.
 * @value howManyRounds is a static int that indicates the preferable number of rounds.
 * @value numberOfQuestions is a static int that indicates the number of questions for each round.
 * @value display is a UserInteraction object that is used to display messages to the user and receive information from him.
 */

    public Game(){
        readQuestionsFile = new ReadQuestionsFile();
        allQuestions = readQuestionsFile.loadQuestions("questions.text.txt");
        scores = new HighScore("highscores.dat","totalwins.dat");
        round = new Round();

    }

    /**
     * Method getRandomType returns a random type of game
     * @return Type
     */


    public Type getRandomType(){
        Type type;

        if(playerList.size() == 1){
            type = round.towPlayerMode();
        }else{
            type = round.onePlayerMode();
        }

        type.setPlayersList(playerList);
        return type;
    }

    /**
     * Method getNewQuestion returns the question located at the questionPosition position of the allQuestions array
     * @return Question
     */
    public Questions getNewQuestion(){
        questionPosition++;
        return allQuestions.get(questionPosition);
    }

    /**
     * Method changePoints calls the right changePoints method in order to change Players points after every question
     * @param type is te type that the changePoints is going to use
     */
    private void changePoints(Type type){
        type.changePoints();
    }

    /**
     * Function setBetInitialBehaviour gets as parameter a Type object and checks if it is an instance of Bet/........
     * Then it sets the initialBehaviour for each bet type.
     * It calls Bet's method setPoints to initialize player's betPoints for this question.
     * @param type a type object that represents the type of game being played at the moment.
     * @param bets an int array that contains the players bet in the same order as they are placed in the playerList
     */
    public void setBetInitialBehaviour(Type type, int [] bets) {

        if (type instanceof Bet) {
            for (int i = 0; i < playerList.size(); i++) {

                ((Bet) type).setPoints(bets[i]);
            }
//        }else if (type instanceof Timer) {
//            // tha friaxnoyme to Timer antikeimeno!!!
//            //TODO mhpws prepei na einai mesa sthn Timer? h sthn UserIneraction!!!!
//        }
        }
    }

    /**
     * Function setTypeInitialStatus gets as parameter a Type object and checks if it is an instance of Bet/..........
     * Thet it sets the initialStatus for each type of game.
     * For Bet it initialize position to 0
     * @param type a type object created by playTheGame that represents the type of game being played at the moment.
     */
    public void setTypeInitialStatus(Type type){

        if(type instanceof Bet){
            ((Bet) type).initializePositions();
        }
        // TODO xreiazetai kati gia ta alla types???
    }



    /**
     * Function initializePlayersScore is a void function that sets every players score back to 0 by calling Player's
     * method initializePlayersScore.
     */
    public void initializePlayersScore(){

        for(Player player : playerList){
            player.initializeScore();
        }

    }


    /**
     * Method randomizeQuestions  shuffles the allQuestions ArrayList.
     * @value allQuestions is the ArrayList that contains all the Questions objects available.
     */
    public void randomizeQuestions(){
        Collections.shuffle(allQuestions);
    }


    /**
     *The man, the myth, the legend ... the main.
     * It creates the Game object which contains the whole game and asks
     * the player after the game is done if he wants to play again.
     */
    public static void main(String [] args){

        boolean play = true;
       // Scanner input = new Scanner(System.in);
        Game b = new Game();
        UserInteraction a = new UserInteraction();


//        while(play){

          //  b.PlayTheGame();
            //TODO na paei sthn userInteraction
//            String answer = a.replay();

//            if(answer.equals("no")) {
//                play = false;
//            }

//        }

    }
    //SKOUPIDIA

/*
    public ArrayList<Player> getPlayerList() { return playerList; }
 */

//    /**
//     * Function PlayTheGame starts off by calling the fillAllQuestions method which fills the ArrayList with
//     * Questions objects which then randomizes with the randomizeQuestions method. It has a while loop that controls
//     * the number of rounds. Each time it creates a Round object and a type that is randomly chosen by the Round objects method,
//     * getRandomType. Then it sets the type object's player list to the list that Game has. A while loop is used to control the amount
//     * of questions that will be asked for the round. It prints the questions one by one, accepts the answers from the
//     * players and checks if they are correct. Then it adjusts the status of the players, displays the correct answer and the winners
//     * and changes their points.
//     */
//    public void PlayTheGame(){
//
//       // fillAllQuestions();
//      //  randomizeQuestions();
//        int questionNum = 0;
//
//        while(howManyRounds > 0){
//
//            int num = numberOfQuestions;
//            //Round round = new Round(); // to ebala ston consturctor kai nomizw doyleysei swsta!
//
//           // Type type = round.getRandomType();
//          //  type.setPlayersList(playerList);
//
//            while (num > 0){
//
//                display.announcingTheType(type);
//                display.announcingCategory(allQuestions.get(questionNum));
//                setTypesInitialBehaviour(type);
//                display.askTheQuestion(allQuestions.get(questionNum));
//
//                for (Player player : playerList){
//                    String answer = display.getAnAnswer(player);
//                    //String answer = getPlayersAnswer(player,questionNum);
//
//                    if (answer.equals(allQuestions.get(questionNum).getCorrectAnswer())){
//                        player.setStatus(true);
//                    }
//
//                }
//
//                display.correctAnswer(allQuestions.get(questionNum));
//                display.whoWon(playerList);
//                type.changePoints();
//                setTypeInitialStatus(type);
//               // defaultfyPlayersStatus(); ginetai mesa stis changePoints!
//                questionNum++;
//                num--;
//
//            }
//            display.showRoundScores(playerList);
//            howManyRounds--;
//        }
//        display.finalScores(playerList);
//        howManyRounds = 3; //mhpws prepei na ginei stathera gia eykolia synthrhshs!
//        initializePlayersScore();
//
//    }


//
//    /**
//     * Function getPlayersAnswer calls UserInteraction method getAnswer to get an answer to the question asked and checks
//     * if answer is an acceptable value by calling UserInteractions method acceptableAnswer.
//     * @param player
//     * @param questionNum
//     * @return answer String value that contains player's answer to the question asked
//     */
// NO NEED
//     private String getPlayersAnswer(Player player, int questionNum){
//
//         String answer = display.getAnAnswer(player);
//         boolean correct = allQuestions.get(questionNum).acceptableAnswer(answer);
//
////         while (!correct){
////             answer = display.getNewAnswer(player);
////             correct = allQuestions.get(questionNum).acceptableAnswer(answer);
////         }
//        return answer;
//
//    }

    // display = new UserInteraction();

    // int howManyPlayers = display.HowManyOfYou();

    // playerList = display.God(howManyPlayers);
//        for (int i = howManyPlayers; i > 0; i--) {
//            playerList.add(display.God());
//        }

}

