package com.luisaraujoc.cativeriolfc.Services;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.TeamDao;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;

import java.util.List;

public class TeamService {

    public static TeamDao teamDao = DaoFactory.createTeamDao();
    public static GameDayTeamDaoInter gameDayTeamDao = DaoFactory.createGameDayTeamDao();


    public static List<Team> findAllByGameDay(Long idGameDay) {
        return gameDayTeamDao.findTeamsByIdGameDay(idGameDay);
    }

    public static Team findById(Long idTeam) {
        return teamDao.findById(idTeam);
    }


}
