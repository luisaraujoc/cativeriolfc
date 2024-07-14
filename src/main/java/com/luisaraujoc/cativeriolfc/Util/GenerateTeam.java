package com.luisaraujoc.cativeriolfc.Util;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTeam {
    public static void handleCreation(GameDay gameDay){
        Random random = new Random();
		List<Person> playersToAdd = gameDay.getCurrentPlayers();
		List<Person> currentTeam = new ArrayList<>();

		for(int u = 0; u < gameDay.getCurrentPlayers().size()/5; u++) {
			for (int i = 0; i < 4; i++) {
				currentTeam.add(playersToAdd.get(random.nextInt(playersToAdd.size())));
			}
			String name = "TIME " + (u +1);
			Team team = DaoFactory.createTeamDao().createTeam(new Team(name, currentTeam));

			for (Person p : team.getPlayers()) {
				System.out.println(p.getName());
			}
			DaoFactory.createGameDayTeamDao().insert(gameDay, team);
			matchTeamPerson(gameDay, team);
		}

		List<Team> TeamsInGameDay = DaoFactory.createGameDayTeamDao().findTeamsByIdGameDay(gameDay);

		for(Team team : TeamsInGameDay) {
			gameDay.addTeam(team);
		}

    }

	private static void matchTeamPerson(GameDay gameDay, Team team){

		for (Person player: team.getPlayers()) {
			Long currentPlayerId = DaoFactory.createCurrentPlayerDao().findCurrentPlayerId(player, gameDay);

			DaoFactory.createTeamPersonDao().insert(team, currentPlayerId);
		}
	}
}
