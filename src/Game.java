import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

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
    private ArrayList<Questions> randomQuestions;
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

        randomQuestions = new ArrayList<>();

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

        while(howManyRounds > 0){

            Round round = new Round();
            Type type = round.getRandomType();
            type.SetPlayersList(playerList);

            display.announcingTheType(type);

            while (numberOfQuestions>0 && randomQuestions.size() < numberOfQuestions) {

                round.getRandomQuestion(allQuestions, randomQuestions);
                numberOfQuestions--;
            }
            for (int i=0; i < randomQuestions.size(); i++) {

                display.askTheQuestion(randomQuestions.get(i));

                for (Player player : playerList){
                    String answer = display.getAnAnswer(player);

                    boolean correct = !randomQuestions.get(i).acceptableAnswer(answer);

                    while (correct){
                        answer = display.getNewAnswer(player);
                        correct = !randomQuestions.get(i).acceptableAnswer(answer);
                    }
                    if (answer == randomQuestions.get(i).getCorrectAnswer()){
                        player.setStatus(true);
                    }

                }
                display.correctAnswer(randomQuestions.get(i));
                display.whoWon(playerList);
                type.changePoints();

                for (Player player : playerList){
                    player.defaultfyStatus();
                }

            }
            display.showRoundScores(playerList);

            howManyRounds--;
        }
    }

    /**
     * Temporary method fillAllQuestions that creates Questions objects and adds them to the ArrayList.
     */

    public void fillAllQuestions(){
        Questions a = new Questions();
        Questions b = new Questions();
        Questions c = new Questions();

        a.setQuestion("Which nut is used to make dynamite?");
        a.setAnswerA("Peanuts");
        a.setAnswerB("Walnuts");
        a.setAnswerC("Pine nuts");
        a.setAnswerD("Almonds");
        a.setCorrectAnswer("Peanuts");
        a.setCategory("Food");
        allQuestions.add(a);

        b.setQuestion("When was the band System of a Down formed?");
        b.setAnswerA("1988");
        b.setAnswerB("1987");
        b.setAnswerC("1990");
        b.setAnswerD("1992");
        b.setCorrectAnswer("1988");
        b.setCategory("Music");
        allQuestions.add(b);

        c.setQuestion("How many films have Al Pacino and Robert De Niro starred in together?");
        c.setAnswerA("10");
        c.setAnswerB("6");
        c.setAnswerC("2");
        c.setAnswerD("4");
        c.setCorrectAnswer("4");
        c.setCategory("Films");
        allQuestions.add(c);

    }

    public static void main(String [] args){
        Game b = new Game();
        b.PlayTheGame();
        System.out.println("the end!!");
    }


}

