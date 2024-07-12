package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.Team;

public interface TeamDaoInter {

    public void createTeam(Team team);
    public Team findById(Long teamId);
}
