import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
import java.util.TimerTask;



/**
 * This class contains all the interactions with the user, asks all the questions, prints all
 * the messages and collects the data that we need from the users.
 */

public class UserInteraction {
    Scanner input = new Scanner(System.in);
    private final Container con;
    private final JPanel startTextPanel, startButtonPanel;
    private JPanel HMPPanel, HMPLeftPanel, HMPRightPanel;
    private JPanel NamePanelText, NamePanel, readyPanel, letsGoPanel;

    public UserInteraction(){
        //The basic frame
        JFrame frame = new JFrame("Buzz Quiz");
        //Look & Layout
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); //bazei to frame sto kentro ths o8onhs

        con = frame.getContentPane();

        //The panel that contains the text
        startTextPanel = new JPanel();
        //Look & Layout
        startTextPanel.setBounds(100, 100, 600, 140);
        startTextPanel.setLayout(new BorderLayout());
        startTextPanel.setBackground(Color.black);
        //startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        con.add(startTextPanel);

        //Label with the text
        JLabel startText = new JLabel("Buzz Quiz!");
        //Look & Layout
        startText.setFont(new Font("Carlito", Font.PLAIN, 90));
        startText.setForeground(Color.WHITE);
        startText.setHorizontalAlignment(JLabel.CENTER);
        startTextPanel.add(startText);

        //The panel that contains the button
        startButtonPanel = new JPanel();
        //Look & Layout
        startButtonPanel.setBounds(300, 300, 200, 100);
        startButtonPanel.setBackground(Color.black);
        con.add(startButtonPanel);

        //The start button
        JButton startButton = new JButton("Start");
        //Look & Layout
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setSize(200, 100);
        startButton.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HowManyOfYou();
            }
        });
        startButtonPanel.add(startButton);

        frame.setVisible(true);
    }

    public int HowManyOfYou(){
        //The actions for the buttons

        //turn off the previous panels
        startTextPanel.setVisible(false);
        startButtonPanel.setVisible(false);

        //The panel for the text
        HMPPanel = new JPanel();
        //Look & Layout
        HMPPanel.setBounds(100, 100, 500, 250);
        HMPPanel.setBackground(Color.black);
        con.add(HMPPanel);

        //The area that holds the text
        JTextArea HMPText = new JTextArea("Welcome! Choose the number of players for this game.");
        //Look & Layout
        HMPText.setBounds(100,100,500,250);
        HMPText.setBackground(Color.black);
        HMPText.setForeground(Color.WHITE);
        HMPText.setFont(new Font("Carlito", Font.PLAIN, 30));
        HMPText.setLineWrap(true);
        HMPText.setEditable(false);
        HMPPanel.add(HMPText);

        //The left panel
        HMPLeftPanel = new JPanel();
        //Look & Layout
        HMPLeftPanel.setBounds(0, 350, 400,150);
        HMPLeftPanel.setBackground(Color.black);
        con.add(HMPLeftPanel);

        //The right panel
        HMPRightPanel = new JPanel();
        //Look & Layout
        HMPRightPanel.setBounds(400, 350, 400,150);
        HMPRightPanel.setBackground(Color.black);
        con.add(HMPRightPanel);

        //The button for 1 player
        JButton onePlayer = new JButton("1 Player");
        //Look & Layout
        onePlayer.setBackground(Color.BLACK);
        onePlayer.setForeground(Color.WHITE);
        onePlayer.setSize(400, 150);
        onePlayer.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action
        onePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                God(1);
            }
        });
        HMPLeftPanel.add(onePlayer);

        //The button for 2 players
        JButton twoPlayers = new JButton("2 Players");
        //Look & Layout
        twoPlayers.setBackground(Color.BLACK);
        twoPlayers.setForeground(Color.WHITE);
        twoPlayers.setSize(400, 150);
        twoPlayers.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action
        twoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                God(2);
            }
        });
        HMPRightPanel.add(twoPlayers);

