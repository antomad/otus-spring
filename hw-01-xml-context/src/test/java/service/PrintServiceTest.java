package service;

import dao.CsvQuestionDao;
import dao.QuestionDao;
import domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrintServiceTest {

    private final PrintService printService;
    private final QuestionDao questionDao;

    PrintServiceTest() {
        this.printService = new ConsolePrintService();
        this.questionDao = new CsvQuestionDao();
    }

    @Test
    void getQuesionsAndprintQuestionAndAnswerWithVariants() {
        List<Question> questions = questionDao.getAll();
        Assertions.assertNotNull(questions);
        printService.printQuestionAndAnswerWithVariants(questions);
    }
}