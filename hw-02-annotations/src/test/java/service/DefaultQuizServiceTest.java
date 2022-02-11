package service;

import converter.StringListToQuestionConverter;
import dao.FileQuestionDao;
import dao.QuestionDao;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("to refactoring")
class DefaultQuizServiceTest {

    private final QuestionDao questionDao;
    private final QuizService quizService;
    private final QuestionService questionService;

    DefaultQuizServiceTest() {
        PrintService printService = new ConsolePrintService();
        FileDataReader fileDataReader = new CsvFileDataReader();
        StringListToQuestionConverter converter = new StringListToQuestionConverter();
        this.questionDao = new FileQuestionDao(fileDataReader, converter);
        this.questionService = new DefaultQuestionService(questionDao);
        this.quizService = new DefaultQuizService(printService, questionService);
    }

    @Test
    void doQuiz() {
        quizService.doQuiz();
    }
}