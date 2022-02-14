package dao;

import converter.StringListToQuestionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import service.FileDataReader;

@Disabled("to refactoring")
class QuestionDaoTest {

    private final QuestionDao questionDao;
    private final FileDataReader fileDataReader;
    private final StringListToQuestionConverter converter;

    QuestionDaoTest(FileDataReader fileDataReader, StringListToQuestionConverter converter) {
        this.fileDataReader = fileDataReader;
        this.converter = converter;
        this.questionDao = new FileQuestionDao(this.fileDataReader, this.converter);
    }

    @Test
    void shouldReadCsvFileAndFillListWithFiveRecords() {
        Assertions.assertEquals(5, questionDao.getAll("").size());
    }
}