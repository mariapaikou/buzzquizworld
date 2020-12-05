

import java.util.ArrayList;
import java.util.Collections;


/**
 * This class is initializing the players of the game also it makes a new round object.
 */

public class Game {
    /**
     * @param playerList is an ArrayList that stores Player objects.
     * @param randomQuestions is an Arraylist that stores the (three) Questions objects that are
     *                        randomly selected by a Round method.
     * @param allQuestions is an ArrayList that contains all of the questions read from the file.
     * @param howManyRounds is a static int that indicates the preferable number of rounds.
     * @param numberOfQuestions is a static int that indicates the number of questions for each round.
     * @param display is a UserInteraction object that is used to display messages to the user and receive information from him.
     */
    //private int howManyPlayers;
    private ArrayList <Player> playerList;
    private ArrayList<Questions> allQuestions;
   // private ArrayList<Questions> randomQuestions;
    private static int howManyRounds = 3;
    private static int numberOfQuestions = 1; //gia twra
    private UserInteraction display;


/**
 * Constructor
 */
    public Game(){

        display = new UserInteraction();
       // howManyPlayers = a.HowManyOfYou();
       // howManyRounds = a.HowManyRounds();

        playerList = new ArrayList<>();
       // for (int i = howManyPlayers; i > 0; i--) {
            playerList.add(display.God());
       // }

        //randomQuestions = new ArrayList<>();

        allQuestions = new ArrayList<>();
    }


    public ArrayList<Player> getPlayerList() { return playerList; }

    /**
     * Function PlayTheGame starts off by calling the fillAllQuestions method which fills the ArrayList with
     * Questions objects. It has a while loop that controls the number of rounds. Each time it creates a Round object
     * and a type that is randomly chosen by the Round objects method, getRandomType. Then it sets the type object's player
     * list to the list that Game has. A while loop is used to control the amount of questions that will be asked for the round.
     * It calls the getRandomQuestion from round and a for loop it asks the questions one by one, accepts the answers from the
     * players and checks if they are correct. Then is adjusts the status of the players, displays the correct answer and the winners
     * and changes their points.
     */
    public void PlayTheGame(){
        fillAllQuestions();
        randomizeQuestions(allQuestions);
        int questionsAskedAlready = 0;

        while(howManyRounds > 0){

            int num = numberOfQuestions;
            Round round = new Round();
            Type type = round.getRandomType();
            type.SetPlayersList(playerList);

            display.announcingTheType(type);


           while (num > 0){

                display.askTheQuestion(allQuestions.get(questionsAskedAlready));
                int position = 0;
                for (Player player : playerList){

                    if(type instanceof Bet){
                        type.setPoints(display.betPoints(), position) ;
                    }

                    String answer = display.getAnAnswer(player);

                    boolean correct = allQuestions.get(questionsAskedAlready).acceptableAnswer(answer);

                    while (!correct){
                        answer = display.getNewAnswer(player);
                        correct = allQuestions.get(questionsAskedAlready).acceptableAnswer(answer);
                    }
                    if (answer.equals(allQuestions.get(questionsAskedAlready).getCorrectAnswer())){
                        player.setStatus(true);
                    }

                }
                display.correctAnswer(allQuestions.get(questionsAskedAlready));
                display.whoWon(playerList);
                type.changePoints();

                for (Player player : playerList){
                    player.defaultfyStatus();
                }
                questionsAskedAlready++;
                num--;
            }
            display.showRoundScores(playerList);
            howManyRounds--;
        }
    }

    /**
     * Temporary method fillAllQuestions that creates Questions objects and adds them to the ArrayList.
     */

    private void fillAllQuestions(){
        Questions a = new Questions("Which nut is used to make dynamite?", "Peanuts", "Walnuts", "Pine nuts", "Almonds", "Peanuts", "Food");
        allQuestions.add(a);

        Questions b = new Questions("When was the band System of a Down formed?", "1988", "1987", "1990", "1992", "1988", "Music");
        allQuestions.add(b);

        Questions c = new Questions("How many films have Al Pacino and Robert De Niro starred in together?", "10", "6", "2", "4", "4", "Films");
        allQuestions.add(c);
    }

    /**
     * Function randomizeQuestions accepts allQuestions and randomly arranges the ArrayList
     * @param allQuestions is the ArrayList that contains all the Questions objects available
     */
    private void randomizeQuestions(ArrayList<Questions> allQuestions){
        Collections.shuffle(allQuestions);
    }



    public static void main(String [] args){
        Game b = new Game();
        b.PlayTheGame();
        System.out.println("the end!!");
    }


}

