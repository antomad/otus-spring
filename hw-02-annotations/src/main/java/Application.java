import configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.QuestionService;
import service.QuizService;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        QuestionService questionService = context.getBean(QuestionService.class);
        QuizService quizService = context.getBean(QuizService.class);

        quizService.doQuiz(questionService.getQuestions());
    }
}
