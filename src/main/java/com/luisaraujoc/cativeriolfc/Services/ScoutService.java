package com.luisaraujoc.cativeriolfc.Services;


import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.ScoutDao;
import com.luisaraujoc.cativeriolfc.Entity.Scout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutService {

    private final ScoutDao scoutDao = DaoFactory.createScoutDao();

    public void insert(Scout scout) {
        scoutDao.insert(scout);
    }

    public void update(Scout scout) {
        scoutDao.update(scout);
    }

    public List<Scout> findAll() {
        return scoutDao.findAll();
    }

    public List<Scout> findByGameId(Long gameId) {
        return scoutDao.findByGameId(gameId);
    }

    public List<Scout> findByPersonId(Long personId) {
        return scoutDao.findByPersonId(personId);
    }

    public List<Scout> findByTeamId(Long teamId) {
        return scoutDao.findByTeamId(teamId);
    }

}
