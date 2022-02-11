package service;

import converter.StringListToQuestionConverter;
import dao.FileQuestionDao;
import dao.QuestionDao;
import domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

@Disabled("to refactoring")
class PrintServiceTest {

    private final PrintService printService;
    private final QuestionDao questionDao;
    private final FileDataReader fileDataReader;
    private final StringListToQuestionConverter converter;

    PrintServiceTest(FileDataReader fileDataReader, StringListToQuestionConverter converter) {
        this.fileDataReader = fileDataReader;
        this.converter = converter;
        this.printService = new ConsolePrintService();
        this.questionDao = new FileQuestionDao(this.fileDataReader, this.converter);
    }

    @Test
    void getQuestionsAndPrintQuestionAndAnswerWithVariants() {
        List<Question> questions = questionDao.getAll("");
        Assertions.assertNotNull(questions);
        printService.printQuestionAndAnswerWithVariants(questions);
    }

    @Test
    void shouldPrintCorrectMessage() {
        questionDao.getAll("").forEach(printService::printQuestionAndVariants);
    }
}