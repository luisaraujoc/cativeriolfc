package com.luisaraujoc.cativeriolfc.Entity;

import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team {

	private Long id;
	private String name;
	private List<Person> players = new ArrayList<>();

	public Team(Long id, String name, List<Person> players) {
		this.id = id;
		this.name = name;
		this.players = players;
	}
	public Team(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Team( String name, List<Person> players) {
		this.name = name;
		this.players = players;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPlayers() {
		return players;
	}

	public void findPlayers() {
		players = DaoFactory.createTeamPersonDao().findPeopleByIdTeam(this.id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Team team = (Team) o;
		return Objects.equals(id, team.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Team{" +
				"id=" + id +
				", name='" + name + '\'' +
				", players=" + players +
				'}';
	}
}
