package dao;

import domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvQuestionDao implements QuestionDao {

    @Override
    public List<Question> getAll() {
        List<Question> questions = null;
        try (InputStream inputStream = getClass().getResourceAsStream("/questions.csv")) {
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                questions = mapListOfStringsToQuestions(readCsvFileToArray(reader));
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file");
        }
        return questions;
    }

    private List<List<String>> readCsvFileToArray(BufferedReader reader) {
        List<List<String>> records = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file");
        }
        return records;
    }

    private List<Question> mapListOfStringsToQuestions(List<List<String>> list) {
        return list.stream().map(values -> new Question(
                        values.get(1),
                        values.get(2),
                        List.of(values.get(3), values.get(4), values.get(5))))
                .collect(Collectors.toList());
    }
}
