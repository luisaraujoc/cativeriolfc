package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.List;

public interface GameDayDaoInter {

    public void createGameDay(GameDay gameDay);
    public List<Team> findTeams(GameDay gameDay);
}
