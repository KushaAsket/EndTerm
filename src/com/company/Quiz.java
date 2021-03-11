package com.company;

import com.company.controllers.PlayerController;
import com.company.controllers.QuestionController;
import com.company.controllers.QuizController;
import com.company.controllers.TeamController;
import com.company.enteties.Player;
import com.company.enteties.Question;
import com.company.enteties.Team;
import com.company.repositories.interfaces.IPlayerRepository;
import com.company.repositories.interfaces.IQuestionRepository;
import com.company.repositories.interfaces.ITeamRepository;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Darkhan and Kuanyshbek
 */

public class Quiz {
    private final Scanner scanner;
    private final QuestionController questionController;
    private final QuizController quizController;
    private final PlayerController playerController;
    private final TeamController teamController;

    public Quiz(IQuestionRepository questionRepository, IPlayerRepository playerRepository, ITeamRepository teamRepository) {
        scanner = new Scanner(System.in);
        questionController = new QuestionController(questionRepository);
        quizController = new QuizController(questionRepository);
        playerController = new PlayerController(playerRepository);
        teamController = new TeamController(teamRepository);
    }

    public void quizStart(int id) {
        int i = 1;
        while (true) {
            if (questionController.getQuestion(i) == null) {
                break;
            }

            Question question = questionController.getQuestion(i);
            System.out.println(question.getQuestion());

            Player player = playerController.getPlayer(id);
            System.out.print("Your answer: ");

            String answer = scanner.next();

            if (answer.equals("exit")) {
                break;
            }

            if (quizController.checkAnswer(answer, question.getId())) {
                player.addPoints();
                playerController.addPoint(player.getId(), player.getScore());
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer");
            }

            System.out.println("Your score: " + player.getScore());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Enter exit if you want to exit!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            i++;
        }

        System.out.println("Thank you for the game!");
    }

    public void teamQuiz(int[] ids) {
        int i = 1;
        int j = 0;
        int num=1;
        List<Team> teams = new ArrayList<Team>();
        for(int k=0;k<4;k++){
            Team team = teamController.getTeam(ids[k]);
            teams.add(team);
        }
        while (true) {
            if (questionController.getQuestion(i) == null) {
                break;
            }

            if (j == 4) {
                j = 0;
            }

            if (num == 5) {
                num = 1;
            }

            if (i == 7) {
                i++;
            }

            System.out.println("Question for team " + j);

            Question question = questionController.getQuestion(i);
            System.out.println(question.getQuestion());

            String answer = scanner.next();

            if (answer.equals("exit")) {
                break;
            }

            if (quizController.checkAnswer(answer, question.getId())) {
                teams.get(j).addPoints();
                teamController.addPoint(teams.get(j).getId(), teams.get(j).getScore());
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer");
            }

            System.out.println("Team " + num + " score: " + teams.get(j).getScore());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Enter exit if you want to exit!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            i++;
            j++;
        }
    }
}
