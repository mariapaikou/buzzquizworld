
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
     * Function HowManyOfYou, asks the user for the number of players.
     * @return int
     */
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

    /**
     * Function HowManyOfYou, asks the user for the number of rounds (5 or 10 rounds available).
     * @return int
     */

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

    /**
     * Function TypeOfGame, asks the user the type of game they want to play (RightAnswer and Bet available).
     * @return String
     */
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

    /**
     * Function God, creates the human beings of this game. Asks for the name
     * of the player, creates a Player object with that name that is going
     * to be added to the playerList.
     * @return Player
     */
    public Player God(){
        System.out.println("You mortal man, name yourself! \n");
        System.out.println("Name: ");
        String name=input.nextLine();
        Player player = new Player();
        player.setNickname(name);
        return player;

    }




}
