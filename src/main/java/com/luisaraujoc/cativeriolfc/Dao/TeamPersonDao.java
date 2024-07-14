package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.TeamPersonDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamPersonDao implements TeamPersonDaoInter {
    private static Connection conn;

    public TeamPersonDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Team team, Long CurrentPlayerId) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("INSERT INTO team_person (current_player_id, time_id) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setLong(1, CurrentPlayerId);
            st.setLong(2, team.getId());
            int rowsAffected = st.executeUpdate();

            if (rowsAffected <= 0) {
                throw new DbException("Nenhuma linha afetada ao inserir o dados no Team_Person.");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Person> findPeopleByIdTeam(Long teamId) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Person> people = new ArrayList<>();
        CurrentPlayerDao cpd = DaoFactory.createCurrentPlayerDao();

        try {

            st =  conn.prepareStatement("select * from team_person WHERE time_id = ?");
            st.setLong(1, teamId);
            rs = st.executeQuery();


            while(rs.next()) {
                Person p = cpd.findPeopleByIdCurrentPlayer(rs.getLong("current_player_id"));
                people.add(p);
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
    public Person update(Long id, Person obj) {
        return null;
    }

    @Override
    public void delete(Team team, Person person) {

    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }
}
