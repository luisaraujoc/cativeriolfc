package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.TeamDaoInter;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao implements TeamDaoInter {

    private final Connection conn;

    public TeamDao(Connection conn) {
        this.conn = conn;
    }

    public Team createTeam(Team team, GameDay gameDay) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO team (name) values (?)", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, team.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    team.setId(id);

                    insertAllPlayerInTeamPerson(team, gameDay);

                    return findById(id);
                } else {
                    throw new DbException("Falha ao obter o id gerado após a inserção.");
                }
            } else {
                throw new DbException("Nenhuma linha afetada ao inserir o usuário.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }
    }

    public Team findById(Long teamId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("Select * from team where id = ?");
            st.setLong(1, teamId);

            rs = st.executeQuery();

            if (rs.next()) {
                Team t = new Team(rs.getLong("id"), rs.getString("nome"));
                t.findPlayers();
                return t;
            } else {
                throw new DbException("Nenhum time encontrado com o id: " + teamId);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public Team findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("Select * from team");

            rs = st.executeQuery();

            if (rs.next()) {
                return new Team(
                        rs.getLong("id"),
                        rs.getString("name"),
                        null
                );
            } else {
                throw new DbException("Nenhum time encontrado");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private void insertAllPlayerInTeamPerson(Team team, GameDay gameDay){
        for (Person person : team.getPlayers()) {
            Long currentPlayerId = DaoFactory.createCurrentPlayerDao().findCurrentPlayerId(person, gameDay);
            DaoFactory.createTeamPersonDao().insert(team, currentPlayerId);
        }
    }
}
