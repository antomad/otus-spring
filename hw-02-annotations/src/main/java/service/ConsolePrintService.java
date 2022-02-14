package service;

import domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsolePrintService implements PrintService {

    @Override
    public void printQuestionAndAnswerWithVariants(List<Question> questions) {
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Answer: " + question.getAnswer());
            System.out.println("Variants: " + String.join(", ", question.getVariants()));
        }
    }

    @Override
    public void printQuestionAndVariants(Question question) {
        System.out.println();
        System.out.println("Question is: " + question.getQuestion());
        System.out.println("Please choose one of variant below by enter number: ");
        List<String> variants = question.getVariants();
        for (int i = 1; i <= variants.size(); i++) {
            System.out.print(i + " - " + variants.get(i - 1));
            if (i != variants.size()) {
                System.out.print(" | ");
            } else {
                System.out.println();
            }
        }
    }

    @Override
    public void printCongratulation(String surname, String name, boolean winner) {
        System.out.print(name + " " + surname + " congratulations! You are ");
        if (winner) {
            System.out.print("winner!\n");
        } else {
            System.out.print("looser!\n");
        }
    }
}