package com.luisaraujoc.cativeriolfc.DTO;

import java.util.List;

public class CurrentPlayersRequest {

    private Long personId;
    private String password;
    private Long gameDayId;
    private List<Long> playerId;

    public Long getGameDayId() {
        return gameDayId;
    }

    public void setGameDayId(Long gameDayId) {
        this.gameDayId = gameDayId;
    }

    public List<Long> getPlayerId() {
        return playerId;
    }

    public void setPlayerId(List<Long> playersId) {
        this.playerId = playersId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CurrentPlayersRequest{" +
                "gameDayId=" + gameDayId +
                ", playerId=" + playerId +
                '}';
    }
}
