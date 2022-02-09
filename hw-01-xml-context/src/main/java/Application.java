import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PrintService;
import service.QuestionService;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService service = context.getBean(QuestionService.class);
        PrintService printer = context.getBean(PrintService.class);

        printer.printQuestionAndAnswerWithVariants(service.getQuestions());
    }
}
