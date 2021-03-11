package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.enteties.Player;
import com.company.enteties.Team;
import com.company.repositories.interfaces.ITeamRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Darkhan
 */

public class TeamRepository implements ITeamRepository {
    private final IDB db;

    public TeamRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean registerTeam(Team team) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO team_game(team, score) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, team.getName());
            st.setInt(2, team.getScore());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Team getTeam(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,team,score FROM team_game WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Team team = new Team(rs.getInt("id"),
                        rs.getString("team"),
                        rs.getInt("score"));

                return team;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public boolean addPoint(int id, int score) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE team_game SET score = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, score);
            st.setInt(2, id);

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public int getId() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM team_game where id >= ((SELECT MAX (id) FROM team_game)-4)";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int id = (rs.getInt("id"));

                return id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<Team> getScoreboard() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,team,score FROM team_game ORDER BY score DESC";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Team> teams = new ArrayList<>();
            while (rs.next()) {
                Team team = new Team(rs.getInt("id"),
                        rs.getString("team"),
                        rs.getInt("score"));
                teams.add(team);
            }

            return teams;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
