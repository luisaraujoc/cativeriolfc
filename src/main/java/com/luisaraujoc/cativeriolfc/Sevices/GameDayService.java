package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.DTO.CurrentPlayersRequest;
import com.luisaraujoc.cativeriolfc.Dao.CurrentPlayerDao;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GameDayDAO;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;

import java.util.ArrayList;
import java.util.List;

import static com.luisaraujoc.cativeriolfc.Enum.Role.ADMIN;


public class GameDayService {

    public static GameDayDAO gameDao = DaoFactory.createGameDayDao();
    public static GameDayTeamDaoInter gameDayTeamDao = DaoFactory.createGameDayTeamDao();


    public static GameDay findByDate(String date) {
        return gameDao.findByDate(date);
    }

    public static GameDay insert(GameDay gameDay) {
        return gameDao.createGameDay(gameDay);
    }

    public static List<Person> addPlayers(CurrentPlayersRequest cpr){

        GameDay gd = DaoFactory.createGameDayDao().findById(cpr.getGameDayId());
        CurrentPlayerDao cpd = DaoFactory.createCurrentPlayerDao();
        PersonDao pdao = DaoFactory.createPersonDao();
        List<Person> people = new ArrayList<>();

        for(Long personId : cpr.getPlayerId()){
            Person p = pdao.findById(personId);
            cpd.insert(gd, p);
            people.add(p);
        }

        return people;
    }

    public static void deletePlayers(Long id){
        DaoFactory.createCurrentPlayerDao().delete(id);
    }


}
