package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;

import javax.xml.transform.Result;
import java.sql.*;

public class TeamDao {

    private static Connection conn;

    public TeamDao(Connection conn) {
        this.conn = conn;
    }

    public Team createTeam(Team team){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "INSERT INTO team (nome) values (?)", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, team.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    return findById(id);
                } else {
                    throw new DbException("Falha ao obter o id gerado após a inserção.");
                }
            } else {
                throw new DbException("Nenhuma linha afetada ao inserir o usuário.");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }
    }

    public Team findById(Long teamId){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("Select * from team where id = ?");
            st.setLong(1, teamId);

            rs = st.executeQuery();

            if (rs.next()){
                return new Team(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        null
                );
            }
            else{
                throw new DbException("Nenhum time encontrado com o id: " + teamId);
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public Team findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("Select * from team");

            rs = st.executeQuery();

            if (rs.next()){
                return new Team(
                        rs.getLong("id"),
                        rs.getString("name"),
                        null
                );
            }
            else{
                throw new DbException("Nenhum time encontrado");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

//    public Team findByGameDayId(Long gameDayId){
//        PreparedStatement st = null;
//        ResultSet rs = null;
//
//        try{
//            // selecionar todos os times que participaram de um determinado gameday
//            st = conn.prepareStatement("Select * from gameday_team where gameday_id = ?");
//            st.setLong(1, gameDayId);
//
//            rs = st.executeQuery();
//
//            if (rs.next()){
//                return findById(rs.getLong("team_id"));
//            }
//            else{
//                throw new DbException("Nenhum time encontrado com o id do gameday: " + gameDayId);
//            }
//        }
//        catch (SQLException e) {
//            throw new DbException(e.getMessage());
//        } finally {
//            DB.closeStatement(st);
//            DB.closeResultSet(rs);
//        }
//    }
}
