package com.luisaraujoc.cativeriolfc.Util;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  generateTeam {
    public static GameDay handleCreation(GameDay gameDay){
        Random random = new Random();
		List<Person> playersToAdd = gameDay.getCurrentPlayers();
		List<Person> currentTeam = new ArrayList<>();
		List<Team> generatedTeams = new ArrayList<>();

		for(int u = 0; u < gameDay.getCurrentPlayers().size()/5; u++) {
			for (int i = 0; i < 4; i++) {
				currentTeam.add(playersToAdd.get(random.nextInt(playersToAdd.size())));
			}
			String name = "TIME " + (u +1);
			Team team = DaoFactory.createTeamDao().createTeam(new Team(name, currentTeam));
			DaoFactory.createGameDayTeamDao().insert(gameDay, team);
		}

		List<Team> TeamsInGameDay = DaoFactory.createGameDayTeamDao().findTeamsByIdGameDay(gameDay);

		for(Team team : TeamsInGameDay) {
			gameDay.addTeam(team);
		}

        return gameDay;
    }

	public static void handleCurrentPlayer(GameDay gameDay){
		List<Person> currentPlayers = DaoFactory.createPersonDao().findByGameDay(gameDay);
		for (Person person : currentPlayers) {
			boolean comparation = false;
			for (Person personToCompare : gameDay.getCurrentPlayers()){
                if (personToCompare.getId().equals(person.getId())) {
                    comparation = true;
                }
			}
			if(!comparation){
				gameDay.addCurrentPlayers(person);
			}
		}
	}
}
