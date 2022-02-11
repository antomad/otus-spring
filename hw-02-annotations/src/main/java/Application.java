import configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.QuizService;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.getBean(QuizService.class).doQuiz();
    }
}