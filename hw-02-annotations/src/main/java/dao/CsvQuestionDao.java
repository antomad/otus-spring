package dao;

import converter.StringListToQuestionConverter;
import domain.Question;
import service.FileDataReader;

import java.util.List;
import java.util.stream.Collectors;

public class CsvQuestionDao implements QuestionDao {

    private final FileDataReader fileDataReader;
    private final StringListToQuestionConverter converter;

    public CsvQuestionDao(FileDataReader fileDataReader,
                          StringListToQuestionConverter converter) {
        this.fileDataReader = fileDataReader;
        this.converter = converter;
    }

    @Override
    public List<Question> getAll(String fileName) {
        return fileDataReader.readStrings(fileName)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}