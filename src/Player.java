/**
 * This class represents a player and it stores his name and total score.
 */


public class Player {
/**
 * @param nickname is a string parameter that stores the name given by the user
 * @param score is an integer that stores the score of the player, this parameter changes after each question as it adds or subtracts new points
 * @param status is a boolean variable that indicates the state in which the player is at the given moment. When false, the player has not answered
 *               correctly, when true, the player has answered correctly.
 */
    String nickname;
    int score;
    boolean status;//0 if answered correctly, 1 if not


    public Player(String nickname){
        this.nickname = nickname;
        score = 0;
        status = false;
    }

    /**
     * Constructor with no given variable for damage control
     */
    public Player(){
        this.nickname="phantomMan, he doesn't exist";
        score=0;
        status = false;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void setStatus(boolean status){
        if(status == true || status == false){
            this.status=status;
        }else{
            System.out.println("wrong!!");/////error class???????
        }

    }


    public String getNickname(){
        return this.nickname;
    }

    public int getScore(){
        return this.score;
    }

    public boolean getStatus(){
        return status;
    }

    /**
     * Function increaseScoreBy accepts the
     * @param newPoints, an integer that symbolizes a sum of new points
     * and adds it to the existing counter of the score, a parameter named score.
     */
    public void increaseScoreBy(int newPoints){
        this.score+=newPoints;
    }


}
