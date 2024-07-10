package com.luisaraujoc.cativeriolfc.dao;


import com.luisaraujoc.cativeriolfc.dao.implement.PersonDao;
import com.luisaraujoc.cativeriolfc.dao.implement.UserDao;
import com.luisaraujoc.cativeriolfc.db.DB;

public class DaoFactory {

    public static PersonDao createPersonDao(){
        return new PersonDao(DB.getConnection());
    }

    public static UserDao createUserDao(){
        return new UserDao(DB.getConnection());
    }
}
