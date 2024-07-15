package com.luisaraujoc.cativeriolfc.DTO;

public class ScoutRequest {

    private Long teamId;

    private Long gameId;

    private Long personId;

    private Integer goals;

    private Integer assists;

    private Integer yellowCard;

    private Integer redCard;

    public Long getTeamId() {
        return teamId;
    }

    public Long getGameId() {
        return gameId;
    }

    public Long getPersonId() {
        return personId;
    }

    public Integer getGoals() {
        return goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getYellowCard() {
        return yellowCard;
    }

    public Integer getRedCard() {
        return redCard;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public void setYellowCard(Integer yellowCard) {
        this.yellowCard = yellowCard;
    }

    public void setRedCard(Integer redCard) {
        this.redCard = redCard;
    }
}
