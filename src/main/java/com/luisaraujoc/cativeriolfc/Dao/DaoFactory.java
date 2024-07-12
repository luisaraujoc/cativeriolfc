package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;

public class DaoFactory {

    public static PersonDao createPersonDao(){
        return new PersonDao(DB.getConnection());
    }

    public static UserDao createUserDao(){
        return new UserDao(DB.getConnection());
    }

    public static GuestDao createGuestDao(){
        return new GuestDao(DB.getConnection());
    }

    public static GameDayDAO createGameDayDao(){
        return new GameDayDAO(DB.getConnection());
    }

    public static TeamDao createTeamDao(){
        return new TeamDao(DB.getConnection());
    }
}
