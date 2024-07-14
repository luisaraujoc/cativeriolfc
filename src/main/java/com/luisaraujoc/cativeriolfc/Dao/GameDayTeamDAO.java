package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDayTeamDAO implements GameDayTeamDaoInter {
    private Connection conn = null;
    public GameDayTeamDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(GameDay gameDay, Team team) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("INSERT INTO gameday_team (team_id, gameDay_id) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setLong(1, team.getId());
            st.setLong(2, gameDay.getId());
            int rowsAffected = st.executeUpdate();

            if (rowsAffected <= 0) {
                throw new DbException("Nenhuma linha afetada ao inserir o dados no gameDay_Team.");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Team> findTeamsByIdGameDay(Long idGameDay) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Team> teams = new ArrayList<>();

        try {

            st =  conn.prepareStatement("select * from gameday_Team WHERE gameDay_id = ?");
            st.setLong(1, idGameDay);
            rs = st.executeQuery();


            while(rs.next()) {
                TeamDao td = DaoFactory.createTeamDao();
                teams.add(td.findById(rs.getLong("team_id")));
            }

            return teams;

        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }
//Continua
    @Override
    public Team update(Long id, Team obj) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Team findById(Long id) {
        return null;
    }

    @Override
    public List<Team> findAll() {
        return List.of();
    }
}
