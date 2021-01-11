import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
import java.util.TimerTask;



/**
 * This class contains all the interactions with the user, asks all the questions, prints all
 * the messages and collects the data that we need from the users.
 */

public class UserInteraction implements KeyListener {
    private JFrame frame;
    private Questions question;
    private Game game = new Game();
    private Type type = new Type() {
        @Override
        public void changePoints() {

        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getExplanation() {
            return null;
        }
    };
    private ArrayList<Player> players = new ArrayList<>();
    private int numberOfPlayers = 0;
    private int rounds = 1;
    private int questions = 1;
    Scanner input = new Scanner(System.in);
    private Container con;
    private JPanel startTextPanel;
    private JPanel startButtonPanel;
    private JPanel HMPPanel, HMPLeftPanel, HMPRightPanel;
    private JPanel NamePanelText, NamePanel, readyPanel, letsGoPanel;
    private JPanel RoundNumberPanel, QuestionNumberPanel, RQOkayPanel, TypePanel, TypeExplanationPanel, typeOkayPanel;
    private JPanel announcingCategoryPanel;
    private JPanel betPointsPanel, bet250, bet500, bet750, bet1000;
    private JPanel  centerPanel , bottomPanel, questionPanel, answerPanelA, answerPanelB, answerPanelC, answerPanelD;
    private JPanel correctAnswerTextPanel, correctAnswerPanel, nextQuestion, scoresPanel;
    private String answer1, answer2;
    private ArrayList<String> answers = new ArrayList<>();
    private JPanel highScoresButtonPanel, totalWinsButtonPanel, goButtonPanel;
    private JTextField nickname;
    private Timer timer1, timer2,timer3,timer4,timer5;

    public UserInteraction(){
        answer1 = new String();
        answer2 = new String();

        //The basic frame
        frame = new JFrame("Buzz Quiz");
        //Look & Layout
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); //bazei to frame sto kentro ths o8onhs
        frame.setVisible(true);
        basicDisplay();

    }

