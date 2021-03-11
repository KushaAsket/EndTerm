package com.company.admin;

import com.company.controllers.QuestionController;
import com.company.enteties.Question;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.Scanner;

/**
 * @author Darkhan
 */

public class Admin {
    private final QuestionController controller;
    private final Scanner scanner;

    public Admin(IQuestionRepository questionRepository) {
        controller = new QuestionController(questionRepository);
        scanner = new Scanner(System.in);
    }

    public boolean checkPassword(String password) {
        String code = controller.getQuestion(7).getType();
        if (password.equals(code)) {
            return true;
        } else {
            return false;
        }
    }

    public void adminControl() {
        while (true) {
            System.out.println();
            System.out.println("Successfully get the admin tool!");
            System.out.println("Manage the database");
            System.out.println("Select option:");
            System.out.println("1. Add new question in database");
            System.out.println("2. Get question by id");
            System.out.println("3. Get list of all questions");
            System.out.println("0. Exit");

            try {
                System.out.print("Enter option (0-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    createQuestionMenu();
                } else if (option == 2) {
                    getQuestionByIdMenu();
                } else if (option == 3) {
                    getAllQuestionsMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
    }

    public void createQuestionMenu() {
        System.out.print("Enter the question: ");
        String skipInput = scanner.nextLine();
        String question;
        question = scanner.nextLine();

        System.out.print("Enter the answer: ");
        String answer;
        answer = scanner.nextLine();

        System.out.print("Enter the type: ");
        String type;
        type = scanner.nextLine();


        String response = controller.createQuestion(question, answer, type);
        System.out.println(response);
    }

    public void getQuestionByIdMenu() {
        System.out.println("Enter the id:");
        int id = scanner.nextInt();
        Question question = controller.getQuestion(id);
        System.out.println((question == null ? "Question was not found!" : question.toString()));
    }

    public void getAllQuestionsMenu() {
        String response = controller.getAllQuestions();
        System.out.println(response);
    }
}
