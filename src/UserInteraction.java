import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains all the interactions with the user, asks all the questions, prints all
 * the messages and collects the data that we need from the users.
 */

public class UserInteraction {
    Scanner input = new Scanner(System.in);

    public UserInteraction(){
        //empty constractor
    }

    /**
     * Function God, creates the human beings of this game. Asks for the name
     * of the player, creates a Player object with that name that is going
     * to be added to the playerList.
     * @return A Player object
     */
    public Player God(){
        System.out.println("You mortal man, name yourself!");

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

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
    public int betPoints() {
        int betPoints = 0;
        String points;

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        try{
            System.out.println("\nNow tell me how risky are you?");

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }

            System.out.println("\nType how many points you bet(250 / 500 / 750 / 1000):");
            points = input.nextLine();
            betPoints = Integer.valueOf(points);
        }catch(NumberFormatException exception){
            System.out.println("inside first catch");
            newBetPoints();
        }
        return betPoints;
    }

    /**
     * newBetPoints is a function that is called when the player types a non acceptable amount to bet.
     * It informs the user about their mistake and asks for a new bet.
     * @return the new bet which is an integer.
     */
    public int newBetPoints(){
        int betPonits = 0;
        String points;

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        try{
            System.out.println("\nYou can't bet this amount, bet again!");

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }

            System.out.println("\nType how many points you bet(250 / 500 / 750 / 1000):");
            points = input.nextLine();
            betPonits = Integer.valueOf(points);
        }catch(NumberFormatException ex){
            newBetPoints();
        }

        return betPonits;
    }

    /**
     * Function announcingTheType accepts a Type object and prints a message that announces the type name
     * through the getName method. Then it explains the way you play the game depending on the type.
     * @value type is a Type of game that is randomly chosen in an other class.
     */
    public void announcingTheType(Type type){
        System.out.println("\nNEW ROUND");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
        System.out.println("\nFor this round, you are playing " + type.getName());

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        if(type.getName().equals("RightAnswer")){
            System.out.println("\nHow to play RightAnswer: Choose the answer you believe is correct and if you are right you win 1000 points.");
        }
        else if(type.getName().equals("Bet")){
            System.out.println("\nHow to play Bet: You choose a bet amount (250/500/750/1000). " +
                    "If you answer the question correctly you get the points you bet. " +
                    "If you answer wrong you lose the bet amount from your points. ");
        }
    }

    /**
     * This void function accepts a Questions type object and prints the question and the four possible answers.
     */
    public void askTheQuestion(Questions question){
        System.out.println("\nQUESTION");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        System.out.println("\nCategory: " + question.getCategory());
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        System.out.println(question.getQuestion());
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        ArrayList<String> answers = question.getAnswers();
        System.out.println(answers.get(0) + "     " + answers.get(1));
        System.out.println(answers.get(2) + "     " + answers.get(3));
    }

    /**
     * This method accepts a Player object, asks the player for an answer and returns the input.
     * @return String variable that contains the answer.
     */
    public String getAnAnswer(Player player){

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        System.out.println(player.getNickname() + ", which answer do you think is correct?");
        return input.nextLine();
    }

    /**
     * getNewAnswer is called when the player types an answer that does not exist and asks for a new input.
     * @return String that contains the new answer.
     */
    public String getNewAnswer(Player player){
        System.out.println("\n");
        System.out.println(player.getNickname() + " this is not an option! Guess again.");
        return input.nextLine();
    }

    /**
     * This function prints the correct answer to the question asked previously.
     */
    public void correctAnswer(Questions question){
        System.out.println("The correct answer is: ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print("got interrupted!");
            }
            System.out.print(". ");
        }
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        System.out.print(question.getCorrectAnswer());
    }

    /**
     * whoWon is a void function that is called after each question and it announces who
     * answered correctly and who didn't by checking their status.
     * @value players is the ArrayList that contains all the players that are playing.
     */
    public void whoWon(ArrayList<Player> players){
        for (Player player : players){
            if(player.getStatus()){
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println("got interrupted!");
                }
                System.out.println("\n");
                System.out.println(player.getNickname() + ", you won!");
            }
            else if(!player.getStatus()){
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println("got interrupted!");
                }
                System.out.println("\n");
                System.out.println(player.getNickname() + ", maybe next time!");
            }
        }
    }

    /**
     * The function showRoundScores is called at the end of each round, to show the current score of the players.
     */
    public void showRoundScores(ArrayList<Player> players){
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        System.out.println("\nThe scores for this round are:");
        for (Player player : players){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
            System.out.println(player.getNickname() + " = " + player.getScore());
        }
    }

    /**
     * finalScores prints the scores of each player at the end of the game
     * @param players is the ArrayList with all the players.
     */
    public void finalScores(ArrayList<Player> players){
        try {
        Thread.sleep(2000);
    } catch(InterruptedException e) {
        System.out.println("got interrupted!");
    }
        System.out.println("\nNow, for the grand reveal");

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        System.out.println("\nThe final scores are:");
        for (Player player : players){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.print("got interrupted!");
            }
            System.out.println(player.getNickname() + " = " + player.getScore());
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
