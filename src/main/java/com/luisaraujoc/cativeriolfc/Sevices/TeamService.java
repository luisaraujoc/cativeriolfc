package com.luisaraujoc.cativeriolfc.Sevices;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.TeamDao;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    public TeamDao teamDao = DaoFactory.createTeamDao();
    public GameDayTeamDaoInter gameDayTeamDao = DaoFactory.createGameDayTeamDao();


    public  List<Team> findAllByGameDay(Long idGameDay) {
        return gameDayTeamDao.findTeamsByIdGameDay(idGameDay);
    }

    public  Team findById(Long idTeam) {
        return teamDao.findById(idTeam);
    }


}