//        int howMany;
//        System.out.println("Oh I didn't see you there. Did you bring a friend?\n");
//        System.out.println("Number of players(1 or 2): ");
//        howMany = input.nextInt();
//
//        while(howMany<1 || howMany>2){
//            System.out.println("Oops! Give me a correct number!!1!\n");//maybe errorClass?
//            System.out.println("Number of players(1 or 2): ");
//            howMany = input.nextInt();
//        }
//        return howMany;
        return 0;
    }

    /**
     * Function God, creates the human beings of this game. Asks for the name
     * of the player, creates a Player object with that name that is going
     * to be added to the playerList.
     * @return A Player object
     */
    public Player God(int numOfPlayers){
        //Turn off previous panels
        HMPPanel.setVisible(false);
        HMPLeftPanel.setVisible(false);
        HMPRightPanel.setVisible(false);

        //The panel for the text
        NamePanelText = new JPanel();
        //Look & Layout
        NamePanelText.setBounds(100, 100, 500, 100);
        NamePanelText.setBackground(Color.black);
        con.add(NamePanelText);

        //The area that holds the text
        JTextArea NameText = new JTextArea("Choose a nickname (10 characters max):");
        //Look & Layout
        NameText.setBounds(100,100,500,100);
        NameText.setBackground(Color.black);
        NameText.setForeground(Color.WHITE);
        NameText.setFont(new Font("Carlito", Font.PLAIN, 30));
        NameText.setLineWrap(true);
        NameText.setEditable(false);
        NamePanelText.add(NameText);

        //The panel for the nickname input
        NamePanel = new JPanel();
        //Look & Layout
        NamePanel.setBounds(100, 200, 400, 100);
        NamePanel.setBackground(Color.black);
        con.add(NamePanel);

        //TextField for the nickname input
        JTextField nickname = new JTextField();
        //Look & Layout
        nickname.setBounds(100,200,400,100);
        NamePanel.add(nickname);
        nickname.setText("");
        nickname.setColumns(7);
        nickname.setBackground(Color.white);
        nickname.setForeground(Color.black);
        nickname.setFont(new Font("Carlito", Font.PLAIN, 30));
        nickname.setDocument(new JTextFieldLimit(10));

        //Panel for the button
        readyPanel = new JPanel();
        //Look & Layout
        readyPanel.setBounds(500, 200, 100, 100);
        readyPanel.setBackground(Color.black);
        con.add(readyPanel);

        //Button
        JButton readyButton = new JButton("Ready");
        readyButton.setBackground(Color.BLACK);
        readyButton.setForeground(Color.WHITE);
        readyButton.setSize(100, 100);
        readyButton.setFont(new Font("Carlito", Font.PLAIN, 30));
        readyPanel.add(readyButton);

        if(numOfPlayers==1){
            readyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        LetsGo();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            });
        }
        else{
            readyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    nickname.setText("");
                    God(1);
                }
            });
        }
