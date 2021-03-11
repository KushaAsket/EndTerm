package com.company.enteties;

/**
 * @author Kuanyshbek
 */

public class Player {
    private int id;
    private String username;
    private int score;

    public Player() {
    }

    public Player(String username) {
        this.username = username;
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public Player(int id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void addPoints() {
        score++;
    }

    @Override
    public String toString() {
        return id + ". " + username + " Your score: " + score;
    }
}
