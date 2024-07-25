package com.luisaraujoc.cativeriolfc.Dao;


import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.Scout;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.ScoutDaoInter;

import java.sql.*;
import java.util.List;

public class ScoutDao implements ScoutDaoInter {

    private Connection conn = null;

    public ScoutDao(Connection conn) {
        this.conn = conn;
    }


    // insert
    public void insert(Scout scout) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO scout (team_id, game_id, person_id, goals, yellow_card, red_card, assists) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setLong(1, scout.getTeamId());
            st.setLong(2, scout.getGameId());
            st.setLong(3, scout.getPlayerId());
            st.setInt(4, scout.getGoals());
            st.setInt(5, scout.getYellowCard());
            st.setInt(6, scout.getRedCard());
            st.setInt(7, scout.getAssists());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao gerar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    // update
    public void update(Scout scout) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("update scout set goals = ?, yellow_card = ?, red_card = ?, assists = ? where id = ?");

            st.setInt(1, scout.getGoals());
            st.setInt(2, scout.getYellowCard());
            st.setInt(3, scout.getRedCard());
            st.setInt(4, scout.getAssists());
            st.setLong(5, scout.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao atualizar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    // findById
    public Scout findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from scout where id = ?");

            st.setLong(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                return new Scout(
                        rs.getLong("id"),
                        rs.getLong("team_id"),
                        rs.getLong("game_id"),
                        rs.getLong("person_id"),
                        rs.getInt("goals"),
                        rs.getInt("yellow_card"),
                        rs.getInt("red_card"),
                        rs.getInt("assists")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao buscar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // findAll
    public List<Scout> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from scout");

            rs = st.executeQuery();

            if (rs.next()) {
                return List.of(new Scout(
                        rs.getLong("id"),
                        rs.getLong("team_id"),
                        rs.getLong("game_id"),
                        rs.getLong("person_id"),
                        rs.getInt("goals"),
                        rs.getInt("yellow_card"),
                        rs.getInt("red_card"),
                        rs.getInt("assists")
                ));
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao buscar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // findByGameId
    public List<Scout> findByGameId(Long gameId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from scout where game_id = ?");
            st.setLong(1, gameId);

            rs = st.executeQuery();

            if (rs.next()) {
                return List.of(new Scout(
                        rs.getLong("id"),
                        rs.getLong("team_id"),
                        rs.getLong("game_id"),
                        rs.getLong("person_id"),
                        rs.getInt("goals"),
                        rs.getInt("yellow_card"),
                        rs.getInt("red_card"),
                        rs.getInt("assists")
                ));
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao buscar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // findByPersonId
    public List<Scout> findByPersonId(Long personId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from scout where person_id = ?");
            st.setLong(1, personId);

            rs = st.executeQuery();

            if (rs.next()) {
                return List.of(
                        new Scout(
                                rs.getLong("id"),
                                rs.getLong("team_id"),
                                rs.getLong("game_id"),
                                rs.getLong("person_id"),
                                rs.getInt("goals"),
                                rs.getInt("yellow_card"),
                                rs.getInt("red_card"),
                                rs.getInt("assists")
                        )
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao buscar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // findByTeamId
    public List<Scout> findByTeamId(Long teamId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select * from scout where team_id = ?");
            st.setLong(1, teamId);

            rs = st.executeQuery();

            if (rs.next()) {
                return List.of(
                        new Scout(
                                rs.getLong("id"),
                                rs.getLong("team_id"),
                                rs.getLong("game_id"),
                                rs.getLong("person_id"),
                                rs.getInt("goals"),
                                rs.getInt("yellow_card"),
                                rs.getInt("red_card"),
                                rs.getInt("assists")
                        )
                );
            }
            return null;
        } catch (SQLException e) {
            throw new DbException("Houve um erro ao buscar o Scout: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // não teremos delete, pois não é interessante deletar um scout.

    // closeConnection
    // public void closeConnection(){
    //      DB.closeConnection();
    // }
}
