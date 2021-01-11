public class Timer extends Type {

    public Timer(){
        super();
       // timeLeft = new int[players.size()]; // xreiazetai???
    }

    public void changePoints() {

        for (Player player : players) {

            if (player.getStatus()) {

                int timeLeft = player.getClickTime();
                if (timeLeft != -1) {
                    player.increaseScoreBy((int) (timeLeft * 0.2));
                }

            }
        }
        defaultfyPlayers();

    }

   // public void setTimeLeft(int[] times) {
   //     this.timeLeft = times;
  //  } //xreiazetai???


    public String getName(){return "Timer";}

    public String getExplanation(){
        String explanation = "There is a timer that counts down 5 seconds and each player who answers correctly earns as many points as the milliseconds left when he answered multiplied by 0.2.";
        return explanation;
    }
}

