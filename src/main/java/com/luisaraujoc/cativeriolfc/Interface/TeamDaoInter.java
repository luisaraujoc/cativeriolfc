package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Dao.GameDayTeamDAO;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;

public interface TeamDaoInter {

    public Team createTeam(Team team, GameDay gameDay);
    public Team findById(Long teamId);
    public Team findAll();
}
