package configuration;

import dao.CsvQuestionDao;
import dao.QuestionDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import service.*;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    QuestionDao questionDao() {
        return new CsvQuestionDao();
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
    QuizService quizService() {
        return new DefaultQuizService(printService());
    }
}
