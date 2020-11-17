public class Player {
    String nickname;
    int score;

    private Player(String nickname){
        this.nickname=nickname;
        score=0;
    }

    private Player(){
        this.nickname="phantomMan, he doesn't exist";
        score=0;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScore(int score){
        this.score=score;
    }

    public String getNickname(){
        return this.nickname;
    }

    public int getScore(){
        return this.score;
    }


}
