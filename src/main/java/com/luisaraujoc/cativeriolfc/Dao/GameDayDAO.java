package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDayDAO {

    private final Connection conn;

    public GameDayDAO(Connection conn) {
        this.conn = conn;
    }

    public void createGameDay (GameDay gameDay){
        PreparedStatement st = null;


        try{
            st = conn.prepareStatement("INSERT INTO gameday (date) VALUES (?)",Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, new java.sql.Date(gameDay.getDate().getTime()));
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }
    }

    public List<Person> findCurrentPlayers(GameDay gameDay){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("Select * from current_player where gameday_id = ?");
            st.setLong(1, gameDay.getId());

            rs = st.executeQuery();

            // List<Person> currentPlayers = new ArrayList<>();
            while (rs.next()){
                Person person = null;
                gameDay.addCurrentPlayers(
                        person = PersonDao.findById(
                                rs.getLong("person_id")
                        )
                );
            }

            // quando acabar, retorna a lista
            return gameDay.getCurrentPlayers();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }
    }

    public List<Team> findTeams(GameDay gameDay){
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("select * from gameday_team where gameDay_id = ?");
            st.setLong(1, gameDay.getId());

            rs = st.executeQuery();

            List<Team> teams = new ArrayList<>();
            while (rs.next()){
                Team team = null;
                gameDay.addTeam(
                        team = TeamDao.findById(
                                rs.getLong("team_id")
                        )
                );
            }

            // quando acabar, retorna a lista
            return gameDay.getTeams();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }
    }
}
