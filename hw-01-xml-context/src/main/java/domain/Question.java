package domain;

import java.util.List;

public class Question {
    private final String question;
    private final String answer;
    private final List<String> variants;

    public Question(String question, String answer, List<String> variants) {
        this.question = question;
        this.answer = answer;
        this.variants = variants;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getVariants() {
        return variants;
    }
}
