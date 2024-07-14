package com.luisaraujoc.cativeriolfc.Entity;


import com.luisaraujoc.cativeriolfc.Dao.DaoFactory;

import java.util.*;

public class GameDay {

	private Long id;
	private Date date;
	private List<Team> teams = new ArrayList<>();
	private List<Person> currentPlayers = new ArrayList<>();


	public GameDay(long id, Date date, List<Person> currentPlayers) {
		this.id = id;
		this.date = date;
		this.currentPlayers = currentPlayers;
	}

	public GameDay() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void addTeam(Team team) {
		this.teams.add(team);
	}

	public List<Person> getCurrentPlayers() {
		return currentPlayers;
	}

	public void findCurrentPlayers() {
		currentPlayers = DaoFactory.createCurrentPlayerDao().findPeopleByIdGameDay(this.id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GameDay gameDay = (GameDay) o;
		return id == gameDay.id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "GameDay{" +
				"id=" + id +
				", date=" + date +
				", teams=" + teams +
				", currentPlayers=" + currentPlayers +
				'}';
	}

}

