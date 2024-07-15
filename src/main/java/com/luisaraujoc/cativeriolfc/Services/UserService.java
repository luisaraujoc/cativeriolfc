package com.luisaraujoc.cativeriolfc.Services;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.UserDao;

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

    public static User insert(User obj, Person person) {
        person = DaoFactory.createPersonDao().insert(person);
        return userDao.insert(obj, person.getId());
    }

}

