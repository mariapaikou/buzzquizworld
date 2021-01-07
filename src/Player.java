/**
 * This class represents a player and it stores his nickname,the score and the status.
 */


public class Player {
/**
 * @value nickname is a string parameter that stores the name given by the user
 * @value score is an integer that stores the score of the player, this parameter changes after each question as it adds or subtracts new points
 * @value status is a boolean variable that indicates the state in which the player is at the given moment. When false, the player has not answered
 *               correctly, when true, the player has answered correctly.
 */
    private String nickname;
    private int score;
    private boolean status;//0 if answered correctly, 1 if not
    private int clickTime; // int για να αποθηκευουμε κατευθιαν millisecond!  1 sec = 1000 millisecond!

    public Player(String nickname){
        this.nickname = nickname;
        score = 0;
        status = false;
        clickTime = -1;
    }



    /**
     * Constructor with no given variable for damage control, it initializes the variables.
     */
    public Player(){
        //TODO mhpws prepei na dexetai to onoma san orisma gia na mhn xreiazetai o elegzos sthn set?
        this.nickname="Randall Stephens!";
        score=0;
        status = false;
    }

    public void setNickname(String nickname) {
        if(!nickname.equals("")){
            this.nickname = nickname;
        }

    }
    public String getNickname(){
        return this.nickname;
    }

    //den xreiazetai alla tha to sbhsoyme meta
    /*
    public void setScore(int score){
        if(score == 0){
            this.score=score;
        }

    }
     */

    public int getScore(){
        return this.score;
    }
    public void setStatus(boolean status){ this.status = status; }
    public boolean getStatus(){
        return status;
    }
    public void setClickTime(int time){this.clickTime = time;}
    public int getClickTime(){return clickTime;}


    /**
     * Function increaseScoreBy accepts the
     * @value newPoints, an integer that symbolizes a sum of new points
     * and adds it to the existing counter of the score, a parameter named score.
     */
    public void increaseScoreBy(int newPoints){

            this.score+=newPoints;


    }

    /**
     * initializeScore sets the score to 0.
     */
    public void initializeScore(){
        this.score = 0;
    }

    /**
     * Function defaultfyStatus sets players status to false.
     */
    public void defaultfyStatus(){this.status=false;}


}
