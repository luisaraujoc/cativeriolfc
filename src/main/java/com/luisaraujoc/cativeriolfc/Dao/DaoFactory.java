package com.luisaraujoc.cativeriolfc.Dao;


import com.luisaraujoc.cativeriolfc.Config.DB;

public class DaoFactory {

    public static PersonDao createPersonDao(){
        return new PersonDao(DB.getConnection());
    }

    public static UserDao createUserDao(){
        return new UserDao(DB.getConnection());
    }
}
