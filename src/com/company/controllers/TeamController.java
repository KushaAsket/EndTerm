package com.company.controllers;

import com.company.database.interfaces.IDB;
import com.company.enteties.Player;
import com.company.enteties.Team;
import com.company.repositories.TeamRepository;
import com.company.repositories.interfaces.ITeamRepository;

import java.util.List;

public class TeamController {
    private final ITeamRepository teamRepository;

    public TeamController(ITeamRepository teamRepository) {
        this.teamRepository =  teamRepository;
    }

    public void registerTeam(String team_name) {
        if (!team_name.isEmpty()) {
            Team team = new Team(team_name, 0);

            teamRepository.registerTeam(team);

            System.out.println("Successfully registered!" + "\n" + teamRepository.getId() + ". " +team.getName());
        }
    }

    public Team getTeam(int id) {
        Team team = teamRepository.getTeam(id);

        return team;
    }

    public String addPoint(int id, int score) {
        boolean isAdded = teamRepository.addPoint(id, score);

        return (isAdded ? "Point was not added" : "Point was added");
    }

    public int getId() {
        int id = teamRepository.getId();

        return id;
    }

    public void getScoreboard() {
        List<Team> teams = teamRepository.getScoreboard();

        for (int i = 0; i < teams.size(); i++) {
            String name = teams.get(i).getName();
            int score = teams.get(i).getScore();
            System.out.println(i + ". " + name + " score: " + score);
        }
    }
}
