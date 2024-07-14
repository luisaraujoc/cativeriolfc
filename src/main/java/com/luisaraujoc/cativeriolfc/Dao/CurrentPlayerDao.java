package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.CurrentPlayerDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrentPlayerDao implements CurrentPlayerDaoInter {
    private static Connection conn;

    public CurrentPlayerDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(GameDay gameDay, Person person) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("INSERT INTO current_player (person_id, gameDay_id) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setLong(1, person.getId());
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
    public List<Person> findPeopleByIdGameDay(Long gameDayId) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Person> people = new ArrayList<>();

        try {

            st =  conn.prepareStatement("select * from current_player WHERE gameDay_id = ?");
            st.setLong(1, gameDayId);
            rs = st.executeQuery();


            while(rs.next()) {
                PersonDao pd = DaoFactory.createPersonDao();
                people.add(pd.findById(rs.getLong("person_id")));
            }

            return people;

        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public Person findPeopleByIdCurrentPlayer(Long currentPlayerId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from current_player WHERE id = ?");
            st.setLong(1, currentPlayerId);
            rs = st.executeQuery();


            if(rs.next()) {
                return DaoFactory.createPersonDao().findById(rs.getLong("person_id"));
            }


        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public Long findCurrentPlayerId(Person person, GameDay gameDay) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from current_player WHERE gameDay_id = ? AND person_id = ?");
            st.setLong(1, gameDay.getId());
            st.setLong(2, person.getId());
            rs = st.executeQuery();


            if(rs.next()) {
                return rs.getLong("id");
            }


        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

        return null;
    }

    @Override
    public Person update(Long id, Person obj) {
        return null;
    }

    @Override
    public void delete(GameDay gameDay, Person person) {

    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }
}
