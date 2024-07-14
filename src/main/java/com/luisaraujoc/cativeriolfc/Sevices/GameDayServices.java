package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GameDayDAO;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Entity.Person;

import java.util.List;

public class GameDayServices {

    private static final GameDayDAO gameDayDAO = DaoFactory.createGameDayDao();

    public static GameDay insert(GameDay gameDay) {
        gameDayDAO.createGameDay(gameDay);
        return gameDay;
    }

//    public static List<GameDay> findAll() {
//        return gameDayDAO.findAll();
//    }

//    public static GameDay findById(Long id) {
//        return gameDayDAO.findById(id);
//    }

//    public static void delete(Long id) {
//        gameDayDAO.delete(id);
//    }

//    public static GameDay update(Long id, GameDay gameDay) {
//        return gameDayDAO.update(id, gameDay);
//    }
/*
    public static List<Person> findCurrentPlayers(GameDay gameDay) {
        return gameDayDAO.findCurrentPlayers(gameDay);
    }

    public static List<Team> findTeams(GameDay gameDay) {
        return gameDayDAO.findTeams(gameDay);
    }


 */
}
