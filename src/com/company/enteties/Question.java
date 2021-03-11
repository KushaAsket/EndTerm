package com.company.enteties;

/**
 * @author Kuanyshbek
 */

public class Question {
    private int id;
    private String question;
    private String answer;
    private String type;

    public Question() {
    }

    public Question(String question, String answer, String type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    public Question(int id, String question, String answer, String type) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + ". " + question + "\n" +
                "Answer: " + answer + "    Type: " + type + "\n";
    }
}
