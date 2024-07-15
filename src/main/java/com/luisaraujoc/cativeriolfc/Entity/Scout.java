package com.luisaraujoc.cativeriolfc.Entity;

public class Scout {

    private long id;

    private Long playerId;

    private Long gameId;

    private Long teamId;

    private int goals;

    private int assists;

    private int yellowCard;

    private int redCard;

    public Scout() {
    }

    public Scout(long id, Long playerId, Long gameId, Long teamId, int goals, int assists, int yellowCard, int redCard) {
        this.id = id;
        this.playerId = playerId;
        this.gameId = gameId;
        this.teamId = teamId;
        this.goals = goals;
        this.assists = assists;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }
    
}