package com.luisaraujoc.cativeriolfc.DTO;

import com.luisaraujoc.cativeriolfc.Entity.Person;

public class SortTeamRequest {

    private Long GameDayId;
    private Long personId;

    public Long getGameDayId() {
        return GameDayId;
    }

    public void setGameDayId(Long gameDayId) {
        GameDayId = gameDayId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
