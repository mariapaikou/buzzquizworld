import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class stores the list with the players, the questions and controls the whole game.
 * @author Theodora-Sofia Tsochataridou
 * @author Maria Paikou
 * @version 1.0
 * @since 05 - December - 2020
 */


public class Game {
    /**
     * @value playerList is an ArrayList that stores Player objects.
     * @value randomQuestions is an Arraylist that stores the (three) Questions objects that are
     *                        randomly selected by a Round method.
     * @value allQuestions is an ArrayList that contains all of the questions read from the file.
     * @value howManyRounds is a static int that indicates the preferable number of rounds.
     * @value numberOfQuestions is a static int that indicates the number of questions for each round.
     * @value display is a UserInteraction object that is used to display messages to the user and receive information from him.
     */
    //private int howManyPlayers;
    private final ArrayList <Player> playerList;
    private final ArrayList<Questions> allQuestions;
   // private ArrayList<Questions> randomQuestions;
    private static int howManyRounds = 3;
    private final static int numberOfQuestions = 1; //gia twra
    private final UserInteraction display;


/**
 * The constructor initializes the UserInteraction object and the two ArrayLists, one for the
 * players and one for the questions. For the players, it calls the God method from UserInteraction.
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

/*
    public ArrayList<Player> getPlayerList() { return playerList; }
 */

    /**
     * Function PlayTheGame starts off by calling the fillAllQuestions method which fills the ArrayList with
     * Questions objects which then randomizes with the randomizeQuestions method. It has a while loop that controls
     * the number of rounds. Each time it creates a Round object and a type that is randomly chosen by the Round objects method,
     * getRandomType. Then it sets the type object's player list to the list that Game has. A while loop is used to control the amount
     * of questions that will be asked for the round. It prints the questions one by one, accepts the answers from the
     * players and checks if they are correct. Then it adjusts the status of the players, displays the correct answer and the winners
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

            while (num > 0){
                display.announcingTheType(type);

                for (Player player : playerList){

                    display.announcingCategory(allQuestions.get(questionsAskedAlready));
                    setTypesInitialBehaviour(type);
                    display.askTheQuestion(allQuestions.get(questionsAskedAlready));
                    String answer = getPlayersAnswer(player,questionsAskedAlready);

                    if (answer.equals(allQuestions.get(questionsAskedAlready).getCorrectAnswer())){
                        player.setStatus(true);
                    }

                }
                display.correctAnswer(allQuestions.get(questionsAskedAlready));
                display.whoWon(playerList);
                type.changePoints();

                setTypeInitialStatus(type);

                defaultfyPlayersStatus();
                questionsAskedAlready++;
                num--;
            }
            display.showRoundScores(playerList);
            howManyRounds--;
        }
        display.finalScores(playerList);
        howManyRounds = 3;
        initializePlayersScore();
    }

    /**
     * Function getPlayersAnswer calls UserInteraction method getAnswer to get an answer to the question asked and checks
     * if answer is an acceptable value by calling UserInteractions method acceptableAnswer.
     * @param player
     * @param questionsAskedAlready
     * @return answer String value that contains player's answer to the question asked
     */

     private String getPlayersAnswer(Player player, int questionsAskedAlready){
         String answer = display.getAnAnswer(player);
         boolean correct = allQuestions.get(questionsAskedAlready).acceptableAnswer(answer);

         while (!correct){
             answer = display.getNewAnswer(player);
             correct = allQuestions.get(questionsAskedAlready).acceptableAnswer(answer);
         }
        return answer;
    }






    /**
     * Function setTypesInitialBehaviour gets as parameter a Type object and checks if it is an instance of Bet/........
     * Then it sets the initialBehaviour for each type of game.
     * For Bet it calls UserInteraction method betPoints to get betPoints from the player and then it calls Bet's method
     * setPoints to initialize player's betpoints for this question.
     * @param type a type object created by playTheGame that represents the type of game being played at the moment.
     */
    private void setTypesInitialBehaviour(Type type){
        if(type instanceof Bet){
            int points = display.betPoints();

            while(points != 250 && points != 500 && points != 750 && points != 1000){
                points = display.newBetPoints();
            }
            ((Bet) type).setPoints(points);
        }
    }


    /**
     * Function setTypeInitialStatus gets as parameter a Type object and checks if it is an instance of Bet/..........
     * Thet it sets the initialStatus for each type of game.
     * For Bet it initialize position to 0
     * @param type a type object created by playTheGame that represents the type of game being played at the moment.
     */
    private void setTypeInitialStatus(Type type){
        if(type instanceof Bet){
            ((Bet) type).initializePositions();
        }
    }



    /**
     * Function initializePlayersScore is a void function that sets every players score back to 0 by calling Player's
     * method initializePlayersScore.
     */
    private void initializePlayersScore(){
        for(Player player : playerList){
            player.initializeScore();
        }
    }




    /**
     * Function defaultfyPlayersStatus is a void function that sets players status back to false by calling Player's method
     * defaultfyStatus
     */
    private void defaultfyPlayersStatus(){
        for (Player player : playerList){
            player.defaultfyStatus();
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

        Questions d = new Questions("Who invented Coca-Cola?", "John Pemberton", "Asa Griggs Candler", "Charles Elmer Hires", "John Matthews", "John Pemberton", "Food");
        allQuestions.add(d);

        Questions e = new Questions("On an email, what does \"CC\" stand for?", "Carbon Copy", "Course Corrected", "Check Core", "Can't Complete", "Carbon Copy", "Technology");
        allQuestions.add(e);

        Questions f = new Questions("Which of these social media platforms was launched in 2010? ", "Twitter", "Myspace", "Facebook", "Instagram", "Instagram", "Technology");
        allQuestions.add(f);

        Questions g = new Questions("What year was the first Toy Story film released in cinemas?", "1995", "1999", "2001", "1992", "1995", "Films");
        allQuestions.add(g);

        Questions h = new Questions("Which computer programming language was known for its \"turtle graphics\"?", "Logo", "Python", "COBOL", "C++", "Logo","Technology");
        allQuestions.add(h);

        Questions i = new Questions("How many moons does Mars have in all?", "0", "5", "8", "2", "2","Science");
        allQuestions.add(i);

        Questions j = new Questions("What is the largest organ in the human body?", "Heart", "Large Intestine", "Lungs", "Skin", "Skin", "Science");
        allQuestions.add(j);
    }

    /**
     * Function randomizeQuestions accepts allQuestions and shuffles the ArrayList.
     * @value allQuestions is the ArrayList that contains all the Questions objects available.
     */
    private void randomizeQuestions(ArrayList<Questions> allQuestions){
        Collections.shuffle(allQuestions);
    }


    /**
     *The man, the myth, the legend ... the main.
     * It creates the Game object which contains the whole game and asks
     * the player after the game is done if he wants to play again.
     */
    public static void main(String [] args){

        boolean play = true;
        Scanner input = new Scanner(System.in);
        Game b = new Game();

        while(play){

            b.PlayTheGame();

            System.out.println("THE END");
            System.out.println("Play again? (yes or no)");
            String answer = input.nextLine();

            while (!answer.equals("yes")  && !answer.equals("no")){
                System.out.println("Sorry, tell me again!");
                System.out.println("Play again? (yes or no)");
                answer = input.nextLine();
                System.out.println("New answer is " + answer);
            }
            if(answer.equals("no")) {
                play = false;
            }
        }

    }

}

