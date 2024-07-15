package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Entity.Scout;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoutDao {
    private final DataSource dataSource;

    public ScoutDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Scout scout) {
        String sql = "INSERT INTO scout (team_id, game_id, person_id, goals, assists, yellow_card, red_card) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setLong(1, scout.getTeamId());
            st.setLong(2, scout.getGameId());
            st.setLong(3, scout.getPlayerId());
            st.setInt(4, scout.getGoals());
            st.setInt(5, scout.getAssists());
            st.setInt(6, scout.getYellowCard());
            st.setInt(7, scout.getRedCard());

            st.executeUpdate();

            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    scout.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Scout findById(Long id) {
        String sql = "SELECT * FROM scout WHERE id = ?";
        Scout scout = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    scout = mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scout;
    }

    public List<Scout> findAll() {
        String sql = "SELECT * FROM scout";
        List<Scout> scouts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                scouts.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scouts;
    }

    public List<Scout> findByGameId(Long gameId) {
        String sql = "SELECT * FROM scout WHERE game_id = ?";
        List<Scout> scouts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, gameId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    scouts.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scouts;
    }

    public List<Scout> findByPlayerId(Long playerId) {
        String sql = "SELECT * FROM scout WHERE person_id = ?";
        List<Scout> scouts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, playerId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    scouts.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scouts;
    }

    public List<Scout> findByTeamId(Long teamId) {
        String sql = "SELECT * FROM scout WHERE team_id = ?";
        List<Scout> scouts = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, teamId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    scouts.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scouts;
    }

    // public void delete(Long id) {
    //     String sql = "DELETE FROM scout WHERE id = ?";
    //     try (Connection conn = dataSource.getConnection();
    //          PreparedStatement ps = conn.prepareStatement(sql)) {

    //         ps.setLong(1, id);
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    public Scout update(Long id, Scout scout) {
        String sql = "UPDATE scout SET team_id = ?, game_id = ?, person_id = ?, goals = ?, assists = ?, yellow_card = ?, red_card = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, scout.getTeamId());
            ps.setLong(2, scout.getGameId());
            ps.setLong(3, scout.getPlayerId());
            ps.setInt(4, scout.getGoals());
            ps.setInt(5, scout.getAssists());
            ps.setInt(6, scout.getYellowCard());
            ps.setInt(7, scout.getRedCard());
            ps.setLong(8, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scout;
    }

    private Scout mapRow(ResultSet rs) throws SQLException {
        Scout scout = new Scout();
        scout.setId(rs.getLong("id"));
        scout.setTeamId(rs.getLong("team_id"));
        scout.setGameId(rs.getLong("game_id"));
        scout.setPlayerId(rs.getLong("person_id"));
        scout.setGoals(rs.getInt("goals"));
        scout.setAssists(rs.getInt("assists"));
        scout.setYellowCard(rs.getInt("yellow_card"));
        scout.setRedCard(rs.getInt("red_card"));
        return scout;
    }
}
