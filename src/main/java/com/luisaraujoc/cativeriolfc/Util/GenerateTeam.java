package com.luisaraujoc.cativeriolfc.Util;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;
import com.luisaraujoc.cativeriolfc.Dao.GameDayTeamDAO;
import com.luisaraujoc.cativeriolfc.Entity.GameDay;
import com.luisaraujoc.cativeriolfc.Entity.Person;
import com.luisaraujoc.cativeriolfc.Entity.Team;
import com.luisaraujoc.cativeriolfc.Interface.GameDayTeamDaoInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTeam {
    public static void handleCreation(GameDay gameDay){
        Random random = new Random();
		List<Person> playersToAdd = gameDay.getCurrentPlayers();
		List<Person> currentTeam = new ArrayList<>();
		GameDayTeamDaoInter gtd = DaoFactory.createGameDayTeamDao();
		gameDay.findCurrentPlayers();

		for(int u = 0; u < gameDay.getCurrentPlayers().size()/5; u++) {
			for (int i = 1; i <= 5; i++) {
				int sort = random.nextInt(playersToAdd.size());
				currentTeam.add(playersToAdd.get(sort));
				playersToAdd.remove(sort);

			}
			String name = "TIME " + (u +1);
			Team team = DaoFactory.createTeamDao().createTeam(new Team(name, currentTeam), gameDay);

			for (Person p : team.getPlayers()) {
				System.out.println(p.getName());
			}
			gtd.insert(gameDay, team);

			currentTeam.clear();
		}

		List<Team> TeamsInGameDay = gtd.findTeamsByIdGameDay(gameDay);

		for(Team team : TeamsInGameDay) {
			gameDay.addTeam(team);
		}

    }

}
