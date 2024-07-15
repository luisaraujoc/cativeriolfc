package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.User;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public  UserDao userDao = DaoFactory.createUserDao();

    public  List<User> findAll() {
        return userDao.findAll();
    }

    public  User findById(Long id) {
        return userDao.findById(id);
    }

    public  void delete(Long id) {
        userDao.delete(id);
    }

    public  User update(Long id, User obj) {
        return userDao.update(id, obj);
    }

    public  User insert(User obj, Person person) {
        person = DaoFactory.createPersonDao().insert(person);
        return userDao.insert(obj, person.getId());
    }

}

