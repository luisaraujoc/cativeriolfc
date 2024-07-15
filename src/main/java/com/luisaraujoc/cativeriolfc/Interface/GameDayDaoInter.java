package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.List;

public interface GameDayDaoInter {

    public GameDay createGameDay(GameDay gameDay);
    public GameDay findById(Long id);
    public GameDay findByDate(String date);
}
