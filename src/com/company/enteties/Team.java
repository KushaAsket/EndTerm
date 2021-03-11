package com.company.enteties;

import java.util.Arrays;

/**
 * @author Kuanyshbek
 */

public class Team {
    private int id;
    private String name;
    private String[] participants;
    int score;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(int id, String name, int score ) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Team(String name, String[] participants, int score) {
        this.name = name;
        this.participants = participants;
        this.score = score;
    }

    public Team(int id, String name, String[] participants, int score) {
        this.id = id;
        this.name = name;
        this.participants = participants;
        this.score = score;
    }

    public Team(String team_name, int score) {
        this.score = score;
        name = team_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoints() {
        score++;
    }

    @Override
    public String toString() {
        return name + "\n" + Arrays.toString(participants) + "\n" + "Team score: " + score;
    }
}
