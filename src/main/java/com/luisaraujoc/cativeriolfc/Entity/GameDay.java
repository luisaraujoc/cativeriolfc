package com.luisaraujoc.cativeriolfc.Entity;


import java.util.*;

public class GameDay {

	private long id;
	private Date date;
	private List<Team> teams = new ArrayList<>();
	private List<Person> currentPlayers = new ArrayList<>();


	public GameDay(long id, Date date, List<Team> teams, List<Person> currentPlayers) {
		this.id = id;
		this.date = date;
		this.teams = teams;
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

	public void addCurrentPlayers(Person person) {
		this.currentPlayers.add(person);
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

	public List<Team> generateTeams(){
		Random random = new Random();
		List<Person> playersToAdd = currentPlayers;
		List<Person> currentTeam = new ArrayList<>();
		List<Team> generatedTeams = new ArrayList<>();

		for(int u = 0; u < currentPlayers.size()/5; u++) {
			for (int i = 0; i < 4; i++) {
				int randomNum = random.nextInt(playersToAdd.size());
				currentTeam.add(playersToAdd.get(randomNum));
				playersToAdd.remove(randomNum);
				String teamName = "Team "+u+1;
				generatedTeams.add(new Team(null, teamName, currentTeam));
			}
		}

		return generatedTeams;
	}
}
