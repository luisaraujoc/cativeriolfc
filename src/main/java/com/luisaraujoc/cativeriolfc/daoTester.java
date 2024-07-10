package com.luisaraujoc.cativeriolfc;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;

public class daoTester {
    public static void main(String[] args) {
        /*UserDao userDao = DaoFactory.createUserDao();
        System.out.println(userDao.findAll());*/

        PersonDao pDao = DaoFactory.createPersonDao();
        pDao.insert(new Person(
            "Hominimen",
            "8466484946",
            "739191974",
            "USER"));
    }
}
