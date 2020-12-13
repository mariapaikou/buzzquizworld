import java.util.Random;
/**
 * Class Round symbolizes a round of the game, which consists of a number of questions. It selects a type of game
 * for the round.
 */
public class Round {

    Random random;

    public Round() {
        random = new Random();
    }

    /**
     * Function getRandomType selects the type of game for the next round. Uses Random class to get randomly
     * 0 for RightAnswer and 1 for Bet.
     * Creates a Type object.
     * @return Type object that contains the type chosen.
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
/*
    /**
     * Function getRandomQuestion, accepts the ArrayList the contains all the questions and the ArrayList that
     * will hold the random questions selected for the round. It chooses a random number, checks if that question has been used before
     * and if not it adds it to the randomQuestions ArrayList.
     *
//prospa8hsa na thn kanw na epistrefei Questions alla meta eksw apo thn if den eixe return statement
//prospa8hsa na thn kanw boolean alla den mou bghke
//den kserw an xreiazetai h used telika giati apla afairw to antikeimeno apo thn lista alla gia twra thn afhnw
public void getRandomQuestion(ArrayList<Questions> allQuestions, ArrayList<Questions> randomQuestions){
    System.out.println("inside getrandomquestrion!!!!!!!!!!!!!!!!!!!!!!!!");
    int r = random.nextInt(allQuestions.size());
    System.out.println("R now is"+r+"!!!!!!!!!!!!");
    // System.out.println("r is "+ r +"!!!!!!!!!!!!!!!!!!!!!!!!!!");
    if (allQuestions.get(r).getUsed() == false) {
        randomQuestions.add(allQuestions.get(r));
        allQuestions.get(r).setUsed(true);
    }
    else if (allQuestions.get(r).getUsed() == true) {
        getRandomQuestion(allQuestions, randomQuestions);
    }
    else {
        System.out.println("Error, no available questions left.");
    }
} //thn etrexa kai den paizei :'( alla thn krataw giati einai kalo to skeptiko apla prepei na to koitakseis ki esu
    //nomizw to thema ths einai to used

 */




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
