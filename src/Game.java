import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * This class is initializing the players of the game also it makes a new round object.
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

/*
    public ArrayList<Player> getPlayerList() { return playerList; }
 */


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

                for (Player player : playerList){

                    if(type instanceof Bet){
                        int points = display.betPoints();
                        while(points != 250 && points != 500 && points != 750 && points != 1000){
                            points = display.newBetPoints();
                        }
                        ((Bet) type).setPoints(points);
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
                if(type instanceof Bet){
                    ((Bet) type).initializePositions();
                }


                for (Player player : playerList){
                    player.defaultfyStatus();
                }
                questionsAskedAlready++;
                num--;
            }
            display.showRoundScores(playerList);
            howManyRounds--;
        }
        howManyRounds = 3;
        for(Player player : playerList){
            player.initializeScore();
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
     * Function randomizeQuestions accepts allQuestions and randomly arranges the ArrayList
     * @param allQuestions is the ArrayList that contains all the Questions objects available
     */
    private void randomizeQuestions(ArrayList<Questions> allQuestions){
        Collections.shuffle(allQuestions);
    }



    public static void main(String [] args){

        boolean play = true;
        Scanner input = new Scanner(System.in);
        Game b = new Game();

        while(play){

            b.PlayTheGame();

            System.out.println("the end!!");
            System.out.println("Play again? (yes or no)");
            String answer = input.nextLine();

            while (!answer.equals("yes")  && !answer.equals("no")){
                System.out.println("Sorry tell me again!");
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

