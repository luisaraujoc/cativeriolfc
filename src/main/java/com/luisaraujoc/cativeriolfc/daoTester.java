package com.luisaraujoc.cativeriolfc;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.dao.implement.PersonDao;
import com.luisaraujoc.cativeriolfc.dao.implement.UserDao;

public class daoTester {
    public static void main(String[] args) {
        /*UserDao userDao = DaoFactory.createUserDao();
        System.out.println(userDao.findAll());*/

        PersonDao pDao = DaoFactory.createPersonDao();
        pDao.insert(new Person("Luis Viado", "8466484946", "739191974", "ADM"));
    }
}
