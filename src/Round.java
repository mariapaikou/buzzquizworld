import java.util.ArrayList;
import java.util.Random;
/**
 * Class Round symbolizes a round of the game, which consists of 3 questions. It selects a type of game
 * for the round and the randomized questions.
 */
public class Round {
    //private static int numberOfQuestions = 3;
    private static int numberOfQuestions = 1;
    Random random;

    public Round() {
        random = new Random();
    }

    /**
     * Function getRandomType selects the type of game of the next round. Uses  Random class to get randomly
     * 0 for RightAnswer and 1 for Bet.
     * Creates a Type object.
     * @return Type
     */
    public Type getRandomType() {
        Type type;
        int r = random.nextInt(2);
        if(r == 1){
            type = new RightAnswer();
        }else{
            type = new Bet();
        }
        return type;
    }

    /**
     *
     * @return
     */
    //prospa8hsa na thn kanw na epistrefei Questions alla meta eksw apo thn if den eixe return statement
    //prospa8hsa na thn kanw boolean alla den mou bghke
    //den kserw an xreiazetai h used telika giati apla afairw to antikeimeno apo thn lista alla gia twra thn afhnw
    public void getRandomQuestion(ArrayList<Questions> allQuestions, ArrayList<Questions> randomQuestions){
        int r = random.nextInt(allQuestions.size());
        if (allQuestions.get(r).getUsed() == false) {
            randomQuestions.add(allQuestions.get(r));
            allQuestions.get(r).setUsed(true);
            allQuestions.remove(allQuestions.get(r));
        }
        else if (allQuestions.get(r).getUsed() == true && allQuestions.size()>0) {
            getRandomQuestion(allQuestions, randomQuestions);
        }
        else {
            System.out.println("Error, no available questions left.");
        }
    }




    /*
      if(type instanceof RightAnswer){
        //tha prepei na gurisei lista me tous paiktes kai na allazei to status twn nikhtwn
    }
        else if(type instanceof Bet){
        //tha prepei na rwtaei mesw ths UserInteractions to stoixhma, auto tha apothhkeuetai sthn bet
        //kai meta tha allazei to status twn nikhtwn kai tha epistrefei th lista me tous paiktes
    }
        for(int i = 0; i < numberOfQuestions; i++){

    }
    // questions.keySet() RandomQuestions[i] asto ligo etsi tha to dw aurio
    */

}
