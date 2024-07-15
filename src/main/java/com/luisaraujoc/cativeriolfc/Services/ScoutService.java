package com.luisaraujoc.cativeriolfc.Services;


import com.luisaraujoc.cativeriolfc.Dao.ScoutDao;
import com.luisaraujoc.cativeriolfc.Entity.Scout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutService {
    private final ScoutDao scoutDao;

    public ScoutService(ScoutDao scoutDao) {
        this.scoutDao = scoutDao;
    }

    public Scout createScout(Scout scout) {
        scoutDao.insert(scout);
        return scout;
    }

    public Scout getScoutById(Long id) {
        return scoutDao.findById(id);
    }

    public List<Scout> getAllScouts() {
        return scoutDao.findAll();
    }

    // public void deleteScout(Long id) {
    //     scoutDao.delete(id);
    // }

    public Scout updateScout(Long id, Scout scout) {
        return scoutDao.update(id, scout);
    }

    public List<Scout> getScoutsByTeam(Long teamId) {
        return scoutDao.findByTeamId(teamId);
    }

    public List<Scout> getScoutsByGame(Long gameId) {
        return scoutDao.findByGameId(gameId);
    }

    public List<Scout> getScoutsByPlayer(Long playerId) {
        return scoutDao.findByPlayerId(playerId);
    }
}
