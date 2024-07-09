package com.luisaraujoc.cativeriolfc.dao.implement;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.dao.interfac.PersonDaoInter;
import com.luisaraujoc.cativeriolfc.db.DB;
import com.luisaraujoc.cativeriolfc.db.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao  implements PersonDaoInter {

    private Connection conn = null;
    public PersonDao(Connection conn){
        this.conn = conn;
    }

    @Override
    public Person insert(Person obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("INSERT INTO person (name, cpf, tel, kindPerson) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getTel());
            st.setString(4, obj.getKindUser());

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

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Person update(Long id, Person obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE cativeriolfc SET name = ?, cpf = ?, tel = ?, kindPerson = ? WHERE Id = ?");
            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getTel());
            st.setString(4, obj.getKindUser());
            st.setLong(5, id);
            st.executeUpdate();
            return findById(id);
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM users WHERE Id = ?");

            st.setLong(1, id);
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Person findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from users WHERE Id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();


            if(rs.next()) {
                return createNewPerson(rs);
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
    public List<Person> findAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Person> pList = new ArrayList<>();

        try {


            st = conn.createStatement();
            rs = st.executeQuery("select * from users");

            while(rs.next()) {
                pList.add(createNewPerson(rs));
            }
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return pList;
    }

    public Person createNewPerson(ResultSet rs) throws SQLException{
        return new Person(rs.getLong("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("tel"), rs.getString("kindUser"));

    }
}
