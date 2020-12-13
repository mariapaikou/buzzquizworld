import org.junit.jupiter.api.Test;

class PlayerTest {
    private final Player player;

    public PlayerTest(){
        player = new Player();
    }

    @Test //ok!
    void setNickname() {
        String nickname = "";
        player.setNickname(nickname);

        if(! (player.getNickname().equals(nickname) )){
            System.out.println("all well in first if of setNickname!");
        }else{
            System.out.println("problem in first if of setNickname");
        }

        nickname = "kalhmaera!";
        player.setNickname(nickname);

        if(player.getNickname().equals(nickname)){
            System.out.println("all well in second if of setNickname!");
        }else{
            System.out.println("problem in second if of setNickname!");
        }
    }

    @Test //ok!
    void getNickname() {

        String nickname = "someone";
        player.setNickname(nickname);

        if(player.getNickname().equals(nickname)){
            System.out.println("all well in first if of getNickname!");
        }else{
            System.out.println("problem in first if of getNickname!");
        }
    }

    @Test // ok!
    void setScore() {

        int score = -1000;
        player.setScore(score);

        if(! (player.getScore() == score)){
            System.out.println("all well in first if of setScore!");
        }else{
            System.out.println("problem in first if of setScore!");
        }
    }

    @Test //ok!
    void getScore() {

        if(player.getScore() == 0){
            System.out.println("all well in first if of getScore!");
        }else{
            System.out.println("problem in first if of getScore!");
        }

        int score = 1000;
        player.setScore(score);

        if(player.getScore() == score){
            System.out.println("all well in second if of getScore!");
        }else{
            System.out.println("problem in second if of getScore!");
        }
    }

    @Test //ok!
    void setStatus() {

        player.setStatus(true);

        if(player.getStatus()){
            System.out.println("all well in first if of setStatus!");
        }else{
            System.out.println("problem in first if of setStatus!");
        }

        player.setStatus(false);

        if(!player.getStatus()){
            System.out.println("all well in second if of setStatus");
        }else{
            System.out.println("problem in second if of setStatus");
        }
    }

    @Test //ok!
    void getStatus() {

        if(!player.getStatus()){
            System.out.println("all well in first if of getStatus!");
        }else{
            System.out.println("problem in first if of getStatus!");
        }
    }

    @Test //ok!
    void increaseScoreBy() {

        int score = -600;
        player.increaseScoreBy(score);

        if(! (player.getScore() == score)){
            System.out.println("all well in first if of increaseScoreBy!");
        }else{
            System.out.println("problem in first if of increaseScoreBy");
        }
    }

    @Test //ok!
    void initializeScore() {

        int score = 600;
        player.increaseScoreBy(score);
        player.initializeScore();

        if(player.getScore() == 0){
            System.out.println("all well in first if of initializeScore!");
        }else{
            System.out.println("problem in first if of initializeScore!");
        }

    }

    @Test //ok!
    void defaultfyStatus() {

        player.setStatus(true);
        player.defaultfyStatus();

        if(!player.getStatus()){
            System.out.println("all well in first if of defaultfyStatus!");
        }else{
            System.out.println("problem in first if of defaultfyStatus");
        }
    }
}