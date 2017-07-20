package android.fu.flashcard;

import java.io.Serializable;

/**
 * Created by Samuel on 4/21/2016.
 */
public class FlashCard implements Serializable {
    private int Id;
    private String Title;
    private String Question;
    private String Answer;

    public FlashCard(String answer, String question, String title, int id) {
        Answer = answer;
        Question = question;
        Title = title;
        Id = id;
    }

    @Override
    public String toString() {
        return Title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