    private void basicDisplay(){

        con = frame.getContentPane();
        //con.setLayout(new CardLayout());
        con.setPreferredSize(new Dimension(800,500));
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
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTextPanel.setVisible(false);
                startButtonPanel.setVisible(false);
                highScoresButtonPanel.setVisible(false);
                totalWinsButtonPanel.setVisible(false);
                HowManyOfYou();
            }
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
        highScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTextPanel.setVisible(false);
                startButtonPanel.setVisible(false);
                highScoresButtonPanel.setVisible(false);
                totalWinsButtonPanel.setVisible(false);
                showHighScores();
            }
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
        totalWinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTextPanel.setVisible(false);
                startButtonPanel.setVisible(false);
                highScoresButtonPanel.setVisible(false);
                totalWinsButtonPanel.setVisible(false);
                showTotalWins();
            }
        });
        totalWinsButtonPanel.add(totalWinsButton);

    }

    /**
     *
     */
    private void showHighScores(){
        String [] data = game.getHighScores();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String sting: data){
            System.out.println(sting);
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //list.setVisible(false);
                pane.setVisible(false);
                panel.setVisible(false);
                basicDisplay();
            }
        });


        panel.setBounds(100,400,100,100);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.GRAY);
        panel.add(backButton);
        con.add(panel);

    }


    /**
     *
     */
    private void showTotalWins(){
        String [] data = game.getTotalWins();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String sting: data){
            System.out.println(sting);
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //list.setVisible(false);
                pane.setVisible(false);
                panel.setVisible(false);
                basicDisplay();
            }
        });


        panel.setBounds(100,400,100,100);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.GRAY);
        panel.add(backButton);
        con.add(panel);


    }





    /**
     *
     */
    public void HowManyOfYou(){
        //The panel for the text
        HMPPanel = new JPanel();
        //Look & Layout
        HMPPanel.setBounds(100, 100, 500, 250);
        HMPPanel.setBackground(Color.black);
        con.add(HMPPanel);

        //The area that holds the text
        JTextArea HMPText = new JTextArea("Choose the number of players for this game:");
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
                HMPPanel.setVisible(false);
                HMPLeftPanel.setVisible(false);
                HMPRightPanel.setVisible(false);
                numberOfPlayers = 1;
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
                HMPPanel.setVisible(false);
                HMPLeftPanel.setVisible(false);
                HMPRightPanel.setVisible(false);
                numberOfPlayers = 2;
                God(2);
            }
        });
        HMPRightPanel.add(twoPlayers);
    }

    /**
     * Function God, creates the human beings of this game. Asks for the name
     * of the player, creates a Player object with that name that is going
     * to be added to the playerList.
     * @return A Player object
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
        readyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("inside first if!");
                Player playerOne = new Player();
                playerOne.setNickname(nickname.getText());
                players.add(playerOne);
                game.setPlayerList(players);
                if(numberOfPlayers == 2){
                    NamePanelText.setVisible(false);
                    NamePanel.setVisible(false);
                    readyPanel.setVisible(false);
                    con.remove(readyPanel);
                    nickname.setText("");
                    God2();
                }else{
                    try{
                        LetsGo();
                    }catch(InterruptedException ie) {

                        System.out.println("got interrupted!");

                    }
                }

            }
        });

    }

    private void God2() {
        NamePanelText.setVisible(false);
        NamePanel.setVisible(false);
        readyPanel.setVisible(false);
        //con.remove(readyPanel);
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

        System.out.println("inside god2!");

            readyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Player playerOne = new Player();
                    playerOne.setNickname(nickname.getText());
                    players.add(playerOne);
                    game.setPlayerList(players);
                    try {
                        NamePanelText.setVisible(false);
                        NamePanel.setVisible(false);
                        readyPanel.removeAll();
                        con.remove(readyPanel);
                        readyPanel.setVisible(false);
                        LetsGo();
                    } catch (InterruptedException ie) {

                        System.out.println("got interrupted!");

                    }


                }
            });

    }



    public void LetsGo() throws InterruptedException {
        NamePanelText.setVisible(false);
        NamePanel.setVisible(false);
        readyPanel.setVisible(false);

        //randomize questions
        game.randomizeQuestions();

        //disable previous panels

        letsGoPanel = new JPanel();
        letsGoPanel.setBounds(0, 100, 800, 400);
        letsGoPanel.setBackground(Color.BLACK);
        con.add(letsGoPanel);

        JLabel text1 = new JLabel("LET");
        text1.setBounds(0, 100, 800, 400);
        text1.setBackground(Color.black);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Carlito", Font.PLAIN, 300));
        text1.setHorizontalAlignment(JLabel.CENTER);
        text1.setVerticalAlignment(JLabel.CENTER);
        letsGoPanel.add(text1);

        JLabel text2 = new JLabel("THE");
        text2.setBounds(0, 100, 800, 400);
        text2.setBackground(Color.black);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Carlito", Font.PLAIN, 300));
        text2.setHorizontalAlignment(JLabel.CENTER);
        text2.setVerticalAlignment(JLabel.CENTER);
        letsGoPanel.add(text2);

        JLabel text3 = new JLabel("GAME");
        text3.setBounds(0, 100, 800, 400);
        text3.setBackground(Color.black);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("Carlito", Font.PLAIN, 300));
        text3.setHorizontalAlignment(JLabel.CENTER);
        text3.setVerticalAlignment(JLabel.CENTER);
        letsGoPanel.add(text3);

        JLabel text4 = new JLabel("BEGIN");
        text4.setBounds(0, 100, 800, 400);
        text4.setBackground(Color.black);
        text4.setForeground(Color.WHITE);
        text4.setFont(new Font("Carlito", Font.PLAIN, 300));
        text4.setHorizontalAlignment(JLabel.CENTER);
        text4.setVerticalAlignment(JLabel.CENTER);
        letsGoPanel.add(text4);

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
            RoundNumberQuestionNumber();

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
     * ROUND i, QUESTION j, and all the variable get ready.
     */
    public void RoundNumberQuestionNumber(){
        //Turn off previous panel
        con.removeAll();
        if(rounds - 1 < game.getHowManyRounds()) {
            if(questions - 1 < game.getNumberOfQuestions()) {
                //Panel for the round label
                RoundNumberPanel = new JPanel();
                RoundNumberPanel.setBounds(0, 50, 800, 200);
                RoundNumberPanel.setBackground(Color.PINK);
                con.add(RoundNumberPanel);

                //Panel for the question label
                QuestionNumberPanel = new JPanel();
                QuestionNumberPanel.setBounds(0, 250, 800, 100);
                QuestionNumberPanel.setBackground(Color.DARK_GRAY);
                con.add(QuestionNumberPanel);

                //Label ROUND i
                JLabel roundLabel = new JLabel("Round " + rounds);
                roundLabel.setBounds(0, 50, 800, 200);
                roundLabel.setBackground(Color.PINK);
                roundLabel.setForeground(Color.WHITE);
                roundLabel.setFont(new Font("Carlito", Font.PLAIN, 200));
                roundLabel.setHorizontalAlignment(JLabel.CENTER);
                roundLabel.setVerticalAlignment(JLabel.CENTER);
                RoundNumberPanel.add(roundLabel);

                //Label QUESTION j
                JLabel questionLabel = new JLabel("Question " + questions);
                questionLabel.setBounds(0, 250, 800, 100);
                questionLabel.setBackground(Color.black);
                questionLabel.setForeground(Color.WHITE);
                questionLabel.setFont(new Font("Carlito", Font.PLAIN, 100));
                questionLabel.setHorizontalAlignment(JLabel.CENTER);
                questionLabel.setVerticalAlignment(JLabel.CENTER);
                QuestionNumberPanel.add(questionLabel);

                //next method panel
                RQOkayPanel = new JPanel();
                RQOkayPanel.setBounds(550, 350, 100, 50);
                RQOkayPanel.setBackground(Color.YELLOW);

                //next method button
                JButton okayButton = new JButton("Okay");
                okayButton.setBackground(Color.PINK);
                okayButton.setForeground(Color.WHITE);
                okayButton.setSize(50, 50);
                okayButton.setFont(new Font("Carlito", Font.PLAIN, 30));
                RQOkayPanel.add(okayButton);
                con.add(RQOkayPanel);
                okayButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // System.out.println("inside action listerner");
                        RoundNumberPanel.setVisible(false);
                        QuestionNumberPanel.setVisible(false);
                        RQOkayPanel.setVisible(false);
                        con.remove(RQOkayPanel);
                        RQOkayPanel.setVisible(false);
                        announcingTheType();
                    }
                });
                question = game.getNewQuestion();

            }else{
                rounds++;
                questions = 1;
                RoundNumberQuestionNumber();
             }
        }else{
            //game is done
        }
    }


    /**
     * Function announcingTheType accepts a Type object and prints a message that announces the type name
     * through the getName method. Then it explains the way you play the game depending on the type.
     * @value type is a Type of game that is randomly chosen in an other class.
     */
    public void announcingTheType(){
        //Turn off previous panels
        RoundNumberPanel.setVisible(false);
        QuestionNumberPanel.setVisible(false);
        RQOkayPanel.setVisible(false);
        con.removeAll();
        RoundNumberPanel.removeAll();
        QuestionNumberPanel.removeAll();
        RQOkayPanel.removeAll();

        //Get random type from game
        type = game.getRandomType();

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
//        typeExplanationLabel.setHorizontalAlignment(JLabel.CENTER);
//        typeExplanationLabel.setVerticalAlignment(JLabel.CENTER);

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
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                announcingCategory();
            }
        });
        typeOkayPanel.add(okay);


    }

    /**
     * Function announcingCategory accepts a Questions type object and announces the category of the question
     * to the player.
     */
    public void announcingCategory(){
        //Turn off previous panels
        TypePanel.setVisible(false);
        TypeExplanationPanel.setVisible(false);
        typeOkayPanel.setVisible(false);

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

        JButton goButton = new JButton("GO!");
        goButton.setBackground(Color.PINK);
        goButton.setForeground(Color.WHITE);
        goButton.setSize(100, 100);
        goButton.setFont(new Font("Carlito", Font.PLAIN, 30));

        goButtonPanel = new JPanel();
        goButtonPanel.setBounds(350,300,100,100);
        goButtonPanel.setBackground(Color.BLACK);
        goButtonPanel.add(goButton);
        con.add(goButtonPanel);




    }


    //PREPEI NA PROSTHESW TO PWS THA ERXESAI KAI THA FEYGEIS APO EDW
    /**
     * BetPoints function, asks the player to bet and saves the amount in an int variable.
     * @return the betPoints variable, which contains the points bet by the player.
     */
    public void betPoints() {
        //turn off previous panels

        for(Player player : players){
            //BetPoints panel
            betPointsPanel = new JPanel();
            betPointsPanel.setBounds(100, 100, 600, 200);
            betPointsPanel.setBackground(Color.BLACK);
            con.add(betPointsPanel);

            //bet250 panel
            bet250 = new JPanel();
            bet250.setBounds(50, 350, 130, 100);
            bet250.setBackground(Color.BLACK);
            con.add(bet250);

            //bet500 panel
            bet500 = new JPanel();
            bet500.setBounds(50, 350, 130, 100);
            bet500.setBackground(Color.BLACK);
            con.add(bet500);

            //bet750 panel
            bet750 = new JPanel();
            bet750.setBounds(50, 350, 130, 100);
            bet750.setBackground(Color.BLACK);
            con.add(bet750);

            //bet1000 panel
            bet1000 = new JPanel();
            bet1000.setBounds(50, 350, 130, 100);
            bet1000.setBackground(Color.BLACK);
            con.add(bet1000);

            //betPoints label
            JLabel betPoints = new JLabel(player.getNickname() + ", how risky are you?");
            betPoints.setBounds(100, 100, 600, 200);
            betPoints.setBackground(Color.black);
            betPoints.setForeground(Color.WHITE);
            betPoints.setFont(new Font("Carlito", Font.PLAIN, 100));
            betPoints.setHorizontalAlignment(JLabel.CENTER);
            betPoints.setVerticalAlignment(JLabel.CENTER);
            betPointsPanel.add(betPoints);

            //bet250 button
            JButton bet250Button = new JButton("250");
            bet250Button.setBackground(Color.BLACK);
            bet250Button.setForeground(Color.WHITE);
            bet250Button.setSize(100, 100);
            bet250Button.setFont(new Font("Carlito", Font.PLAIN, 50));
            bet250Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.setBet(250);
                }
            });
            bet250.add(bet250Button);

            //bet500 button
            JButton bet500Button = new JButton("500");
            bet500Button.setBackground(Color.BLACK);
            bet500Button.setForeground(Color.WHITE);
            bet500Button.setSize(100, 100);
            bet500Button.setFont(new Font("Carlito", Font.PLAIN, 50));
            bet500Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.setBet(500);
                }
            });
            bet500.add(bet500Button);

            //bet750 button
            JButton bet750Button = new JButton("750");
            bet750Button.setBackground(Color.BLACK);
            bet750Button.setForeground(Color.WHITE);
            bet750Button.setSize(100, 100);
            bet750Button.setFont(new Font("Carlito", Font.PLAIN, 50));
            bet750Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.setBet(750);
                }
            });
            bet750.add(bet750Button);

            //bet1000 button
            JButton bet1000Button = new JButton("1000");
            bet1000Button.setBackground(Color.BLACK);
            bet1000Button.setForeground(Color.WHITE);
            bet1000Button.setSize(100, 100);
            bet1000Button.setFont(new Font("Carlito", Font.PLAIN, 50));
            bet1000Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.setBet(1000);
                }
            });
            bet1000.add(bet1000Button);

        }



    }


    /**
     * This void function accepts a Questions type object and prints the question and the four possible answers.
     */
    public void askTheQuestion(){
        JLabel label,labelA, labelB, labelC, labelD, labelQ;
        String questionImageName= question.getImageName();

        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setBounds(100,10,600,250);

        label =new JLabel();

        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        // elegxow gia to an h eikona einai yparkth
        if(!(questionImageName.equals("null"))){
            label.setIcon(new ImageIcon(questionImageName));
        }
        label.setVisible(true);

        centerPanel.add(label);
        centerPanel.setVisible(true);

        con.add(centerPanel, BorderLayout.CENTER);


        questionPanel = new JPanel();
        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel.setBounds(100,260,600,50);
        questionPanel.setBackground(Color.pink);

        answers = question.getAnswers();

        labelQ = new JLabel();
        labelQ.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelQ.setHorizontalAlignment(JLabel.LEFT);
        labelQ.setText(question.getQuestion());
        labelQ.setFont(new Font("Carlito",Font.PLAIN,25));
        labelQ.setVisible(true);
        questionPanel.add(labelQ);

        con.add(questionPanel);

        labelA = new JLabel();
        labelA.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelA.setHorizontalAlignment(JLabel.LEFT);
        labelA.setText("A: " + answers.get(0));
        labelA.setFont(new Font("Carlito",Font.PLAIN,20));
        labelA.setVisible(true);

        answerPanelA = new JPanel();
        answerPanelA.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelA.setBounds(100,310,300,40);
        answerPanelA.setBackground(Color.PINK);
        answerPanelA.add(labelA);
        con.add(answerPanelA);


        labelB = new JLabel();
        labelB.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelB.setHorizontalAlignment(JLabel.RIGHT);
        labelB.setText("B: " + answers.get(1));
        labelB.setFont(new Font("Carlito",Font.PLAIN,20));
        labelB.setVisible(true);

        answerPanelB = new JPanel();
        answerPanelB.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelB.setBounds(400,310,300,40);
        answerPanelB.setBackground(Color.PINK);
        answerPanelB.add(labelB);
        con.add(answerPanelB);


        labelC = new JLabel();
        labelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelC.setHorizontalAlignment(JLabel.LEFT);
        labelC.setText("C: " + answers.get(2));
        labelC.setFont(new Font("Carlito",Font.PLAIN,20));
        labelC.setVisible(true);

        answerPanelC = new JPanel();
        answerPanelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelC.setBounds(100,350,300,40);
        answerPanelC.setBackground(Color.PINK);
        answerPanelC.add(labelC);
        con.add(answerPanelC);

        labelD = new JLabel();
        labelD.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelD.setHorizontalAlignment(JLabel.RIGHT);
        labelD.setText("D: " + answers.get(3));
        labelD.setFont(new Font("Carlito",Font.PLAIN,20));
        labelD.setVisible(true);

        answerPanelD = new JPanel();
        answerPanelD.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanelD.setBounds(400,350,300,40);
        answerPanelD.setBackground(Color.PINK);
        answerPanelD.add(labelD);
        con.add(answerPanelD);


        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBounds(100,0,800,110);
        bottomPanel.setBackground(Color.PINK);
        con.add(bottomPanel);
        con.addKeyListener(this);
        con.validate();//validate the image
        con.setVisible(true);




    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(!answers.isEmpty()){
            if(key == KeyEvent.VK_Q){
                answer1 = answers.get(0);
            }else if(key == KeyEvent.VK_W){
                answer1 = answers.get(1);
            }else if(key == KeyEvent.VK_E){
                answer1 = answers.get(2);
            }else if(key == KeyEvent.VK_R){
                answer1 = answers.get(3);
            }
            if(game.getPlayerList().size() == 2){
                if(key == KeyEvent.VK_U){
                    answer2 = answers.get(0);
                }else if(key == KeyEvent.VK_I){
                    answer2 = answers.get(1);
                }else if(key == KeyEvent.VK_O){
                    answer2 = answers.get(2);
                }else if(key == KeyEvent.VK_P){
                    answer2 = answers.get(3);
                }
            }
        }
        answers.clear();


//        System.out.println(answer1);
//        System.out.println(answer2);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    /**
     * This function prints the correct answer to the question asked previously.
     */
    public void correctAnswer(){
        //change points
        type.changePoints();
        //Turn off previous panels

        correctAnswerTextPanel = new JPanel();
        correctAnswerTextPanel.setBackground(Color.BLACK);
        correctAnswerTextPanel.setBounds(100, 100, 150, 150);
        con.add(correctAnswerTextPanel);

        correctAnswerPanel = new JPanel();
        correctAnswerPanel.setBackground(Color.BLACK);
        correctAnswerPanel.setBounds(400, 100, 150, 150);
        con.add(correctAnswerPanel);

        nextQuestion = new JPanel();
        nextQuestion.setBackground(Color.BLACK);
        nextQuestion.setBounds(700, 400, 100, 100);
        con.add(nextQuestion);

        scoresPanel = new JPanel();
        scoresPanel.setBackground(Color.BLACK);
        scoresPanel.setBounds(100, 250, 300, 150);
        con.add(scoresPanel);

        JLabel theCorrectAnswer = new JLabel("The correct answer is...");
        theCorrectAnswer.setBounds(100, 100, 150, 150);
        theCorrectAnswer.setBackground(Color.black);
        theCorrectAnswer.setForeground(Color.WHITE);
        theCorrectAnswer.setFont(new Font("Carlito", Font.PLAIN, 30));
        theCorrectAnswer.setHorizontalAlignment(JLabel.CENTER);
        theCorrectAnswer.setVerticalAlignment(JLabel.CENTER);
        correctAnswerTextPanel.add(theCorrectAnswer);

        JLabel is = new JLabel(question.getCorrectAnswer());
        is.setBounds(400, 100, 150, 150);
        is.setBackground(Color.black);
        is.setForeground(Color.WHITE);
        is.setFont(new Font("Carlito", Font.PLAIN, 30));
        is.setHorizontalAlignment(JLabel.CENTER);
        is.setVerticalAlignment(JLabel.CENTER);
        correctAnswerPanel.add(is);

        JButton next = new JButton("Next Question");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setSize(200, 100);
        next.setFont(new Font("Carlito", Font.PLAIN, 30));
        //Action
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // RoundNumberQuestionNumber();
            }
        });
        nextQuestion.add(next);

        String allScores = null;
        for (Player player : players){
            allScores = allScores + player.getNickname() + ": " + player.getScore() +"\n";
        }

        JLabel scores = new JLabel(allScores);
        scores.setBounds(100, 250, 300, 150);
        scores.setBackground(Color.black);
        scores.setForeground(Color.WHITE);
        scores.setFont(new Font("Carlito", Font.PLAIN, 30));
        scores.setHorizontalAlignment(JLabel.CENTER);
        scores.setVerticalAlignment(JLabel.CENTER);
        scoresPanel.add(scores);

        correctAnswerPanel.setVisible(false);
        nextQuestion.setVisible(false);
        scoresPanel.setVisible(false);

        Timer timer2 = new Timer(2000, e -> {
            scoresPanel.setVisible(true);
            nextQuestion.setVisible(true);
        });
        Timer timer1 = new Timer(5000, e -> {
            correctAnswerPanel.setVisible(true);
            timer2.start();
        });

        timer1.start();

        type.defaultifyPlayers();

