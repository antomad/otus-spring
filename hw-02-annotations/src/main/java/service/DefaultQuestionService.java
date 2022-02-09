package service;

import dao.QuestionDao;
import domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DefaultQuestionService implements QuestionService {

    private final QuestionDao questionDao;

    public DefaultQuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        return Objects.requireNonNull(questionDao.getAll());
    }
}