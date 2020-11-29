/**
 * This class represents a player and it stores his name and total score.
 */


public class Player {
    String nickname;
    int score;
    int status;//0 if answered correctly, 1 if not

    public Player(String nickname){
        this.nickname = nickname;
        score = 0;
        status = 0;
    }

    public Player(){
        this.nickname="phantomMan, he doesn't exist";
        score=0;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScore(int score){
        this.score=score;
    }

    public void setStatus(int status){
        if(status == 1 || status == 0){
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

    public int getStatus(){
        return status;
    }

    public void increaseScoreBy(int newPoints){
        this.score+=newPoints;
    }


}
