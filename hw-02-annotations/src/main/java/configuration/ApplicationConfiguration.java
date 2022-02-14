package configuration;

import converter.StringListToQuestionConverter;
import dao.FileQuestionDao;
import dao.QuestionDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import service.*;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    FileDataReader fileDataReader() {
        return new CsvFileDataReader();
    }

    @Bean
    StringListToQuestionConverter stringListToQuestionConverter() {
        return new StringListToQuestionConverter();
    }

    @Bean
    QuestionDao questionDao(FileDataReader fileDataReader,
                            StringListToQuestionConverter stringListToQuestionConverter) {
        return new FileQuestionDao(fileDataReader, stringListToQuestionConverter);
    }

    @Bean
    QuestionService questionService(QuestionDao questionDao) {
        return new DefaultQuestionService(questionDao);
    }

    @Bean
    PrintService printService() {
        return new ConsolePrintService();
    }

    @Bean
    QuizService quizService(QuestionService questionService) {
        return new DefaultQuizService(printService(), questionService);
    }
}
