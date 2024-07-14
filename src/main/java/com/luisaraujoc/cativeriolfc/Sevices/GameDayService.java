package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GameDayDAO;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;


public class GameDayService {

    public static GameDayDAO gameDao = DaoFactory.createGameDayDao();
    public static GameDayTeamDaoInter gameDayTeamDao = DaoFactory.createGameDayTeamDao();


    public static GameDay findByDate(String date) {
        return gameDao.findByDate(date);
    }

    public static GameDay insert(GameDay gameDay) {
        return gameDao.createGameDay(gameDay);
    }


}
