package com.luisaraujoc.cativeriolfc.Dao;

import com.luisaraujoc.cativeriolfc.Config.DB;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;

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

    public static GameDayTeamDaoInter createGameDayTeamDao(){return new GameDayTeamDAO(DB.getConnection());}

    public static CurrentPlayerDao createCurrentPlayerDao(){return new CurrentPlayerDao(DB.getConnection());}

    public static TeamPersonDao createTeamPersonDao(){return new TeamPersonDao(DB.getConnection());}
}
