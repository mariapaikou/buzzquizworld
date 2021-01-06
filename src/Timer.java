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
}

