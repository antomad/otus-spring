package service;

import domain.Question;

import java.util.List;

public interface PrintService {
    void printQuestionAndAnswerWithVariants(List<Question> questions);

    void printQuestionAndVariants(Question question);

    void printCongratulation(String surname, String name, boolean winner);
}
