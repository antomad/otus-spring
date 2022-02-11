package service;

import dao.CsvQuestionDao;
import dao.QuestionDao;
import org.junit.jupiter.api.Test;

class DefaultQuizServiceTest {

    private final QuestionDao questionDao;
    private final QuizService quizService;
    private final QuestionService questionService;

    DefaultQuizServiceTest() {
        PrintService printService = new ConsolePrintService();
        this.questionDao = new CsvQuestionDao();
        this.questionService = new DefaultQuestionService(questionDao);
        this.quizService = new DefaultQuizService(printService, questionService);
    }

    @Test
    void doQuiz() {
        quizService.doQuiz();
    }
}