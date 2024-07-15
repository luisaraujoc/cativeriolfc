package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Entity.Guest;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.GuestDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDao implements GuestDaoInter {

    private Connection conn;

    public GuestDao(Connection conn) {
        this.conn = conn;
    }

    public Guest insert(Guest guest) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO guest (name, host_id) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, guest.getName());
            st.setLong(2, guest.getHost().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    guest.setId(rs.getLong(1));
                    return guest;
                } else {
                    throw new DbException("Falha ao obter o id gerado após a inserção.");
                }
            } else {
                throw new DbException("Nenhuma linha afetada ao inserir o convidado.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public List<Guest> findAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Guest> guests = new ArrayList<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT g.id, g.name, p.id as host_id, p.name as host_name FROM guest g JOIN person p ON g.host_id = p.id");

            while (rs.next()) {
                Person host = new Person();
                host.setId(rs.getLong("host_id"));
                host.setName(rs.getString("host_name"));

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setHost(host);

                guests.add(guest);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return guests;
    }

    public Guest findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT g.id, g.name, p.id as host_id, p.name as host_name FROM guest g JOIN person p ON g.host_id = p.id WHERE g.id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Person host = new Person();
                host.setId(rs.getLong("host_id"));
                host.setName(rs.getString("host_name"));

                Guest guest = new Guest();
                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setHost(host);

                return guest;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    public void delete(Long id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM guest WHERE id = ?");
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    public Guest update(Long id, Guest guest) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE guest SET name = ?, host_id = ? WHERE id = ?");
            st.setString(1, guest.getName());
            st.setLong(2, guest.getHost().getId());
            st.setLong(3, id);
            st.executeUpdate();
            return findById(id);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }
}
