package com.luisaraujoc.cativeriolfc.dao.implement;


import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.dao.interfac.UserDaoInter;

import java.util.List;

public class UserDao implements UserDaoInter {


    @Override
    public User insert(User obj) {
        return null;
    }

    @Override
    public User update(Long id, User obj) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
