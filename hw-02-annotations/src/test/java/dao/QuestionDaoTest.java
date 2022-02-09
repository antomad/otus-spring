package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuestionDaoTest {

    private final QuestionDao questionDao;

    QuestionDaoTest() {
        this.questionDao = new CsvQuestionDao();
    }

    @Test
    void shouldReadCsvFileAndFillListWithFiveRecords() {
        Assertions.assertEquals(5, questionDao.getAll().size());
    }
}