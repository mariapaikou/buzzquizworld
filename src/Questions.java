import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a question that will be used in the game, it has four possible answers
 * from which one is correct and belongs to a category.
 */

public class Questions {

    private final String question;
    private final String correctAnswer;
    private final String category;
    private final ArrayList<String> answers;
    private final String image;

    /**
     * When the object is created, it needs to have the following information.
     * @param category the category of the question.
     * @param question the question.
     * @param answerA possible answer.
     * @param answerB different possible answer.
     * @param answerC different possible answer.
     * @param answerD different possible answer.
     * @param correctAnswer the correct answer out of the four possible.
     * @param image the name of the image that accompanies the question if not null.
     */
    public Questions(String category, String question, String answerA, String answerB, String answerC, String answerD, String correctAnswer, String image) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.image = image;
        answers = new ArrayList<>();
        answers.add(answerA);
        answers.add(answerB);
        answers.add(answerC);
        answers.add(answerD);
    }

    public String getQuestion(){ return question; }
    public String getCorrectAnswer(){ return correctAnswer; }
    public String getCategory(){ return category;}
    public String getImageName(){ return image; }

    /**
     * @return an arrayList with the four possible answers in a random order.
     */
    public ArrayList<String> getAnswers(){

        Collections.shuffle(answers);
        return answers;

    }
}
