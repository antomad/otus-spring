package service;

import domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DefaultQuizService implements QuizService {

    private final List<Integer> variants = List.of(1, 2, 3);

    @Value("${minimal.rate}")
    private Integer rate;

    private final PrintService printService;

    public DefaultQuizService(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public void doQuiz(List<Question> questions) {

        String surname;
        String name;
        int success = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your surname: ");
        surname = in.nextLine();
        System.out.println("Please enter your name: ");
        name = in.nextLine();

        for (Question question : questions) {
            printService.printQuestionAndVariants(question);
            int input;
            do {
                input = in.nextInt();
            } while (!checkInput(input));

            if (question.getAnswer().equals(question.getVariants().get(input - 1))) {
                success++;
            }
        }
        in.close();

        printService.printCongratulation(surname, name, success >= rate);
    }

    private boolean checkInput(Integer integer) {
        return variants.contains(integer);
    }
}
