package com.luisaraujoc.cativeriolfc.Entity;

import java.util.List;
import java.util.Objects;

public class CurrentPlayer {

    private Integer id;
    private List<Person> people;
    private List<GameDay> gameDayList;

    public CurrentPlayer() {

    }

    public CurrentPlayer(Integer id, List<Person> people, List<GameDay> gameDayList) {
        this.id = id;
        this.people = people;
        this.gameDayList = gameDayList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<GameDay> getGameDayList() {
        return gameDayList;
    }

    public void setGameDayList(List<GameDay> gameDayList) {
        this.gameDayList = gameDayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentPlayer that = (CurrentPlayer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CurrentPlayer{" +
                "id=" + id +
                ", people=" + people +
                ", gameDayList=" + gameDayList +
                '}';
    }
}
