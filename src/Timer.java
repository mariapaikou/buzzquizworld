public class Timer extends Type {
    private int[] timeLeft;

    public Timer(){
        super();
        timeLeft = new int[players.size()];
    }

    public void changePoints() {

        for (int i=0; i<players.size(); i++){

            if (players.get(i).getStatus()){

                players.get(i).increaseScoreBy((int)(timeLeft[i] * 0.2));

            }
        }

    }

    public void setTimeLeft(int[] times) {
        this.timeLeft = times;
    }

    public String getName(){return "Timer";}
}

