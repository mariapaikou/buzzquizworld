import java.util.ArrayList;

/**
 * This class is initializing the players of the game also it makes a new round object.
 */

public class Game {
    /**
     * @param playerList is an ArrayList that stores Player objects
     * @param randomQuestions is an Arraylist that stores the three Questions objects that are
     *                        randomly selected by a Round method.
     */
    //private int howManyPlayers;
    private ArrayList <Player> playerList;
    private ArrayList<Questions> allQuestions;
    private ArrayList<Questions> randomQuestions;
    private static int howManyRounds = 5;
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
     * and a type that is randomly chosen by the Round objects method, getRandomType. Then it sets the type objects player
     * list to the list that Game has.
     */
    public void PlayTheGame(){
        fillAllQuestions();

        while(howManyRounds > 0){
            Round round = new Round();
            Type type = round.getRandomType();
            type.SetPlayersList(playerList);

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

