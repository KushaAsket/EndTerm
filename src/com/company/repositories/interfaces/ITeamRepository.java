package com.company.repositories.interfaces;

import com.company.enteties.Player;
import com.company.enteties.Team;

import java.util.List;

/**
 * @author Kuanyshbek
 */

public interface ITeamRepository {
    boolean registerTeam(Team team);

    Team getTeam(int id);

    boolean addPoint(int id, int score);

    int getId();

    List<Team> getScoreboard();
}
