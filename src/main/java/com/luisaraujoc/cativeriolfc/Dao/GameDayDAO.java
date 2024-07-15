package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.GameDayDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class GameDayDAO implements GameDayDaoInter {

    private final Connection conn;

    public GameDayDAO(Connection conn) {
        this.conn = conn;
    }

    public GameDay createGameDay (GameDay gameDay){
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("INSERT INTO gameday (date) VALUES (?)",Statement.RETURN_GENERATED_KEYS);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(gameDay.getDate());
            calendar.add(Calendar.HOUR_OF_DAY, 3);
            java.util.Date updatedDate = calendar.getTime();

            st.setDate(1, new java.sql.Date(updatedDate.getTime()));
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                gameDay.setId(rs.getInt(1));
                return gameDay;
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(null);
        }

        return null;
    }



    @Override
    public GameDay findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM gameday WHERE Id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                List<Person> currentPlayers= DaoFactory.createCurrentPlayerDao().findPeopleByIdGameDay(rs.getLong("id"));
                GameDay gd = new GameDay(rs.getLong("id"), rs.getDate("date"),currentPlayers);
                gd.findCurrentTeams();
                return gd;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public GameDay findByDate(String date) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM gameday WHERE date = ?");
            st.setString(1, date);
            rs = st.executeQuery();

            if (rs.next()) {
                List<Person> currentPlayers= DaoFactory.createCurrentPlayerDao().findPeopleByIdGameDay(rs.getLong("id"));
                GameDay gd = new GameDay(rs.getLong("id"), rs.getDate("date"),currentPlayers);
                gd.findCurrentTeams();
                return gd;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

}
