import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * UserInteraction class represent the interaction with the user, accepts all the inputs to manage the actions the
 * program has to do and implements the GUI.
 * @author Theodora-Sofia Tsochataridou
 * @author Maria Paikou
 * @version 2.0
 * @since 05 - December - 2020
 */
public class UserInteraction  {

    private final JFrame frame;
    private Questions question;
    private final Game game;
    private Type type;
    private ArrayList<Player> players = new ArrayList<>();
    private int numberOfPlayers = 0, rounds = 1, questions = 1, defaultNumQuestions;
    private Container con;
    private JPanel startTextPanel, startButtonPanel, HMPPanel, HMPLeftPanel, HMPRightPanel, NamePanelText, NamePanel;
    private JPanel readyPanel, letsGoPanel, RoundNumberPanel, QuestionNumberPanel, TypePanel, TypeExplanationPanel;
    private JPanel announcingCategoryPanel, typeOkayPanel, betPointsPanel, betPointsPanel2, bet250, bet500, bet750, bet1000;
    private JPanel centerPanel , bottomPanel, questionPanel, answerPanelA, answerPanelB, answerPanelC, answerPanelD;
    private JPanel showStatusPanel1, showStatusPanel2, showScoreTextPanel, showScorePanel1, showScorePanel2;
    private JPanel correctAnswerTextPanel, correctAnswerPanel, playerFinalScoreTextPanel, playerFinalScorePanel;
    private JPanel AndTheWinnerIsPanel, winnerPanel, FinalScoresPanel, finalLeftScorePanel, finalRightScorePanel;
    private JPanel highScoresButtonPanel, totalWinsButtonPanel;
    private String answer1, answer2;
    private ArrayList<String> answers = new ArrayList<>();
    private JTextField nickname;
    private Timer timer1, timer2,timer3,timer4,timer5;
    private long startTime , endTime1, endTime2;

