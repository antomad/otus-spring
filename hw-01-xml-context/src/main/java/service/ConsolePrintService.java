package service;

import domain.Question;

import java.util.List;

public class ConsolePrintService implements PrintService {

    @Override
    public void printQuestionAndAnswerWithVariants(List<Question> questions) {
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answer: " + question.getAnswer());
            System.out.println("Variants: " + String.join(", ", question.getVariants()));
        }
    }
}
