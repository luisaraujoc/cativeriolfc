package com.luisaraujoc.cativeriolfc.sevices;

import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.dao.implement.UserDao;

import java.util.List;

public class UserService {

    public static UserDao userDao = DaoFactory.createUserDao();

    public static List<User> findAll() {
        return userDao.findAll();
    }

    public static User findById(Long id) {
        return userDao.findById(id);
    }

    public static void delete(Long id) {
        userDao.delete(id);
    }

    public static User update(Long id, User obj) {
        return userDao.update(id, obj);
    }

    public static User insert(User obj, Long personId) {
        return userDao.insert(obj, personId);

    }

}