//        System.out.println("The correct answer is: ");
//
//        for (int i = 0; i < 3; i++) {
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.print("got interrupted!");
//            }
//
//            System.out.print(". ");
//
//        }
//
//        try {
//            Thread.sleep(1000);
//        } catch(InterruptedException e) {
//            System.out.println("got interrupted!");
//        }
//        //TODO na prasinizei thn swsth apanthsh anti na ektypvnei
//        System.out.print(question.getCorrectAnswer());

    }

    /**
     * whoWon is a void function that is called after each question and it announces who
     * answered correctly and who didn't by checking their status.
     * @value players is the ArrayList that contains all the players that are playing.
     */
    public void whoWon(){

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
    public void showRoundScores(){

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
     */
    public void finalScores(){

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
        }else if(nameOfGame=="StopTheTimer"){
            StopTheTimer timer= new StopTheTimer();
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

    //    /** WE NO LONGER NEED THIS BECAUSE THE BETS WILL BE BUTTONS
//     * newBetPoints is a function that is called when the player types a non acceptable amount to bet.
//     * It informs the user about their mistake and asks for a new bet.
//     * @return the new bet which is an integer.
//     */
//    public int newBetPoints(Player player){
//
//        int betPonits = 0;
//        String points;
//
//        try {
//            Thread.sleep(1000);
//        } catch(InterruptedException e) {
//            System.out.println("got interrupted!");
//        }
//
//        try{
//            System.out.println("\nYou can't bet this amount" + player.getNickname() +", bet again!");
//
//            try {
//                Thread.sleep(1000);
//            } catch(InterruptedException e) {
//                System.out.println("got interrupted!");
//            }
//
//            System.out.println("\nType how many points you bet(250 / 500 / 750 / 1000):");
//            points = input.nextLine();
//            betPonits = Integer.valueOf(points);
//        }catch(NumberFormatException ex){
//            newBetPoints(player);
//        }
//
//        return betPonits;
//
//    }

    // WE DONT NEED THIS ANYMORE
//    /**
//     * This method accepts a Player object, asks the player for an answer and returns the input.
//     * @return String variable that contains the answer.
//     */
//    public String getAnAnswer(Player player){
//
//        try {
//            Thread.sleep(1000);
//        } catch(InterruptedException e) {
//            System.out.println("got interrupted!");
//        }
//
//        System.out.println(player.getNickname() + ", which answer do you think is correct?");
//        return input.nextLine();
//
//    }
//
//    /** WE NO LONGER NEED THIS BECAUSE WE HAVE THE KEYLISTENER
//     * getNewAnswer is called when the player types an answer that does not exist and asks for a new input.
//     * @return String that contains the new answer.
//     */
//    public String getNewAnswer(Player player){
//
//        System.out.println("\n");
//        System.out.println(player.getNickname() + " this is not an option! Guess again.");
//        return input.nextLine();
//
//    }

}
