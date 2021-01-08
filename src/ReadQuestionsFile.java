import java.io.*;
import java.util.ArrayList;


public class ReadQuestionsFile {
    private final ArrayList<Questions> questions;


    public ReadQuestionsFile(){
        questions = new ArrayList<>();

    }

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
