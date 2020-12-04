
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains all the interactions with the user,
 * asks all the questions and collects the data that are used to create the
 * players.
 *
 */

public class UserInteraction {
    Scanner input = new Scanner(System.in);

    public UserInteraction(){
        //not needed
    }

    /**
     * Function God, creates the human beings of this game. Asks for the name
     * of the player, creates a Player object with that name that is going
     * to be added to the playerList.
     * @return A Player object that is name player
     */
    public Player God(){
        System.out.println("You mortal man, name yourself! \n");
        System.out.println("Name: ");
        String name = input.nextLine();
        Player player = new Player();
        player.setNickname(name);
        return player;

    }

    /**
     * BetPoints function, asks the player to bet and saves the amount in an int variable.
     * @return the betPoints variable, which contains the points bet by the player.
     */

    public int BetPoints() {
        System.out.println("Now tell me how risky are you?");
        System.out.println("Type how many points you bet(250 / 500 / 750 / 1000):");
        String points = input.nextLine();
        int betPoints = Integer.valueOf(points);
        return betPoints;
    }

    /**
     * Function announcingTheType accepts a Type object and prints a message that announces the type name
     * through the getName method. Then it explains the way you play the game.
     * @param type is a Type of game that is randomly chosen.
     */

    public void announcingTheType(Type type){
        System.out.println("For this round, you are playing " + type.getName());
        if(type.getName() == "RightAnswer"){
            System.out.println("How to play RightAnswer: Choose the answer you believe is correct and if you are right you win 1000 points.");
        }
        else if(type.getName() == "Bet"){
            System.out.println("How to play Bet: You choose a bet amount (250/500/750/1000). " +
                    "If you answer the question correctly you get the points you bet. " +
                    "If you answer wrong you lose the bet amount from your points. ");
        }
    }

    /**
     * This function accepts a Questions type object and prints the question and the four possible answers.
     * @param question is a Questions object
     */
    public void askTheQuestion(Questions question){
        System.out.println(question.getQuestion());
        System.out.println(question.getAnswerA() + question.getAnswerB());  //prepei na skeftoume tropo kai pou tha kanei randomize thn seira twn erwthsewn
        System.out.println(question.getAnswerC() + question.getAnswerD());
    }

    /**
     * This method accepts a Player object, asks the player for an answer and returns the input.
     * @param player a Player object that is playing the game
     * @return String variable that contains the answer.
     */
    public String getAnAnswer(Player player){
        System.out.println(player.getNickname() + ", which answer do you think is correct?");
        String answer = input.nextLine();
        return answer;
    }

    /**
     * This function prints the correct answer to the question asked previously.
     * @param question is a Questions object
     */
    public void correctAnswer(Questions question){
        System.out.println("The correct answer is: " + question.getCorrectAnswer());
    }

    /**
     * whoWon is a void function that is called after each question and it announces who
     * answered correctly and who didn't by checking their status.
     * @param players is the ArrayList that contains all the players that are playing.
     */
    public void whoWon(ArrayList<Player> players){
        for (Player player : players){
            if(player.getStatus() == true){
                System.out.println(player + " won!");
            }
            else if(player.getStatus() == false){
                System.out.println(player + " maybe next time!");
            }
        }
    }

    /**
     * The function showRoundScores is called at the end of each round, to show the current score of the players.
     */
    public void showRoundScores(ArrayList<Player> players){
        System.out.println("The scores for this round are:");
        for (Player player : players){
            System.out.println(player.getNickname() + player.getScore());
        }
    }

    //PROSOXH SKOYPIDIA - KATEBEITE ME DIKH SAS EY8YNH

//    /**
//     * Function HowManyOfYou, asks the user for the number of players.
//     * @return int
//     */
/*
    public int HowManyOfYou(){
        int howMany;
        System.out.println("Oh I didn't see you there. Did you bring a friend?\n");
        System.out.println("Number of players(1 or 2): ");
        howMany = input.nextInt();

        while(howMany<1 || howMany>2){
            System.out.println("Oops! Give me a correct number!!1!\n");//maybe errorClass?
            System.out.println("Number of players(1 or 2): ");
            howMany = input.nextInt();
        }
        return howMany;
    }

 */

//    /**
//     * Function HowManyOfYou, asks the user for the number of rounds (5 or 10 rounds available).
//     * @return int
//     */
/*
    public int HowManyRounds(){
        int howMany;
        System.out.println("Now, tell me how many rounds do you want to play?\n");
        System.out.println("Number of rounds(5 or 10):");
        howMany= input.nextInt();
        while (howMany!=5 || howMany!=10){
            System.out.println("Oops! Give me a correct number!!1!\n");//maybe errorClass?
            System.out.println("Number of rounds(5 or 10): ");
            howMany= input.nextInt();
        }
        return howMany;
    }

 */

//    /**
//     * Function TypeOfGame, asks the user the type of game they want to play (RightAnswer and Bet available).
//     * @return String
//     */
/*
    public String TypeOfGame(){
        String type;
        System.out.println("Pick a game, don't be a chicken!");
        System.out.println("Game types: RightAnswer or Bet!! Your answer and spell it out:");
        type = input.nextLine();
        while (type!="RightAnswer" || type!="Bet"){
            System.out.println("Oops! Give me a correct name!!1!\n");//maybe errorClass?
            System.out.println("Game types: RightAnswer or Bet!! Your answer and spell it out:");
            type = input.nextLine();
        }
        return type;
    }

 */

/*
    /**
     * This function receives the game of choise and creates the object
     * @param nameOfGame
     */
/*
    public void Choise(String nameOfGame){
        if(nameOfGame=="Right Answer"){
            RightAnswer rightAnswer = new RightAnswer();
        }else if(nameOfGame=="Timer"){
            Timer timer= new Timer();
        }else if(nameOfGame=="Bet"){
            Bet bet = new Bet();
        }else if(nameOfGame == "Quick Answer"){
            QuickAnswer quickAnswer = new QuickAnswer();
        }else if(nameOfGame == "Thermometer"){
            Thermometer thermometer = new Thermometer();
        }else{
            runTimeError(); //mhpws afth tha mpei sthn error pou tha einai kai gia tous elegxous?
        }
    }

*/


}
