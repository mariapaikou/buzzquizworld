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
    private final int howManyPlayers;
    private final ArrayList <Player> playerList;
    private final ArrayList<Questions> allQuestions;
    private static int howManyRounds = 3;
    private final static int numberOfQuestions = 5; //edw tha prepei na problepoyme gia thn thermometer! mhpws na to baloyme mesa sthn type?
    private final UserInteraction display;
    private Round round;


/**
 * The constructor initializes the UserInteraction object and the two ArrayLists, one for the
 * players and one for the questions. For the players, it calls the God method from UserInteraction.
 */
    public Game(){

        display = new UserInteraction();
        howManyPlayers = display.HowManyOfYou();
        playerList = new ArrayList<>();

        for (int i = howManyPlayers; i > 0; i--) {
            playerList.add(display.God());
        }
        allQuestions = new ArrayList<>();
        round = new Round();
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
        int questionNum = 0;

        while(howManyRounds > 0){

            int num = numberOfQuestions;
            //Round round = new Round(); // to ebala ston consturctor kai nomizw doyleysei swsta!

            Type type = round.getRandomType();
            type.setPlayersList(playerList);

            while (num > 0){

                display.announcingTheType(type);
                display.announcingCategory(allQuestions.get(questionNum));
                setTypesInitialBehaviour(type);
                display.askTheQuestion(allQuestions.get(questionNum));

                for (Player player : playerList){

                    String answer = getPlayersAnswer(player,questionNum);

                    if (answer.equals(allQuestions.get(questionNum).getCorrectAnswer())){
                        player.setStatus(true);
                    }

                }

                display.correctAnswer(allQuestions.get(questionNum));
                display.whoWon(playerList);
                type.changePoints();
                setTypeInitialStatus(type);
               // defaultfyPlayersStatus(); ginetai mesa stis changePoints!
                questionNum++;
                num--;

            }
            display.showRoundScores(playerList);
            howManyRounds--;
        }
        display.finalScores(playerList);
        howManyRounds = 3; //mhpws prepei na ginei stathera gia eykolia synthrhshs!
        initializePlayersScore();

    }

    /**
     * Function getPlayersAnswer calls UserInteraction method getAnswer to get an answer to the question asked and checks
     * if answer is an acceptable value by calling UserInteractions method acceptableAnswer.
     * @param player
     * @param questionNum
     * @return answer String value that contains player's answer to the question asked
     */

     private String getPlayersAnswer(Player player, int questionNum){

         String answer = display.getAnAnswer(player);
         boolean correct = allQuestions.get(questionNum).acceptableAnswer(answer);

         while (!correct){
             answer = display.getNewAnswer(player);
             correct = allQuestions.get(questionNum).acceptableAnswer(answer);
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
    private void setTypesInitialBehaviour(Type type) {

        if (type instanceof Bet) {
            for (Player player : playerList) {
                int points = display.betPoints(player);

                while (points != 250 && points != 500 && points != 750 && points != 1000) {
                    points = display.newBetPoints(player);
                }
                ((Bet) type).setPoints(points);
            }
        }else if (type instanceof Timer) {
            // tha friaxnoyme to Timer antikeimeno!!!
            //TODO mhpws prepei na einai mesa sthn Timer? h sthn UserIneraction!!!!
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
        // TODO xreiazetai kati gia ta alla types???
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
     * Temporary method fillAllQuestions that creates Questions objects and adds them to the ArrayList.
     */
    private void fillAllQuestions(){

//        Questions a = new Questions("Which nut is used to make dynamite?", "Peanuts", "Walnuts", "Pine nuts", "Almonds", "Peanuts", "Food", "null");
//        allQuestions.add(a);
//
//        Questions b = new Questions("When was the band System of a Down formed?", "1988", "1987", "1990", "1992", "1988", "Music", "null");
//        allQuestions.add(b);
//
//        Questions c = new Questions("How many films have Al Pacino and Robert De Niro starred in together?", "10", "6", "2", "4", "4", "Films", "null");
//        allQuestions.add(c);
//
//        Questions d = new Questions("Who invented Coca-Cola?", "John Pemberton", "Asa Griggs Candler", "Charles Elmer Hires", "John Matthews", "John Pemberton", "Food", "null");
//        allQuestions.add(d);
//
//        Questions e = new Questions("On an email, what does \"CC\" stand for?", "Carbon Copy", "Course Corrected", "Check Core", "Can't Complete", "Carbon Copy", "Technology", "null");
//        allQuestions.add(e);
//
//        Questions f = new Questions("Which of these social media platforms was launched in 2010? ", "Twitter", "Myspace", "Facebook", "Instagram", "Instagram", "Technology", "null");
//        allQuestions.add(f);
//
//        Questions g = new Questions("What year was the first Toy Story film released in cinemas?", "1995", "1999", "2001", "1992", "1995", "Films", "null");
//        allQuestions.add(g);
//
//        Questions h = new Questions("Which computer programming language was known for its \"turtle graphics\"?", "Logo", "Python", "COBOL", "C++", "Logo","Technology", "null");
//        allQuestions.add(h);
//
//        Questions i = new Questions("How many moons does Mars have in all?", "0", "5", "8", "2", "2","Science", "null");
//        allQuestions.add(i);
//
//        Questions j = new Questions("What is the largest organ in the human body?", "Heart", "Large Intestine", "Lungs", "Skin", "Skin", "Science", "null");
//        allQuestions.add(j);

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
        UserInteraction a = new UserInteraction();


        while(play){

            b.PlayTheGame();
            //TODO na baloyme na kaleitai h replay !!!!!
            String answer = a.replay();

            if(answer.equals("no")) {
                play = false;
            }

        }

    }

}
// SKOYPIDIA!!!!!!!!!!!!!!!!!
//
//    /**
//     * Function defaultfyPlayersStatus is a void function that sets players status back to false by calling Player's method
//     * defaultfyStatus
//     */
//    private void defaultfyPlayersStatus(){
//
//        for (Player player : playerList){
//            player.defaultfyStatus();
//        }
//
//    }
