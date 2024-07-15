package com.luisaraujoc.cativeriolfc.Interface;

import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.List;

public interface TeamPersonDaoInter {
    void insert(Team team, Long currentPlayerId);
    List<Person> findPeopleByIdTeam(Long teamId);
    Person update(Long id, Person obj);
    void delete(Team team, Person person);
    List<Person> findAll();
}
