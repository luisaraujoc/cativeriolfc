package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.List;

public interface GameDayTeamDaoInter {

    void insert(GameDay gameDay, Team team);
    List<Team> findTeamsByIdGameDay(GameDay gameDay);
    Team update(Long id, Team obj);
    void delete(Long id);
    Team findById(Long id);
    List<Team> findAll();

}
