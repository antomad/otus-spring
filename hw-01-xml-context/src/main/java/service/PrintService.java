package service;

import domain.Question;

import java.util.List;

public interface PrintService {
    void printQuestionAndAnswerWithVariants(List<Question> questions);
}
