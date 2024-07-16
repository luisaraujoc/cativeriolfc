package com.luisaraujoc.cativeriolfc.Dao;


import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Util.Cryptography;
import com.luisaraujoc.cativeriolfc.Interface.UserDaoInter;
import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Exception.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInter {
    private Connection conn = null;
    public UserDao(Connection conn){
        this.conn = conn;
    }

    @Override
    public User insert(User obj, Long personId) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("INSERT INTO user (userName, password, status, person_id) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getUsername());
            st.setString(2, Cryptography.encrypt(obj.getPassword()));
            st.setBoolean(3, obj.getStatus());
            if(personId != null) {
                st.setLong(4, personId);
            }else{
                st.setInt(4, 0);
            }
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
            DaoFactory.createPersonDao().delete(personId);
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public User update(Long id, User obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE user SET userName = ?, password =  ?, status = ?, person_id = ? WHERE Id = ?");
            st.setString(1, obj.getUsername());
            st.setString(2, obj.getPassword());
            st.setBoolean(3, obj.getStatus());
            st.setLong(4, obj.getPerson().getId());
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
            st = conn.prepareStatement("DELETE FROM user WHERE Id = ?");

            st.setLong(1, id);
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public User findById(Long id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from user WHERE Id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();


            if(rs.next()) {
                return createNewUser(rs);
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
    public User findByIdPerson(Long id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st =  conn.prepareStatement("select * from user WHERE person_id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();


            if(rs.next()) {
                return createNewUser(rs);
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
    public List<User> findAll() {
        Statement st = null;
        ResultSet rs = null;
        List<User> uList = new ArrayList<>();

        try {


            st = conn.createStatement();
            rs = st.executeQuery("select * from user");

            while(rs.next()) {
                uList.add(createNewUser(rs));
            }
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return uList;
    }

    public User createNewUser(ResultSet rs) throws SQLException{

        return new User(rs.getLong("id"), rs.getString("userName"), rs.getString("password"), rs.getBoolean("status"), rs.getLong("person_id"));

    }
}
