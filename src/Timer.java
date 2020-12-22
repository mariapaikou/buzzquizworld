public class Timer extends Type {
    private double[] timeLeft;

    public Timer(){
        super();
        timeLeft = new double[players.size()];
    }

    public void changePoints() {
        for (int i=0; i<players.size(); i++){
            if (players.get(i).getStatus()){
                players.get(i).increaseScoreBy(timeLeft[i] * 0.2);

            }
        }

    }

    public void setTimeLeft(double [] times) {
        this.timeLeft = times;
    }

    public String getName(){return "Timer";}
}