//        System.out.println("You mortal man, name yourself!");
//
//        try {
//
//            Thread.sleep(1000);
//
//        } catch(InterruptedException e) {
//
//            System.out.println("got interrupted!");
//
//        }
//
//        System.out.println("Name: ");
//        String name = input.nextLine();
//
//        while (name.equals("") ) {
//
//            System.out.println("You have to give a name!");
//            System.out.println("Name: ");
//
//            name = input.nextLine();
//
//        }
//
//        Player player = new Player( );
//        player.setNickname(name);
//
//       return player;
        return null;
    }

    public void LetsGo() throws InterruptedException {
        //disable previous panels
        NamePanelText.setVisible(false);
        NamePanel.setVisible(false);
        readyPanel.setVisible(false);

        letsGoPanel = new JPanel();
        letsGoPanel.setBounds(100, 100, 600, 300);
        letsGoPanel.setBackground(Color.BLACK);
        con.add(letsGoPanel);

        JLabel text1 = new JLabel("LET");
        text1.setBounds(100,100,600,300);
        text1.setBackground(Color.black);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Carlito", Font.PLAIN, 300));
        text1.setHorizontalAlignment(JLabel.CENTER);
        letsGoPanel.add(text1);

        JLabel text2 = new JLabel("THE");
        text2.setBounds(100,100,600,300);
        text2.setBackground(Color.black);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Carlito", Font.PLAIN, 300));
        text2.setHorizontalAlignment(JLabel.CENTER);
        letsGoPanel.add(text2);

        JLabel text3 = new JLabel("GAME");
        text3.setBounds(50,100,700,300);
        text3.setBackground(Color.black);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("Carlito", Font.PLAIN, 300));
        text3.setHorizontalAlignment(JLabel.CENTER);
        letsGoPanel.add(text3);

        JLabel text4 = new JLabel("BEGIN");
        text4.setBounds(50,100,700,200);
        text4.setBackground(Color.black);
        text4.setForeground(Color.WHITE);
        text4.setFont(new Font("Carlito", Font.PLAIN, 200));
        text4.setHorizontalAlignment(JLabel.CENTER);
        letsGoPanel.add(text4);

        text1.setVisible(false);
        text2.setVisible(false);
        text3.setVisible(false);
        text4.setVisible(false);

        Timer timer4 = new Timer(500, e -> {
            text3.setVisible(false);
            text4.setVisible(true);
        });

        Timer timer3 = new Timer(500, e -> {
            text2.setVisible(false);
            text3.setVisible(true);
            timer4.start();

        });

        Timer timer2 = new Timer(500, e -> {
            text1.setVisible(false);
            text2.setVisible(true);
            timer3.start();
        });

        Timer timer1 = new Timer(500, e -> {
            text1.setVisible(true);
            timer2.start();
        });
        timer1.start();
    }

    //Class to limit the number of characters in a JText
    public class JTextFieldLimit extends PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }
        public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    /**
     * BetPoints function, asks the player to bet and saves the amount in an int variable.
     * @return the betPoints variable, which contains the points bet by the player.
     */
    public int betPoints(Player player) {

        int betPoints = 0;
        String points;

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        try{
            System.out.println("\nNow tell me, " + player.getNickname() + ", how risky are you?");

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
            newBetPoints(player);
        }

        return betPoints;

    }

    /**
     * newBetPoints is a function that is called when the player types a non acceptable amount to bet.
     * It informs the user about their mistake and asks for a new bet.
     * @return the new bet which is an integer.
     */
    public int newBetPoints(Player player){

        int betPonits = 0;
        String points;

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        try{
            System.out.println("\nYou can't bet this amount" + player.getNickname() +", bet again!");

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }

            System.out.println("\nType how many points you bet(250 / 500 / 750 / 1000):");
            points = input.nextLine();
            betPonits = Integer.valueOf(points);
        }catch(NumberFormatException ex){
            newBetPoints(player);
        }

        return betPonits;

    }

    /**
     * Function announcingCategory accepts a Questions type object and announces the category of the question
     * to the player.
     * @param question the question about to be asked
     */
    public void announcingCategory(Questions question){

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
        System.out.println("\nCategory: " + question.getCategory());

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

        }else if(type.getName().equals("Timer")){
            //TODO na symplhrwthe
        }else if(type.getName().equals("QuickAnswer")){
            ////// TODO na symplhrvthei
        }else { // Thermometer!
            ///// TODO na symplhrwthei!
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
        //TODO na prasinizei thn swsth apanthsh anti na ektypvnei
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
        }catch(InterruptedException e) {
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
            }catch(InterruptedException e) {
                System.out.print("got interrupted!");
            }

            System.out.println(player.getNickname() + " = " + player.getScore());

        }

    }





    public String replay(){

        System.out.println("THE END");
        System.out.println("Play again? (yes or no)");
        String answer = input.nextLine();

        while (!answer.equals("yes")  && !answer.equals("no")){

            System.out.println("Sorry, tell me again!");
            System.out.println("Play again? (yes or no)");
            answer = input.nextLine();
            System.out.println("New answer is " + answer);

        }

        return answer;
    }



    private void clearScanner(){
        input.nextLine();
    }
    //PROSOXH SKOYPIDIA - KATEBEITE ME DIKH SAS EY8YNH

//    /**
//     * Function HowManyOfYou, asks the user for the number of players.
//     * @return int
//     */
/*


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
