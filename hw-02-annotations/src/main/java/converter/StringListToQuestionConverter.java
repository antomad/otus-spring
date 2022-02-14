package converter;

import domain.Question;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class StringListToQuestionConverter implements Converter<List<String>, Question> {

    @Override
    public Question convert(List<String> source) {
        return new Question(
                source.get(1),
                source.get(2),
                List.of(source.get(3), source.get(4), source.get(5)));
    }
}