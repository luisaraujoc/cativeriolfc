package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;

import java.util.List;

public interface CurrentPlayerDaoInter {
    void insert(GameDay gameDay, Person person);
    List<Person> findPeopleByIdGameDay(Long gameDayId);
    Person findPeopleByIdCurrentPlayer(Long currentPlayerId);
    Long findCurrentPlayerId(Person person, GameDay gameDay);
    Person update(Long id, Person obj);
    void delete(Long id);
    List<Person> findAll();
}
