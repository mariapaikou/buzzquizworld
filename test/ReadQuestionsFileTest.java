import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReadQuestionsFileTest {

    @Test
    void loadQuestions() {
        ArrayList<Questions> questions;
        ReadQuestionsFile readQuestionsFile = new ReadQuestionsFile();
        questions =readQuestionsFile.loadQuestions("test.txt");
        int[] i = new int[4];
        i[0] = 0;
        i[1] = 0;
        i[2] = 0;
        i[3] = 0;

        ArrayList<String> answers = questions.get(0).getAnswers();

        for(String an : answers){
            if(an.equals("Makaroni")){
                i[0] = 1;
            }else if(an.equals("Zeledakia")){
                i[1] = 1;
            }else if(an.equals("Mouuuzaka")){
                i[2] = 1;
            }else if(an.equals("Kafesssss!")){
                i[3] = 1;
            }
        }

        assertEquals(1,i[0]);
        assertEquals(1,i[1]);
        assertEquals(1,i[2]);
        assertEquals(1,i[3]);
    }
}