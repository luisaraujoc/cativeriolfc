package com.luisaraujoc.cativeriolfc.Interface;

import java.util.List;

import com.luisaraujoc.cativeriolfc.Entity.Scout;

public interface ScoutDaoInter {

    public void insert(Scout scout);

    public void update(Scout scout);

    public List<Scout> findAll();

    public List<Scout> findByGameId(Long gameId);

    public List<Scout> findByPersonId(Long personId);

    public List<Scout> findByTeamId(Long teamId);


}
