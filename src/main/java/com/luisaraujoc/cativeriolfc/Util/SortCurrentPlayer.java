package com.luisaraujoc.cativeriolfc.Util;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;

import java.util.List;

public class SortCurrentPlayer {
  //Unusual
    public static void handleCurrentPlayer(GameDay gameDay){
        List<Person> currentPlayers = DaoFactory.createCurrentPlayerDao().findPeopleByIdGameDay(gameDay.getId());
        for (Person person : currentPlayers) {
            boolean comparation = false;
            for (Person personToCompare : gameDay.getCurrentPlayers()){
                if (personToCompare.getId().equals(person.getId())) {
                    comparation = true;
                }
            }
            if(!comparation){
                DaoFactory.createCurrentPlayerDao().insert(gameDay, person);
            }
        }
    }
}
