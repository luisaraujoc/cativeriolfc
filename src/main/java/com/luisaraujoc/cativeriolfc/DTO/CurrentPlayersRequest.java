package com.luisaraujoc.cativeriolfc.DTO;

import java.util.List;

public class CurrentPlayersRequest {
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

    @Override
    public String toString() {
        return "CurrentPlayersRequest{" +
                "gameDayId=" + gameDayId +
                ", playerId=" + playerId +
                '}';
    }
}
