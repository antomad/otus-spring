package service;

import dao.CsvQuestionDao;
import dao.QuestionDao;
import domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DefaultQuizServiceTest {

    private final QuestionDao questionDao;
    private final QuizService quizService;

    DefaultQuizServiceTest() {
        PrintService printService = new ConsolePrintService();
        this.questionDao = new CsvQuestionDao();
        this.quizService = new DefaultQuizService(printService);
    }

    @Test
    void doQuiz() {
        quizService.doQuiz(questionDao.getAll());
    }
}