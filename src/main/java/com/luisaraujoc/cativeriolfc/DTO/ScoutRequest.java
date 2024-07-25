package com.luisaraujoc.cativeriolfc.DTO;

public class ScoutRequest {

    private Long teamId;

    private Long gameId;

    private Long personId;

    private Integer goals;

    private Integer assists;

    private Integer yellowCard;

    private Integer redCard;

    public ScoutRequest() {
    }

    public ScoutRequest(Long teamId, Long gameId, Long personId, Integer goals, Integer assists, Integer yellowCard, Integer redCard) {
        this.teamId = teamId;
        this.gameId = gameId;
        this.personId = personId;
        this.goals = goals;
        this.assists = assists;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(Integer yellowCard) {
        this.yellowCard = yellowCard;
    }

    public Integer getRedCard() {
        return redCard;
    }

    public void setRedCard(Integer redCard) {
        this.redCard = redCard;
    }
}
