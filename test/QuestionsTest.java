import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class QuestionsTest {
    Questions question;
    ArrayList<String> answers;
    public QuestionsTest(){
        question = new Questions("Category","Question","AnswerA","AnswerB","AnswerC","AnswerD", "CorrectAnswer", "null");
        answers = new ArrayList<>();
    }

    @Test
    void getAnswers() {
        answers = question.getAnswers();
        assertNotSame(answers.get(0), question.getAnswers().get(0));
    }
}
