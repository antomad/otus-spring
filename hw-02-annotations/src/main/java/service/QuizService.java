package service;

import domain.Question;

import java.util.List;

public interface QuizService {

    void doQuiz(List<Question> questions);
}