    public UserInteraction(){
        answer1 = null;
        answer2 = null;

        game = new Game("highscores.dat","totalwins.dat");

        //The basic frame
        frame = new JFrame("Buzz Quiz");
        //Look & Layout
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * This is the first window to appear when the user starts the game. It displays the name of the game and has
     * three buttons, a start button that starts the game and buttons for the saved scores and previous game scores.
     */
    private void basicDisplay(){
        con = frame.getContentPane();
        con.setPreferredSize(new Dimension(800,500));

        //The panel that contains the text
        startTextPanel = new JPanel();
        //Look & Layout
        startTextPanel.setBounds(100, 100, 600, 140);
        startTextPanel.setLayout(new BorderLayout());
        startTextPanel.setBackground(Color.black);
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
        startButtonPanel.setBounds(300, 240, 200, 80);
        startButtonPanel.setBackground(Color.BLACK);
        con.add(startButtonPanel);

        //The start button
        JButton startButton = new JButton("Start");
        //Look & Layout
        startButton.setBackground(Color.PINK);
        startButton.setForeground(Color.WHITE);
        startButton.setSize(200, 80);
        startButton.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action
        startButton.addActionListener(e -> {
            startTextPanel.setVisible(false);
            startButtonPanel.setVisible(false);
            highScoresButtonPanel.setVisible(false);
            totalWinsButtonPanel.setVisible(false);
            HowManyOfYou();
        });
        startButtonPanel.add(startButton);

        highScoresButtonPanel = new JPanel();
        highScoresButtonPanel.setBounds(300,320,200,80);
        highScoresButtonPanel.setBackground(Color.BLACK);
        con.add(highScoresButtonPanel);

        JButton highScoreButton = new JButton("High Scores!");
        highScoreButton.setBackground(Color.PINK);
        highScoreButton.setForeground(Color.WHITE);
        highScoreButton.setSize(200,80);
        highScoreButton.setFont(new Font("Carlito", Font.PLAIN,30));
        //action listener!
        highScoreButton.addActionListener(e -> {
            startTextPanel.setVisible(false);
            startButtonPanel.setVisible(false);
            highScoresButtonPanel.setVisible(false);
            totalWinsButtonPanel.setVisible(false);
            showHighScores();
        });
        highScoresButtonPanel.add(highScoreButton);

        totalWinsButtonPanel = new JPanel();
        totalWinsButtonPanel.setBounds(300,400,200,80);
        totalWinsButtonPanel.setBackground(Color.BLACK);
        con.add(totalWinsButtonPanel);

        JButton totalWinsButton = new JButton("Total Wins!");
        totalWinsButton.setBackground(Color.PINK);
        totalWinsButton.setForeground(Color.WHITE);
        totalWinsButton.setSize(200,80);
        totalWinsButton.setFont(new Font("Carlito", Font.PLAIN,30));
        //action listener
        totalWinsButton.addActionListener(e -> {
            startTextPanel.setVisible(false);
            startButtonPanel.setVisible(false);
            highScoresButtonPanel.setVisible(false);
            totalWinsButtonPanel.setVisible(false);
            showTotalWins();
        });
        totalWinsButtonPanel.add(totalWinsButton);
        game.readScores();
    }

    /**
     * Displays the contents of the high score file, which are the ten highest scores in one player mode.
     */
    private void showHighScores(){
        String [] data = game.getHighScores();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String sting: data){
            listModel.addElement(sting);
        }
        JList<String> list = new JList<>(listModel);
        list.setBounds(100,50,600,400);
        list.setFont(new Font("Carlito", Font.PLAIN, 30));
        list.setBackground(Color.PINK);
        JPanel pane = new JPanel();
        pane.setBounds(0,0,800,400);
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(list);
        pane.setBackground(Color.PINK);

        con.add(pane);

        JPanel panel = new JPanel();

        JButton backButton = new JButton("Back!");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setSize(100,100);
        backButton.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action Listener
        backButton.addActionListener(e -> {
            pane.setVisible(false);
            panel.setVisible(false);
            basicDisplay();
        });

        panel.setBounds(100,400,100,100);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.GRAY);
        panel.add(backButton);
        con.add(panel);
    }

    /**
     * Displays the game scores of previous multiplayer games.
     */
    private void showTotalWins(){
        String [] data = game.getTotalWins();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String sting: data){
            listModel.addElement(sting);
        }

        JList<String> list = new JList<>(listModel);
        list.setFont(new Font("Carlito", Font.PLAIN, 30));
        list.setBackground(Color.PINK);
        JPanel pane = new JPanel();
        pane.setBounds(200,50,500,400);
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.setBackground(Color.PINK);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        Dimension d = list.getPreferredSize();
        d.width = 400;
        d.height = 400;
        scrollPane.setPreferredSize(d);
        list.setLayoutOrientation(JList.VERTICAL);
        pane.add(scrollPane);
        con.add(pane);

        JPanel panel = new JPanel();

        JButton backButton = new JButton("Back!");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setSize(100,100);
        backButton.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action Listener
        backButton.addActionListener(e -> {
            //list.setVisible(false);
            pane.setVisible(false);
            panel.setVisible(false);
            basicDisplay();
        });

        panel.setBounds(100,400,100,100);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.GRAY);
        panel.add(backButton);
        con.add(panel);
    }

    /**
     * Asks the user to select the number of players. There are two choices: 1 Player and 2 Players.
     */
    public void HowManyOfYou(){
        //The panel for the text
        HMPPanel = new JPanel();
        //Look & Layout
        HMPPanel.setBounds(100, 100, 500, 250);
        HMPPanel.setBackground(Color.black);
        con.add(HMPPanel);

        //The area that holds the text
        JTextArea HMPText = new JTextArea("How many players will be playing?");
        //Look & Layout
        HMPText.setBounds(100,100,500,250);
        HMPText.setBackground(Color.black);
        HMPText.setForeground(Color.WHITE);
        HMPText.setFont(new Font("Carlito", Font.PLAIN, 30));
        HMPText.setLineWrap(true);
        HMPText.setWrapStyleWord(true);
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
        onePlayer.addActionListener(e -> {
            HMPPanel.setVisible(false);
            HMPLeftPanel.setVisible(false);
            HMPRightPanel.setVisible(false);
            numberOfPlayers = 1;
            God(1);
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
        twoPlayers.addActionListener(e -> {
            HMPPanel.setVisible(false);
            HMPLeftPanel.setVisible(false);
            HMPRightPanel.setVisible(false);
            numberOfPlayers = 2;
            God(2);
        });
        HMPRightPanel.add(twoPlayers);
    }

    /**
     * Function God asks the user to insert a nickname and then creates a player object with that input.
     * @param numberOfPlayers the number of players in this game
     */
    public void God(int numberOfPlayers){

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
        NameText.setWrapStyleWord(true);
        NameText.setEditable(false);
        NamePanelText.add(NameText);

        //The panel for the nickname input
        NamePanel = new JPanel();
        //Look & Layout
        NamePanel.setBounds(100, 200, 400, 100);
        NamePanel.setBackground(Color.black);
        con.add(NamePanel);

        //TextField for the nickname input
        nickname = new JTextField();
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
        readyButton.addActionListener(e -> {
            players.add(game.createPlayer(nickname.getText()));
            if(numberOfPlayers == 2){
                NamePanelText.setVisible(false);
                NamePanel.setVisible(false);
                readyPanel.setVisible(false);
                con.remove(readyPanel);
                nickname.setText("");
                God2();
            }else{
                LetsGo();
            }
        });
    }

    /**
     * This method is used in two-player mode and has the same functionality as God.
     */
    private void God2() {
        NamePanelText.setVisible(false);
        NamePanel.setVisible(false);
        readyPanel.setVisible(false);
        NamePanelText.removeAll();
        readyPanel.removeAll();
        NamePanel.removeAll();

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
        NameText.setWrapStyleWord(true);
        NameText.setEditable(false);
        NamePanelText.add(NameText);

        //The panel for the nickname input
        NamePanel = new JPanel();
        //Look & Layout
        NamePanel.setBounds(100, 200, 400, 100);
        NamePanel.setBackground(Color.black);
        con.add(NamePanel);

        //TextField for the nickname input
        nickname = new JTextField();
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

        readyButton.addActionListener(e -> {
            players.add(game.createPlayer(nickname.getText()));
            NamePanelText.setVisible(false);
            NamePanel.setVisible(false);
            readyPanel.removeAll();
            con.remove(readyPanel);
            readyPanel.setVisible(false);
            LetsGo();
        });
    }

    /**
     * Let's go was added for dramatic effect but is not useless as it randomizes the questions before the actual game
     * begins.
     */
    public void LetsGo() {
        NamePanelText.setVisible(false);
        NamePanel.setVisible(false);
        readyPanel.setVisible(false);

        //randomize questions
        game.randomizeQuestions();

        letsGoPanel = new JPanel();
        letsGoPanel.setBounds(0, 100, 800, 400);
        letsGoPanel.setBackground(Color.BLACK);
        con.add(letsGoPanel);

        JLabel text1 = new JLabel("LET");
        setLabelFeatures(text1);

        JLabel text2 = new JLabel("THE");
        setLabelFeatures(text2);

        JLabel text3 = new JLabel("GAME");
        setLabelFeatures(text3);

        JLabel text4 = new JLabel("BEGIN");
        setLabelFeatures(text4);

        text1.setVisible(false);
        text2.setVisible(false);
        text3.setVisible(false);
        text4.setVisible(false);

        timer5 = new Timer(800, e -> {
            text4.setVisible(false);
            letsGoPanel.setVisible(false);
            timer1.stop();
            timer2.stop();
            timer3.stop();
            timer4.stop();
            timer5.stop();
            roundNumber();
        });

        timer4 = new Timer(800, e -> {
            text3.setVisible(false);
            text4.setVisible(true);
            timer5.start();
        });

        timer3 = new Timer(800, e -> {
            text2.setVisible(false);
            text3.setVisible(true);
            timer4.start();
        });

        timer2 = new Timer(800, e -> {
            text1.setVisible(false);
            text2.setVisible(true);
            timer3.start();
        });

        timer1 = new Timer(800, e -> {
            text1.setVisible(true);
            timer2.start();
        });
        timer1.start();
    }
    //Four same labels in LetsGo
    private void setLabelFeatures(JLabel text) {
        text.setBounds(0, 100, 800, 400);
        text.setBackground(Color.black);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Carlito", Font.PLAIN, 300));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        letsGoPanel.add(text);
    }

    /**
     * Class to limit the number of characters in a JText.
     */
    public static class JTextFieldLimit extends PlainDocument {
        private final int limit;

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
     * Shows to the user which round is the round that is about to start.
     */
    public void roundNumber(){
        //Turn off previous panel
        letsGoPanel.setVisible(false);
        con.remove(letsGoPanel);

        defaultNumQuestions = game.getNumberOfQuestions();

        if(rounds - 1 < game.getHowManyRounds()) {
            //Panel for the round label
            RoundNumberPanel = new JPanel();
            RoundNumberPanel.setBounds(0, 50, 800, 200);
            RoundNumberPanel.setBackground(Color.PINK);
            con.add(RoundNumberPanel);

            //Label ROUND i
            JLabel roundLabel = new JLabel("Round " + rounds);
            roundLabel.setBounds(0, 50, 800, 200);
            roundLabel.setBackground(Color.PINK);
            roundLabel.setForeground(Color.WHITE);
            roundLabel.setFont(new Font("Carlito", Font.PLAIN, 200));
            roundLabel.setHorizontalAlignment(JLabel.CENTER);
            roundLabel.setVerticalAlignment(JLabel.CENTER);
            RoundNumberPanel.add(roundLabel);

            timer1 = new Timer(1500, e -> {
                timer1.stop();
                announcingTheType();
            });
            timer1.start();

        }else{
            if(numberOfPlayers == 1){
                finalScore();
            }else{
                winner();
            }
        }
    }

    /**
     * Selects a random type and announces it to the users.
     */
    public void announcingTheType(){

        RoundNumberPanel.setVisible(false);
        //Get random type from game
        type = game.getRandomType(players);

        //Panel for the type
        TypePanel = new JPanel();
        TypePanel.setBounds(50, 50, 700, 50);
        TypePanel.setBackground(Color.PINK);
        con.add(TypePanel);

        //Label for the type
        JLabel typeLabel = new JLabel(type.getName());
        typeLabel.setBounds(50, 50, 700, 50);
        typeLabel.setBackground(Color.black);
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Carlito", Font.PLAIN, 30));
        typeLabel.setHorizontalAlignment(JLabel.CENTER);
        typeLabel.setVerticalAlignment(JLabel.CENTER);
        TypePanel.add(typeLabel);

        //Panel for the explanation
        TypeExplanationPanel = new JPanel();
        TypeExplanationPanel.setBounds(50, 100, 700, 300);
        TypeExplanationPanel.setBackground(Color.BLACK);
        con.add(TypeExplanationPanel);

        //Label for the explanation
        JTextArea typeExplanationArea = new JTextArea(type.getExplanation());
        typeExplanationArea.setBounds(50, 100, 700, 300);
        typeExplanationArea.setBackground(Color.black);
        typeExplanationArea.setForeground(Color.WHITE);
        typeExplanationArea.setFont(new Font("Carlito", Font.PLAIN, 30));
        typeExplanationArea.setLineWrap(true);

        TypeExplanationPanel.add(typeExplanationArea);

        //Panel for the okay button
        typeOkayPanel = new JPanel();
        typeOkayPanel.setBounds(600, 400, 100, 100);
        typeOkayPanel.setBackground(Color.PINK);
        con.add(typeOkayPanel);

        //Okay button
        JButton okay = new JButton("Okay");
        okay.setBackground(Color.BLACK);
        okay.setForeground(Color.WHITE);
        okay.setSize(50, 50);
        okay.setFont(new Font("Carlito", Font.PLAIN, 30));
        okay.addActionListener(e -> questionNumber());
        typeOkayPanel.add(okay);
    }

    /**
     * Displays the number of the question will be asked (there is a default number in a round) and selects a question
     * from the randomized database.
     */
    public void questionNumber(){
        TypePanel.setVisible(false);
        TypeExplanationPanel.setVisible(false);
        typeOkayPanel.setVisible(false);

        if(questions - 1 < defaultNumQuestions) {
            //Panel for the question label
            QuestionNumberPanel = new JPanel();
            QuestionNumberPanel.setBounds(0, 50, 800, 200);
            QuestionNumberPanel.setBackground(Color.DARK_GRAY);
            con.add(QuestionNumberPanel);

            //Label QUESTION j
            JLabel questionLabel = new JLabel("Question " + questions);
            questionLabel.setBounds(0, 50, 800, 200);
            questionLabel.setBackground(Color.black);
            questionLabel.setForeground(Color.WHITE);
            questionLabel.setFont(new Font("Carlito", Font.PLAIN, 150));
            questionLabel.setHorizontalAlignment(JLabel.CENTER);
            questionLabel.setVerticalAlignment(JLabel.CENTER);
            QuestionNumberPanel.add(questionLabel);

            timer1 = new Timer(1500, e -> {
                timer1.stop();
                QuestionNumberPanel.setVisible(false);
                question = game.getNewQuestion();
                announcingCategory();

            });
            timer1.start();

        }else{
            rounds++;
            questions = 1;
            roundNumber();
        }
    }

    /**
     * Informs the player what the category of the upcoming question is.
     */
    public void announcingCategory(){
        QuestionNumberPanel.setVisible(false);

        //New panel
        announcingCategoryPanel = new JPanel();
        announcingCategoryPanel.setBounds(100, 100, 600, 100);
        announcingCategoryPanel.setBackground(Color.PINK);
        con.add(announcingCategoryPanel);

        //new label
        JLabel category = new JLabel(question.getCategory());
        category.setBounds(100, 100, 600, 100);
        category.setBackground(Color.black);
        category.setForeground(Color.WHITE);
        category.setFont(new Font("Carlito", Font.PLAIN, 100));
        category.setHorizontalAlignment(JLabel.CENTER);
        category.setVerticalAlignment(JLabel.CENTER);
        announcingCategoryPanel.add(category);

        timer1 = new Timer(1500,e -> {
            timer1.stop();
            if(type instanceof Bet){
                betPoints();
            }else {
                askTheQuestion();
            }
        });
        timer1.start();
    }

    /**
     * If the type for the round is Bet, then before asking the question and after announcing the category, this method
     * requests the player to make a bet, choosing between 250, 500, 750 and 1000 points.
     */
    public void betPoints() {
        //turn off previous panels
        announcingCategoryPanel.setVisible(false);

        Player player = players.get(0);

        //BetPoints panel
        betPointsPanel = new JPanel();
        betPointsPanel.setBounds(100, 100, 600, 200);
        betPointsPanel.setBackground(Color.BLACK);
        con.add(betPointsPanel);

        //bet250 panel
        bet250 = new JPanel();
        bet250.setBounds(80, 350, 100, 100);
        bet250.setBackground(Color.BLACK);
        con.add(bet250);

        //bet500 panel
        bet500 = new JPanel();
        bet500.setBounds(260, 350, 100, 100);
        bet500.setBackground(Color.BLACK);
        con.add(bet500);

        //bet750 panel
        bet750 = new JPanel();
        bet750.setBounds(440, 350, 100, 100);
        bet750.setBackground(Color.BLACK);
        con.add(bet750);

        //bet1000 panel
        bet1000 = new JPanel();
        bet1000.setBounds(620, 350, 100, 100);
        bet1000.setBackground(Color.BLACK);
        con.add(bet1000);

        //betPoints label
        JLabel betPoints = new JLabel(player.getNickname() + ", how risky are you?");
        betPoints.setBounds(100, 100, 600, 200);
        betPoints.setBackground(Color.black);
        betPoints.setForeground(Color.WHITE);
        betPoints.setFont(new Font("Carlito", Font.PLAIN, 50));
        betPoints.setHorizontalAlignment(JLabel.CENTER);
        betPoints.setVerticalAlignment(JLabel.CENTER);
        betPointsPanel.add(betPoints);

        //bet250 button
        JButton bet250Button = new JButton("250");
        bet250Button.setBackground(Color.BLACK);
        bet250Button.setForeground(Color.WHITE);
        bet250Button.setSize(100, 100);
        bet250Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet250Button.addActionListener(e -> {
            player.getWallet().setBet(250);
            if(players.size() == 2){
                betPoints2();
            }else{
                betPointsPanel.setVisible(false);
                bet250.setVisible(false);
                bet500.setVisible(false);
                bet750.setVisible(false);
                bet1000.setVisible(false);
                askTheQuestion();
            }
        });
        bet250.add(bet250Button);

        //bet500 button
        JButton bet500Button = new JButton("500");
        bet500Button.setBackground(Color.BLACK);
        bet500Button.setForeground(Color.WHITE);
        bet500Button.setSize(100, 100);
        bet500Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet500Button.addActionListener(e -> {
            player.getWallet().setBet(500);
            if(players.size() == 2){
                betPoints2();
            }else{
                betPointsPanel.setVisible(false);
                bet250.setVisible(false);
                bet500.setVisible(false);
                bet750.setVisible(false);
                bet1000.setVisible(false);
                askTheQuestion();
            }
        });
        bet500.add(bet500Button);

        //bet750 button
        JButton bet750Button = new JButton("750");
        bet750Button.setBackground(Color.BLACK);
        bet750Button.setForeground(Color.WHITE);
        bet750Button.setSize(100, 100);
        bet750Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet750Button.addActionListener(e -> {
            player.getWallet().setBet(750);
            if(players.size() == 2){
                betPoints2();
            }else{
                betPointsPanel.setVisible(false);
                bet250.setVisible(false);
                bet500.setVisible(false);
                bet750.setVisible(false);
                bet1000.setVisible(false);
                askTheQuestion();
            }
        });
        bet750.add(bet750Button);

        //bet1000 button
        JButton bet1000Button = new JButton("1000");
        bet1000Button.setBackground(Color.BLACK);
        bet1000Button.setForeground(Color.WHITE);
        bet1000Button.setSize(100, 100);
        bet1000Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet1000Button.addActionListener(e -> {
            player.getWallet().setBet(1000);
            if(players.size() == 2){
                betPoints2();
            }else{
                betPointsPanel.setVisible(false);
                bet250.setVisible(false);
                bet500.setVisible(false);
                bet750.setVisible(false);
                bet1000.setVisible(false);
                askTheQuestion();
            }
        });
        bet1000.add(bet1000Button);
    }

    /**
     * In case there are two players, this method is used to accept the second player's bet.
     */
    public void betPoints2() {
        betPointsPanel.setVisible(false);

        //BetPoints panel
        betPointsPanel2 = new JPanel();
        betPointsPanel2.setBounds(100, 100, 600, 200);
        betPointsPanel2.setBackground(Color.BLACK);
        con.add(betPointsPanel2);

        //bet250 panel
        bet250.removeAll();

        //bet500 panel
        bet500.removeAll();

        //bet750 panel
        bet750.removeAll();

        //bet1000 panel
        bet1000.removeAll();

        //betPoints label
        JLabel betPoints2 = new JLabel("");
        betPoints2.setText(players.get(1).getNickname() + ", how risky are you?");
        betPoints2.setBounds(100, 100, 600, 200);
        betPoints2.setBackground(Color.black);
        betPoints2.setForeground(Color.WHITE);
        betPoints2.setFont(new Font("Carlito", Font.PLAIN, 50));
        betPoints2.setHorizontalAlignment(JLabel.CENTER);
        betPoints2.setVerticalAlignment(JLabel.CENTER);
        betPointsPanel2.add(betPoints2);

        //bet250 button
        JButton bet250Button = new JButton("250");
        bet250Button.setBackground(Color.BLACK);
        bet250Button.setForeground(Color.WHITE);
        bet250Button.setSize(100, 100);
        bet250Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet250Button.addActionListener(e -> {
            players.get(1).getWallet().setBet(250);
            betPointsPanel2.setVisible(false);
            bet250.setVisible(false);
            bet500.setVisible(false);
            bet750.setVisible(false);
            bet1000.setVisible(false);
            askTheQuestion();
        });
        bet250.add(bet250Button);

        //bet500 button
        JButton bet500Button = new JButton("500");
        bet500Button.setBackground(Color.BLACK);
        bet500Button.setForeground(Color.WHITE);
        bet500Button.setSize(100, 100);
        bet500Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet500Button.addActionListener(e -> {
            players.get(1).getWallet().setBet(500);
            betPointsPanel2.setVisible(false);
            bet250.setVisible(false);
            bet500.setVisible(false);
            bet750.setVisible(false);
            bet1000.setVisible(false);
            askTheQuestion();
        });
        bet500.add(bet500Button);

        //bet750 button
        JButton bet750Button = new JButton("750");
        bet750Button.setBackground(Color.BLACK);
        bet750Button.setForeground(Color.WHITE);
        bet750Button.setSize(100, 100);
        bet750Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet750Button.addActionListener(e -> {
            players.get(1).getWallet().setBet(750);
            betPointsPanel2.setVisible(false);
            bet250.setVisible(false);
            bet500.setVisible(false);
            bet750.setVisible(false);
            bet1000.setVisible(false);
            askTheQuestion();
        });
        bet750.add(bet750Button);

        //bet1000 button
        JButton bet1000Button = new JButton("1000");
        bet1000Button.setBackground(Color.BLACK);
        bet1000Button.setForeground(Color.WHITE);
        bet1000Button.setSize(100, 100);
        bet1000Button.setFont(new Font("Carlito", Font.PLAIN, 40));
        bet1000Button.addActionListener(e -> {
            players.get(1).getWallet().setBet(1000);
            betPointsPanel2.setVisible(false);
            bet250.setVisible(false);
            bet500.setVisible(false);
            bet750.setVisible(false);
            bet1000.setVisible(false);
            askTheQuestion();
        });
        bet1000.add(bet1000Button);
    }

    /**
     * This method displays the question accompanied by the four possible answers and an image if necessary.
     * It also implements a key listener in order to receive the answer of the user(s).
     */
    public void askTheQuestion(){
        timer4 = new Timer(10000,e->{
            System.out.println("inside timer 4");
            bottomPanel.setVisible(false);
            answerPanelA.setVisible(false);
            answerPanelB.setVisible(false);
            answerPanelC.setVisible(false);
            answerPanelD.setVisible(false);
            centerPanel.setVisible(false);
            questionPanel.setVisible(false);
            timer4.stop();
            correctAnswer();
        });

        if(type instanceof StopTheTimer){
            System.out.println("iside if");
            timer4.start();
        }
        announcingCategoryPanel.setVisible(false);
        String questionImageName= question.getImageName();

        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setBounds(100,10,600,250);

        JLabel label = new JLabel();

        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        if(!(questionImageName.equals("null"))){
            label.setIcon(new ImageIcon(questionImageName));
        }
        label.setVisible(true);

        centerPanel.add(label);
        centerPanel.setVisible(true);
        con.add(centerPanel, BorderLayout.CENTER);

        questionPanel = new JPanel();
        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel.setBounds(0,260,800,80);
        questionPanel.setBackground(Color.pink);

        answers = question.getAnswers();

        String q = question.getQuestion();
        StringBuilder tooLong;
        if(q.length() > 60){
            tooLong = new StringBuilder("<html>");
            for (String part: q.split("\\* ",2))
            {
                tooLong.append(part).append("<br/>");
            }
            tooLong.append("<html>");
            q = tooLong.toString();
        }

        JLabel labelQ = new JLabel();
        labelQ.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelQ.setHorizontalAlignment(JLabel.LEFT);
        labelQ.setText(q);
        labelQ.setFont(new Font("Carlito",Font.PLAIN,25));
        labelQ.setSize(800,50 );
        labelQ.setVisible(true);
        questionPanel.add(labelQ);

        con.add(questionPanel);

        JLabel labelA = new JLabel();
        labelA.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelA.setHorizontalAlignment(JLabel.LEFT);
        labelA.setText("A: " + answers.get(0));
        labelA.setFont(new Font("Carlito",Font.PLAIN,20));
        labelA.setVisible(true);

        answerPanelA = new JPanel();
        answerPanelA.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelA.setBounds(100,340,300,40);
        answerPanelA.setBackground(Color.PINK);
        answerPanelA.add(labelA);
        con.add(answerPanelA);

        JLabel labelB = new JLabel();
        labelB.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelB.setHorizontalAlignment(JLabel.RIGHT);
        labelB.setText("B: " + answers.get(1));
        labelB.setFont(new Font("Carlito",Font.PLAIN,20));
        labelB.setVisible(true);

        answerPanelB = new JPanel();
        answerPanelB.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelB.setBounds(400,340,300,40);
        answerPanelB.setBackground(Color.PINK);
        answerPanelB.add(labelB);
        con.add(answerPanelB);


        JLabel labelC = new JLabel();
        labelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelC.setHorizontalAlignment(JLabel.LEFT);
        labelC.setText("C: " + answers.get(2));
        labelC.setFont(new Font("Carlito",Font.PLAIN,20));
        labelC.setVisible(true);

        answerPanelC = new JPanel();
        answerPanelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelC.setBounds(100,380,300,40);
        answerPanelC.setBackground(Color.PINK);
        answerPanelC.add(labelC);
        con.add(answerPanelC);

        JLabel labelD = new JLabel();
        labelD.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelD.setHorizontalAlignment(JLabel.RIGHT);
        labelD.setText("D: " + answers.get(3));
        labelD.setFont(new Font("Carlito",Font.PLAIN,20));
        labelD.setVisible(true);

        answerPanelD = new JPanel();
        answerPanelD.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelD.setBounds(400,380,300,40);
        answerPanelD.setBackground(Color.PINK);
        answerPanelD.add(labelD);
        con.add(answerPanelD);

        JLabel instructionLabel = new JLabel("BUTTONS FOR Player 1: A->Q,B->W,C->E,D->R    BUTTONS FOR Player 2: A->U,B->I,C->O,D->P");
        instructionLabel.setSize(800,110);
        instructionLabel.setBackground(Color.BLACK);
        instructionLabel.setFont(new Font("Carlito",Font.PLAIN,20));
        instructionLabel.setForeground(Color.WHITE);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBounds(0,425,800,50);
        bottomPanel.setBackground(Color.black);
        bottomPanel.add(instructionLabel);
        con.add(bottomPanel);

        frame.addKeyListener(new MyKeyListener());
        frame.setVisible(false);
        frame.setVisible(true);
        startTime = System.currentTimeMillis();

    }

    /**
     * KeyListener stores the answer(s) from the keyboard and after checking their validness sets changes the status
     * of the player(s) if needed. It also stores the amount of time that passed until an answer was given for each
     * player, if the type of round requests it.
     */
    class MyKeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent event){

            int key = event.getKeyCode();
             if(numberOfPlayers ==1){
                 if(key == KeyEvent.VK_Q){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(0);
                 }else if(key == KeyEvent.VK_W){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(1);
                 }else if(key == KeyEvent.VK_E){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(2);
                 }else if(key == KeyEvent.VK_R){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(3);
                 }
             }else if(numberOfPlayers == 2){
                 if(key == KeyEvent.VK_Q){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(0);
                 }else if(key == KeyEvent.VK_W){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(1);
                 }else if(key == KeyEvent.VK_E){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(2);
                 }else if(key == KeyEvent.VK_R){
                     endTime1 = System.currentTimeMillis();
                     answer1 = answers.get(3);
                 }else if(key == KeyEvent.VK_U){
                     endTime2 = System.currentTimeMillis();
                     answer2 = answers.get(0);
                 }else if(key == KeyEvent.VK_I){
                     endTime2 = System.currentTimeMillis();
                     answer2 = answers.get(1);
                 }else if(key == KeyEvent.VK_O){
                     endTime2 = System.currentTimeMillis();
                     answer2 = answers.get(2);
                 }else if(key == KeyEvent.VK_P){
                     endTime2 = System.currentTimeMillis();
                     answer2 = answers.get(3);
                 }
             }

            if(numberOfPlayers == 1 && answer1!= null){
                ArrayList<String> answers = new ArrayList<>();
                long [] times = new long[1];
                times[0] = endTime1;
                answers.add(answer1);
                players = game.setStatuses(answers,question.getCorrectAnswer(), players);
                game.setTime(times,startTime,type,players);
                game.changePoints(type);
                answer1 = null;
                frame.removeKeyListener(this);
                if(type instanceof StopTheTimer){
                    timer4.stop();
                }
                correctAnswer();
            }else if(numberOfPlayers == 2 && answer1!= null && answer2 != null){
                ArrayList<String> answers = new ArrayList<>();
                long [] times = new long[2];

                times[0] = endTime1;
                times[1] = endTime2;
                answers.add(answer1);
                answers.add(answer2);
                game.setStatuses(answers,question.getCorrectAnswer(),players);
                answer1 = null;
                answer2 = null;
                answers.clear();
                game.setTime(times,startTime,type, players);
                game.changePoints(type);
                frame.removeKeyListener(this);
                if(type instanceof StopTheTimer){
                    timer4.stop();
                }
                correctAnswer();
            }
        }
    }

    /**
     * This function prints the correct answer to the question asked previously.
     */
    public void correctAnswer(){
        //Turn off previous panels
        bottomPanel.setVisible(false);
        answerPanelA.setVisible(false);
        answerPanelB.setVisible(false);
        answerPanelC.setVisible(false);
        answerPanelD.setVisible(false);
        centerPanel.setVisible(false);
        questionPanel.setVisible(false);

        correctAnswerTextPanel = new JPanel();
        correctAnswerTextPanel.setBackground(Color.BLACK);
        correctAnswerTextPanel.setBounds(50, 50, 700, 200);
        con.add(correctAnswerTextPanel);

        correctAnswerPanel = new JPanel();
        correctAnswerPanel.setBackground(Color.black);
        correctAnswerPanel.setBounds(50, 250, 700, 200);
        con.add(correctAnswerPanel);

        JLabel theCorrectAnswer = new JLabel("The correct answer is...");
        theCorrectAnswer.setBounds(50, 50, 700, 200);
        theCorrectAnswer.setBackground(Color.black);
        theCorrectAnswer.setForeground(Color.WHITE);
        theCorrectAnswer.setFont(new Font("Carlito", Font.PLAIN, 70));
        theCorrectAnswer.setHorizontalAlignment(JLabel.CENTER);
        theCorrectAnswer.setVerticalAlignment(JLabel.CENTER);
        correctAnswerTextPanel.add(theCorrectAnswer);

        JLabel is = new JLabel(question.getCorrectAnswer());
        is.setBounds(50, 250, 700, 200);
        is.setBackground(Color.pink);
        is.setForeground(Color.WHITE);
        is.setFont(new Font("Carlito", Font.PLAIN, 30));
        is.setHorizontalAlignment(JLabel.CENTER);
        is.setVerticalAlignment(JLabel.CENTER);
        correctAnswerPanel.add(is);

        correctAnswerPanel.setVisible(false);

        timer2 = new Timer(2000, e -> {
            correctAnswerPanel.setVisible(false);
            correctAnswerTextPanel.setVisible(false);
            timer1.stop();
            timer2.stop();
            showScores();
        });
        timer1 = new Timer(2000, e -> {
            correctAnswerPanel.setVisible(true);
            timer1.stop();
            timer2.start();
        });
        timer1.start();
    }

    /**
     * This method informs the player(s) about the accuracy of their answer and displays the current score situation.
     */
    public void showScores(){
        correctAnswerPanel.setVisible(false);
        correctAnswerTextPanel.setVisible(false);

        String score1;
        String score2 = null;
        boolean status1;
        boolean status2 = false;
        String answered1 = players.get(0).getNickname() + ", maybe next time!";
        String answered2 = null;

        score1 = players.get(0).getNickname() + ": " + players.get(0).getScore();
        status1 = players.get(0).getStatus();

        if(numberOfPlayers == 2){
            score2 = players.get(1).getNickname() + ": " + players.get(1).getScore();
            status2 = players.get(1).getStatus();
            answered2 = players.get(1).getNickname() + ", maybe next time!";
        }
        if(status1){
            answered1 = players.get(0).getNickname() + ", you guessed correctly!";
        }
        if(status2){
            answered2 = players.get(1).getNickname() + ", you guessed correctly!";
        }

        if(type instanceof Thermometer){
            if(!((Thermometer) type).getSomeoneWon()) {
                score1 = players.get(0).getNickname() + "'s streak: " + players.get(0).getWallet().getStreak();
                score2 = players.get(1).getNickname() + "'s streak: " + players.get(1).getWallet().getStreak();
            }
        }

        showStatusPanel1 = new JPanel();
        showStatusPanel1.setBounds(50, 50, 700, 80);
        showStatusPanel1.setLayout(new BorderLayout());
        showStatusPanel1.setBackground(Color.black);
        con.add(showStatusPanel1);

        showStatusPanel2 = new JPanel();
        showStatusPanel2.setBounds(50, 130, 700, 80);
        showStatusPanel2.setLayout(new BorderLayout());
        showStatusPanel2.setBackground(Color.black);
        con.add(showStatusPanel2);

        showScoreTextPanel = new JPanel();
        showScoreTextPanel.setBounds(50, 210, 700, 80);
        showScoreTextPanel.setLayout(new BorderLayout());
        showScoreTextPanel.setBackground(Color.black);
        con.add(showScoreTextPanel);

        showScorePanel1 = new JPanel();
        showScorePanel1.setBounds(50, 290, 700, 80);
        showScorePanel1.setLayout(new BorderLayout());
        showScorePanel1.setBackground(Color.black);
        con.add(showScorePanel1);

        showScorePanel2 = new JPanel();
        showScorePanel2.setBounds(50, 370, 700, 80);
        showScorePanel2.setLayout(new BorderLayout());
        showScorePanel2.setBackground(Color.black);
        con.add(showScorePanel2);

        JLabel showStatus1 = new JLabel(answered1);
        showStatus1.setFont(new Font("Carlito", Font.PLAIN, 30));
        showStatus1.setForeground(Color.WHITE);
        showStatus1.setHorizontalAlignment(JLabel.CENTER);
        showStatus1.setVerticalAlignment(JLabel.CENTER);
        showStatusPanel1.add(showStatus1);

        JLabel showStatus2 = new JLabel(answered2);
        showStatus2.setFont(new Font("Carlito", Font.PLAIN, 30));
        showStatus2.setForeground(Color.WHITE);
        showStatus2.setHorizontalAlignment(JLabel.CENTER);
        showStatus2.setVerticalAlignment(JLabel.CENTER);
        showStatusPanel2.add(showStatus2);

        JLabel showScoreText = new JLabel("The score is:");
        showScoreText.setFont(new Font("Carlito", Font.PLAIN, 50));
        showScoreText.setForeground(Color.WHITE);
        showScoreText.setHorizontalAlignment(JLabel.CENTER);
        showScoreText.setVerticalAlignment(JLabel.CENTER);
        showScoreTextPanel.add(showScoreText);

        JLabel showScore1 = new JLabel(score1);
        showScore1.setFont(new Font("Carlito", Font.PLAIN, 30));
        showScore1.setForeground(Color.WHITE);
        showScore1.setHorizontalAlignment(JLabel.CENTER);
        showScoreText.setVerticalAlignment(JLabel.CENTER);
        showScorePanel1.add(showScore1);

        JLabel showScore2 = new JLabel(score2);
        showScore2.setFont(new Font("Carlito", Font.PLAIN, 30));
        showScore2.setForeground(Color.WHITE);
        showScore2.setHorizontalAlignment(JLabel.CENTER);
        showScoreText.setVerticalAlignment(JLabel.CENTER);
        showScorePanel2.add(showScore2);

        if(numberOfPlayers == 1){
            showStatusPanel2.setVisible(false);
            showScorePanel2.setVisible(false);
        }

        timer3 = new Timer(4000, e -> {
            questions++;

            if(type instanceof Thermometer && !((Thermometer) type).getSomeoneWon()){
                defaultNumQuestions++;
            }else if(type instanceof Thermometer && ((Thermometer) type).getSomeoneWon()){
                ((Thermometer) type).initializeSomeoneWon();
                defaultNumQuestions = game.getNumberOfQuestions();
            }

            game.defaultifyPlayers(players, type);

            showStatusPanel1.setVisible(false);
            showStatusPanel2.setVisible(false);
            showScoreTextPanel.setVisible(false);
            showScorePanel1.setVisible(false);
            showScorePanel2.setVisible(false);

            timer3.stop();
            questionNumber();
        });
        timer3.start();
    }

    /**
     * finalScores shows the score that the player in one-player mode has when the game ends.
     */
    public void finalScore(){
        RoundNumberPanel.setVisible(false);

        playerFinalScoreTextPanel = new JPanel();
        playerFinalScoreTextPanel.setBounds(50, 50, 700, 200);
        playerFinalScoreTextPanel.setLayout(new BorderLayout());
        playerFinalScoreTextPanel.setBackground(Color.black);
        con.add(playerFinalScoreTextPanel);

        playerFinalScorePanel = new JPanel();
        playerFinalScorePanel.setBounds(250, 250, 300, 100);
        playerFinalScorePanel.setLayout(new BorderLayout());
        playerFinalScorePanel.setBackground(Color.black);
        con.add(playerFinalScorePanel);

        JLabel playerFinalScoreText = new JLabel(players.get(0).getNickname() + ", your final score is:");
        playerFinalScoreText.setFont(new Font("Carlito", Font.PLAIN, 50));
        playerFinalScoreText.setForeground(Color.WHITE);
        playerFinalScoreText.setHorizontalAlignment(JLabel.CENTER);
        playerFinalScoreTextPanel.add(playerFinalScoreText);

        JLabel playerFinalScore = new JLabel(String.valueOf(players.get(0).getScore()));
        playerFinalScore.setFont(new Font("Carlito", Font.PLAIN, 80));
        playerFinalScore.setForeground(Color.WHITE);
        playerFinalScore.setHorizontalAlignment(JLabel.CENTER);
        playerFinalScore.setVerticalAlignment(JLabel.CENTER);
        playerFinalScorePanel.add(playerFinalScore);

        timer2 = new Timer(3000, e -> {
            playerFinalScorePanel.setVisible(false);
            playerFinalScoreTextPanel.setVisible(false);
            timer2.stop();
            replay();
        });
        timer2.start();
    }

    /**
     * Announces the winner of the two-player game accompanied by the final score.
     */
    public void winner(){
        RoundNumberPanel.setVisible(false);
        String TheWinner;

        if(players.get(0).getScore() > players.get(1).getScore()){
            TheWinner = players.get(0).getNickname();
        }else{
            TheWinner = players.get(1).getNickname();
        }

        AndTheWinnerIsPanel = new JPanel();
        AndTheWinnerIsPanel.setBounds(50, 50, 700, 150);
        AndTheWinnerIsPanel.setLayout(new BorderLayout());
        AndTheWinnerIsPanel.setBackground(Color.black);
        frame.add(AndTheWinnerIsPanel);

        JLabel andTheWinnerIs = new JLabel("And the winner is . . .");
        andTheWinnerIs.setFont(new Font("Carlito", Font.PLAIN, 50));
        andTheWinnerIs.setForeground(Color.WHITE);
        andTheWinnerIs.setHorizontalAlignment(JLabel.CENTER);
        AndTheWinnerIsPanel.add(andTheWinnerIs);

        winnerPanel = new JPanel();
        winnerPanel.setBounds(250, 200, 300, 100);
        winnerPanel.setLayout(new BorderLayout());
        winnerPanel.setBackground(Color.black);
        frame.add(winnerPanel);

        JLabel winner = new JLabel(TheWinner);
        winner.setFont(new Font("Carlito", Font.PLAIN, 30));
        winner.setForeground(Color.WHITE);
        winner.setHorizontalAlignment(JLabel.CENTER);
        winnerPanel.add(winner);

        FinalScoresPanel = new JPanel();
        FinalScoresPanel.setBounds(50, 300, 700, 100);
        FinalScoresPanel.setLayout(new BorderLayout());
        FinalScoresPanel.setBackground(Color.black);
        frame.add(FinalScoresPanel);

        JLabel finalScores = new JLabel("Your final scores were:");
        finalScores.setFont(new Font("Carlito", Font.PLAIN, 50));
        finalScores.setForeground(Color.WHITE);
        finalScores.setHorizontalAlignment(JLabel.CENTER);
        FinalScoresPanel.add(finalScores);

        finalLeftScorePanel = new JPanel();
        finalLeftScorePanel.setBounds(100, 400, 250, 50);
        finalLeftScorePanel.setLayout(new BorderLayout());
        finalLeftScorePanel.setBackground(Color.black);
        frame.add(finalLeftScorePanel);

        JLabel finaLeftScore = new JLabel(players.get(0).getNickname() + ": " + players.get(0).getScore());
        finaLeftScore.setFont(new Font("Carlito", Font.PLAIN, 30));
        finaLeftScore.setForeground(Color.WHITE);
        finaLeftScore.setHorizontalAlignment(JLabel.CENTER);
        finalLeftScorePanel.add(finaLeftScore);

        finalRightScorePanel = new JPanel();
        finalRightScorePanel.setBounds(450, 400, 250, 50);
        finalRightScorePanel.setLayout(new BorderLayout());
        finalRightScorePanel.setBackground(Color.black);
        frame.add(finalRightScorePanel);

        JLabel finaRightScore = new JLabel(players.get(1).getNickname() + ": " + players.get(1).getScore());
        finaRightScore.setFont(new Font("Carlito", Font.PLAIN, 30));
        finaRightScore.setForeground(Color.WHITE);
        finaRightScore.setHorizontalAlignment(JLabel.CENTER);
        finalRightScorePanel.add(finaRightScore);

        timer3 = new Timer(3000, e -> {
            FinalScoresPanel.setVisible(false);
            winnerPanel.setVisible(false);
            AndTheWinnerIsPanel.setVisible(false);
            finalRightScorePanel.setVisible(false);
            finalLeftScorePanel.setVisible(false);
            finalRightScorePanel.setVisible(false);
            replay();
            timer3.stop();
        });
        timer3.start();
    }

    /**
     * Asks the user if they want to play again and initializes all the objects used in the game in order to prepare
     * for a new game.
     */
    public void replay(){

        game.gameEnd(players);
        players.clear();
        questions = 1;
        rounds = 1;
        //game.initializePlayersScore(players);
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Replay", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
            frame.dispose();
        }
        else if (response == JOptionPane.YES_OPTION) {
            basicDisplay();
        }
        else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
            frame.dispose();
        }
    }

    /**
     * The main method creates a UserInteraction object, which contains all the graphics for the game and calls the first
     * method.
     * @param args arguments for the main method
     */
    public static void main(String [] args){
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.basicDisplay();
    }
}
