package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.DTO.CurrentPlayersRequest;
import com.luisaraujoc.cativeriolfc.DTO.SortTeamRequest;
import com.luisaraujoc.cativeriolfc.Dao.CurrentPlayerDao;
import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GameDayDAO;
import com.luisaraujoc.cativeriolfc.Dao.PersonDao;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Exception.DbException;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;
import com.luisaraujoc.cativeriolfc.Util.GenerateTeam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.luisaraujoc.cativeriolfc.Enum.Role.ADMIN;

@Service
public class GameDayService {

    public GameDayDAO gameDao = DaoFactory.createGameDayDao();
    public GameDayTeamDaoInter gameDayTeamDao = DaoFactory.createGameDayTeamDao();


    public GameDay findByDate(String date) {
        return gameDao.findByDate(date);
    }

    public  GameDay insert(GameDay gameDay) {
        return gameDao.createGameDay(gameDay);
    }

    public List<Person> addPlayers(CurrentPlayersRequest cpr){

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

    public void deletePlayers(Long id){
        DaoFactory.createCurrentPlayerDao().delete(id);
    }

    public List<Team> sortTeam(SortTeamRequest sortTeamRequest){
        Person p = DaoFactory.createPersonDao().findById(sortTeamRequest.getPersonId());
        GameDay gameDay = DaoFactory.createGameDayDao().findById(sortTeamRequest.getGameDayId());
        if(p.getKindPerson() == ADMIN){
            GenerateTeam.handleCreation(gameDay);
            return gameDay.getTeams();
        }else{
            throw new DbException(p.getName() + " não é um ADMIN");
        }

    }


}
