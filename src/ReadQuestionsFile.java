import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadQuestionsFile {
    private ArrayList<Questions> questions;
    private String category;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private String image;

    public ReadQuestionsFile(){
        questions = new ArrayList<>();

    }

    public ArrayList<Questions> loadQuestions(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = "";
            String[] separated;
            while((line = br.readLine()) != null){
                separated = line.split("    ");
                category = separated[0];
                question = separated[1];
                answerA = separated[2];
                answerB = separated[3];
                answerC = separated[4];
                answerD = separated[5];
                correctAnswer = separated[6];
                image = separated[7];
                Questions q = new Questions(category, question, answerA, answerB, answerC, answerD, correctAnswer, image);
                questions.add(q);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return questions;
    }
}
