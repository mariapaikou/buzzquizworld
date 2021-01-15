import java.io.*;
import java.util.ArrayList;

/**
 * ReadQuestionsFile class reads a file that contains the questions data (category, question , the four answers, the
 * correct answer, and the image name) and stores this information inside a new Question object.
 */
public class ReadQuestionsFile {
    private final ArrayList<Questions> questions;

    /**
     * Constructor
     */
    public ReadQuestionsFile(){
        questions = new ArrayList<>();

    }

    /**
     * Method loadQuestions accepts a string that represents the file name and reads the data that file has. At the same
     * time stores this data inside new Questions objects and returns an ArrayList that contains all the questions
     * red from file
     * @param file String
     * @return ArrayList<Questions>
     */
    public ArrayList<Questions> loadQuestions(String file){

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while((line = br.readLine()) != null){
                String[] separated = line.split("@",8);
                String category = separated[0];
                String question = separated[1];
                String answerA = separated[2];
                String answerB = separated[3];
                String answerC = separated[4];
                String answerD = separated[5];
                String correctAnswer = separated[6];
                String image = separated[7];
                Questions q = new Questions(category, question, answerA, answerB, answerC, answerD, correctAnswer, image);
                questions.add(q);

            }

        }catch (IOException e){
           e.printStackTrace();
       }

        return questions;
    }
}
