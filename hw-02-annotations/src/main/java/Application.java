import configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.QuizService;

public class Application {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ApplicationConfiguration.class)
                .getBean(QuizService.class)
                .doQuiz();
    }
}